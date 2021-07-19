package com.example.demo.repair.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
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
 * @since 2021-07-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class OsRepair implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 模块key
     */
    private String modular;

    private Integer uid;

    private Integer areaId;

    /**
     * 物业公司ID
     */
    private Integer propertyId;

    private Integer villageuserId;

    private String name;

    private String mobile;

    private Integer typeId;

    private String type;

    private String content;

    private String images;

    private Boolean status;

    /**
     * 标色
     */
    private String color;

    /**
     * 四个平台回复内容
     */
    private String coopComment;

    /**
     * 四个平台事件ID
     */
    @TableField("eventId")
    private String eventId;

    /**
     * 标题
     */
    @TableField("eventSubject")
    private String eventSubject;

    /**
     * 事件时间
     */
    @TableField("eventDate")
    private LocalDate eventDate;

    /**
     * 事件地点
     */
    @TableField("eventLocation")
    private String eventLocation;

    /**
     * 事件分类等级
     */
    @TableField("eventLevel")
    private Integer eventLevel;

    /**
     * 事件来源方式
     */
    @TableField("eventSource")
    private String eventSource;

    /**
     * 是否重点场所 1是 0否
     */
    @TableField("isImpplace")
    private Boolean isImpplace;

    /**
     * 经度
     */
    @TableField("longiTude")
    private String longiTude;

    /**
     * 纬度
     */
    @TableField("latiTude")
    private String latiTude;

    /**
     * 事件编码 四个平台的编码
     */
    @TableField("firstCategoryId")
    private String firstCategoryId;

    /**
     * 事件代码
     */
    @TableField("secondCategoryId")
    private String secondCategoryId;

    /**
     * 事件状态
     */
    private Integer coopStatus;

    /**
     * 处理者登录名称
     */
    @TableField("userLoginName")
    private String userLoginName;

    /**
     * 处理者名称
     */
    @TableField("userName")
    private String userName;

    /**
     * 上报人联系电话
     */
    private String coopMobile;

    @TableField("relatePeopleCount")
    private Integer relatePeopleCount;

    /**
     * 上报人的组织机构编码
     */
    @TableField("orgInternalCode")
    private String orgInternalCode;

    @TableField("accessIdentity")
    private String accessIdentity;

    private String reply;

    /**
     * 处理回复照片
     */
    private String rImages;

    /**
     * 回复时间
     */
    private LocalDateTime replyTime;

    private LocalDateTime createTime;

    private String deleteTime;

    /**
     * 客户端ID
     */
    private String clientId;

    @TableField("serialNumber")
    private String serialNumber;

    /**
     * 1是网格处理，2是物业处理
     */
    private Integer identity;

    /**
     * 流转到物业的时间
     */
    private LocalDateTime zhuanTime;

    /**
     * 是否完结，0是未处理，1是已处理待确认，2是已评价完结
     */
    private Integer isover;

    /**
     * 记录上报到4个平台时的时间
     */
    @TableField("eventTime")
    private LocalDateTime eventTime;


}
