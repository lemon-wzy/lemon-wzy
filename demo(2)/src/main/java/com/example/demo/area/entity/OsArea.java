package com.example.demo.area.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
public class OsArea implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 父ID
     */
    private Integer pid;

    private String name;

    /**
     * 路径
     */
    private String path;

    private Integer lev;

    /**
     * 类型，1普通小区，2特殊部门
     */
    private Boolean type;

    /**
     * 是否有物业管理，0非物管，1物管，2其他
     */
    private Integer isproperty;


}
