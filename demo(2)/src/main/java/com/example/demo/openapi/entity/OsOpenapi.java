package com.example.demo.openapi.entity;

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
 * @since 2021-07-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class OsOpenapi implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String appid;

    private String secret;

    /**
     * 区域ID,0为全部
     */
    private Integer areaId;

    /**
     * 党支部部门节点
     */
    private Integer departmentId;

    /**
     * 1正常，0关闭
     */
    private Boolean status;

    private LocalDateTime createTime;


}
