package shiro.demo.modules.area.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author jobob
 * @since 2021-07-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class OsArea implements Serializable {

    private static final long serialVersionUID = 1L;

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


}
