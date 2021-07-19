package com.example.demo.proComment.dto;

import com.example.demo.proComment.entity.OsPropertyComment;
import lombok.Data;
import org.apache.poi.ss.formula.functions.T;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class OsPropertyCommentDto {

    /**
     * 物业公司ID
     */
    private Integer propertyId;

    /**
     * 综合评分
     */
    private Integer point;

    private String comstr;

    private LocalDateTime createTime;

    private String propertyName;

}
