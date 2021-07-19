package com.example.demo.proComment.service;

import com.example.demo.proComment.dto.OsPropertyCommentDto;
import com.example.demo.proComment.entity.OsPropertyComment;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lichi
 * @since 2021-07-15
 */
public interface IOsPropertyCommentService extends IService<OsPropertyComment> {

    List<List<OsPropertyCommentDto>> getPropertyCommentList();


}
