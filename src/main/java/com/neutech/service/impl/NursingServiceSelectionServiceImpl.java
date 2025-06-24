package com.neutech.service.impl;

import com.neutech.dto.NursingServiceSelectionDTO;
import com.neutech.entity.CareContent;
import com.neutech.entity.User;
import com.neutech.mapper.CareContentMapper;
import com.neutech.mapper.UserMapper;
import com.neutech.service.NursingServiceSelectionService;
import com.neutech.vo.ResultJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class NursingServiceSelectionServiceImpl implements NursingServiceSelectionService {

    @Autowired
    private CareContentMapper careContentMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    @Transactional
    public ResultJson processNursingServiceSelection(NursingServiceSelectionDTO selectionDTO, String idCard) {
        // 1. 查询用户信息，包括当前余额
        User user = userMapper.selectByIdCard(idCard);
        if (user == null) {
            return new ResultJson(404, null, "用户不存在");
        }

        // 2. 处理服务1的选择
        if (selectionDTO.getOne() != null && selectionDTO.getOneCount() != null) {
            int careId = selectionDTO.getOne();
            int count = selectionDTO.getOneCount();

            // 查询护理服务单价
            CareContent careContent = careContentMapper.selectCareContentById(careId);
            if (careContent == null) {
                return new ResultJson(400, null, "护理服务不存在");
            }

            double totalPrice = careContent.getCarePrice() * count;
            if (user.getBalance() < totalPrice) {
                return new ResultJson(400, null, "余额不足");
            }

            // 更新用户余额
            double newBalance = user.getBalance() - totalPrice;
            user.setBalance(Float.valueOf((float) newBalance));
            int updateResult = userMapper.updateUserBalance(idCard, newBalance);
            if (updateResult <= 0) {
                throw new RuntimeException("更新用户余额失败");
            }

            // TODO: 这里应该记录用户选择的护理服务到数据库
            // 例如调用userCareServiceMapper.insertOrUpdateUserCareService()
        }

        // 3. 处理服务2的选择
        if (selectionDTO.getTwo() != null && selectionDTO.getTwoCount() != null) {
            // 由于服务2是通过字符串标识的，需要先查询对应的careId
            // 这里简化处理，假设服务2的字符串可以直接映射到careId
            // 实际项目中可能需要查询映射表或根据业务逻辑确定careId
            Integer careId = getCareIdFromString(selectionDTO.getTwo());
            if (careId == null) {
                return new ResultJson(400, null, "护理服务不存在");
            }

            int count = selectionDTO.getTwoCount();
            CareContent careContent = careContentMapper.selectCareContentById(careId);
            if (careContent == null) {
                return new ResultJson(400, null, "护理服务不存在");
            }

            double totalPrice = careContent.getCarePrice() * count;
            if (user.getBalance() < totalPrice) {
                return new ResultJson(400, null, "余额不足");
            }

            // 更新用户余额
            double newBalance = user.getBalance() - totalPrice;
            user.setBalance(Float.valueOf((float) newBalance));
            int updateResult = userMapper.updateUserBalance(idCard, newBalance);
            if (updateResult <= 0) {
                throw new RuntimeException("更新用户余额失败");
            }

            // TODO: 记录用户选择的护理服务到数据库
        }

        // 4. 处理服务3的选择(与服务2类似)
        if (selectionDTO.getThree() != null && selectionDTO.getThreeCount() != null) {
            Integer careId = getCareIdFromString(selectionDTO.getThree());
            if (careId == null) {
                return new ResultJson(400, null, "护理服务不存在");
            }

            int count = selectionDTO.getThreeCount();
            CareContent careContent = careContentMapper.selectCareContentById(careId);
            if (careContent == null) {
                return new ResultJson(400, null, "护理服务不存在");
            }

            double totalPrice = careContent.getCarePrice() * count;
            if (user.getBalance() < totalPrice) {
                return new ResultJson(400, null, "余额不足");
            }

            // 更新用户余额
            double newBalance = user.getBalance() - totalPrice;
            user.setBalance(Float.valueOf((float) newBalance));
            int updateResult = userMapper.updateUserBalance(idCard, newBalance);
            if (updateResult <= 0) {
                throw new RuntimeException("更新用户余额失败");
            }

            // TODO: 记录用户选择的护理服务到数据库
        }

        // 5. 处理服务4的选择(与服务2类似)
        if (selectionDTO.getFour() != null && selectionDTO.getFourCount() != null) {
            Integer careId = getCareIdFromString(selectionDTO.getFour());
            if (careId == null) {
                return new ResultJson(400, null, "护理服务不存在");
            }

            int count = selectionDTO.getFourCount();
            CareContent careContent = careContentMapper.selectCareContentById(careId);
            if (careContent == null) {
                return new ResultJson(400, null, "护理服务不存在");
            }

            double totalPrice = careContent.getCarePrice() * count;
            if (user.getBalance() < totalPrice) {
                return new ResultJson(400, null, "余额不足");
            }

            // 更新用户余额
            double newBalance = user.getBalance() - totalPrice;
            user.setBalance(Float.valueOf((float) newBalance));
            int updateResult = userMapper.updateUserBalance(idCard, newBalance);
            if (updateResult <= 0) {
                throw new RuntimeException("更新用户余额失败");
            }

            // TODO: 记录用户选择的护理服务到数据库
        }

        // 6. 处理服务5的选择(与服务2类似)
        if (selectionDTO.getFive() != null && selectionDTO.getFiveCount() != null) {
            Integer careId = getCareIdFromString(selectionDTO.getFive());
            if (careId == null) {
                return new ResultJson(400, null, "护理服务不存在");
            }

            int count = selectionDTO.getFiveCount();
            CareContent careContent = careContentMapper.selectCareContentById(careId);
            if (careContent == null) {
                return new ResultJson(400, null, "护理服务不存在");
            }

            double totalPrice = careContent.getCarePrice() * count;
            if (user.getBalance() < totalPrice) {
                return new ResultJson(400, null, "余额不足");
            }

            // 更新用户余额
            double newBalance = user.getBalance() - totalPrice;
            user.setBalance(Float.valueOf((float) newBalance));
            int updateResult = userMapper.updateUserBalance(idCard, newBalance);
            if (updateResult <= 0) {
                throw new RuntimeException("更新用户余额失败");
            }

            // TODO: 记录用户选择的护理服务到数据库
        }

        // 7. 返回成功结果
        return new ResultJson(200, "选择成功", "选择成功");
    }

    /**
     * 根据服务字符串标识获取对应的careId
     * 这里简化处理，实际项目中可能需要查询映射表或根据业务逻辑确定
     */
    private Integer getCareIdFromString(String serviceString) {
        // 这里应该实现从字符串到careId的映射逻辑
        // 例如查询数据库表或使用预定义的映射关系
        // 由于没有具体映射规则，这里返回一个示例值
        // 实际项目中需要替换为真实的映射逻辑

        // 示例: 假设服务字符串是数字字符串，可以直接转换为careId
        try {
            return Integer.parseInt(serviceString);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}