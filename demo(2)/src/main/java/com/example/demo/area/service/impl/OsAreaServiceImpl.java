package com.example.demo.area.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.area.entity.OsArea;
import com.example.demo.area.mapper.OsAreaMapper;
import com.example.demo.area.service.IOsAreaService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lichi
 * @since 2021-07-13
 */
@Service
public class OsAreaServiceImpl extends ServiceImpl<OsAreaMapper, OsArea> implements IOsAreaService {

    @Override
    public List<Integer> getAreaId() {
        return baseMapper.getAreaId();
    }

}
