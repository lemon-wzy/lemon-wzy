package com.example.demo.proComment.service.impl;

import com.example.demo.area.service.IOsAreaService;
import com.example.demo.proComment.dto.OsPropertyCommentDto;
import com.example.demo.proComment.entity.OsPropertyComment;
import com.example.demo.proComment.mapper.OsPropertyCommentMapper;
import com.example.demo.proComment.service.IOsPropertyCommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.poi.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lichi
 * @since 2021-07-15
 */
@Service
public class OsPropertyCommentServiceImpl extends ServiceImpl<OsPropertyCommentMapper, OsPropertyComment> implements IOsPropertyCommentService {

    @Autowired
    private IOsAreaService iOsAreaService;

    @Override
    public List<List<OsPropertyCommentDto>> getPropertyCommentList() {
        List<Integer> areaList = iOsAreaService.getAreaId();
        List<Integer> commentIdList = baseMapper.getCommentIdTen(areaList);
        List<List<OsPropertyCommentDto>> list = new ArrayList<>();
        for (Integer commentId : commentIdList){
            List<OsPropertyCommentDto> osPropertyCommentList = baseMapper.getCommentByProId(commentId);
            list.add(osPropertyCommentList);
        }
        return list;
    }

}
