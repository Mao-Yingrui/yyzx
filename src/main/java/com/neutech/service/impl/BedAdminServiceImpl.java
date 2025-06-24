package com.neutech.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.neutech.entity.Bed;
import com.neutech.mapper.BedAdminMapper;
import com.neutech.service.BedAdminService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BedAdminServiceImpl extends ServiceImpl<BedAdminMapper, Bed> implements BedAdminService {
    private final BedAdminMapper bedAdminMapper;

    public BedAdminServiceImpl(BedAdminMapper bedAdminMapper) {
        this.bedAdminMapper = bedAdminMapper;
    }

    @Override
    public List<Bed> listFreeBeds() {
        return this.bedAdminMapper.selectFreeBeds();
    }

    @Override
    public boolean assignBed(Integer bedId, String userId) {
        Bed bed = this.bedAdminMapper.selectBedById(bedId);
        if (bed == null || !"空闲".equals(bed.getStatus())) {
            return false;
        }
        return this.bedAdminMapper.updateBedStatusAndUser(bedId, userId) > 0;
    }

    @Override
    public List<Bed> listOccupiedBeds() {
        return this.bedAdminMapper.selectList(new QueryWrapper<Bed>().eq("status", "已占满"));
    }
}