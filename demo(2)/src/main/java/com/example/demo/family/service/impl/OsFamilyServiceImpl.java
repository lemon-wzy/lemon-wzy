package com.example.demo.family.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.demo.family.entity.OsFamily;
import com.example.demo.family.mapper.OsFamilyMapper;
import com.example.demo.family.service.IOsFamilyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lichi
 * @since 2021-07-09
 */
@Service
public class OsFamilyServiceImpl extends ServiceImpl<OsFamilyMapper, OsFamily> implements IOsFamilyService {

    @Override
    public List<OsFamily> selectListWithCardNo() {
        return baseMapper.selectList(Wrappers.<OsFamily>query().lambda().ne(OsFamily::getCardno,"").isNull(OsFamily::getBirthday).isNull(OsFamily::getDeleteTime));
    }
}
