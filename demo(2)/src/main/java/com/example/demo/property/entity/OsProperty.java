package com.example.demo.property.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author lichi
 * @since 2021-07-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class OsProperty implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 所属小区id
     */
    private Integer areaId;

    private String name;

    /**
     * 头像照片
     */
    private String avatar;

    private String mobile;

    private Float point;

    private String comstr;

    private Float securityPoint;

    private Float hygienePoint;

    private Float servicePoint;

    private Float facilitiesPoint;

    private Float repairPoint;

    private Float greenPoint;

    /**
     * 评论人数
     */
    private Integer commentnum;

    /**
     * 折扣
     */
    private String discount;

    /**
     * 网格书记
     */
    private String wgsj;

    /**
     * 网格长
     */
    private String wgz;

    /**
     * 业委会主任
     */
    private String ywhzr;

    /**
     * 组团联社
     */
    private String ztls;

    /**
     * 等级
     */
    private Integer grade;

    /**
     * 小区信息
     */
    private String content;

    /**
     * 小区支部介绍
     */
    private String infoBranch;

    /**
     * 业委会介绍
     */
    private String infoCommittee;

    /**
     * 物业公司介绍
     */
    private String infoProperty;

    /**
     * 网格介绍
     */
    private String infoGrid;

    /**
     * 组团联社介绍
     */
    private String infoGroup;

    /**
     * 服务合同
     */
    private String contract;

    /**
     * 法律法规
     */
    private String statute;

    /**
     * 网格支部信息
     */
    private String branch;

    /**
     * 物业公司级别
     */
    private Boolean level;

    /**
     * 1正常2屏蔽
     */
    private Boolean status;

    /**
     * 排序
     */
    private Integer sort;

    private LocalDateTime createTime;

    private String deleteTime;


}
