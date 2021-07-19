package com.example.demo.proComment.entity;

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
public class OsPropertyComment implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer uid;

    /**
     * 小区ID
     */
    private Integer areaId;

    /**
     * 物业公司ID
     */
    private Integer propertyId;

    private Integer villageuserId;

    /**
     * 综合评分
     */
    private Integer point;

    /**
     * 公共区域秩序维护
     */
    private Integer securityPoint;

    /**
     * 公共区域卫生环境
     */
    private Integer hygienePoint;

    /**
     * 物业服务信息公示
     */
    private Integer servicePoint;

    /**
     * 公共设施设备维护
     */
    private Integer facilitiesPoint;

    /**
     * 业主反映问题处置
     */
    private Integer repairPoint;

    /**
     * 公共区域绿化养护
     */
    private Integer greenPoint;

    private String comstr;

    private String content;

    /**
     * 回复
     */
    private String reply;

    /**
     * 回复时间
     */
    private LocalDateTime replyTime;

    private String images;

    /**
     * 0不匿名，1匿名
     */
    private Boolean anonymous;

    /**
     * 1正常，2屏蔽
     */
    private Boolean status;

    private LocalDateTime createTime;

    private String deleteTime;

    /**
     * 客户端ID
     */
    private String clientId;


}
