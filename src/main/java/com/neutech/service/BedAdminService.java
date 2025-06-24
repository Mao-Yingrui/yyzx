package com.neutech.service;

import com.neutech.entity.Bed;

import java.util.List;

public interface BedAdminService {
    List<Bed> listFreeBeds();
    boolean assignBed(Integer bedId, String userId);
    List<Bed> listOccupiedBeds();
}