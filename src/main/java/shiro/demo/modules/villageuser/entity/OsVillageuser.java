package shiro.demo.modules.villageuser.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
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
public class OsVillageuser implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer areaId;

    private String mobile;

    /**
     * 幢
     */
    private String block;

    /**
     * 单元
     */
    private String unit;

    /**
     * 室
     */
    private String room;

    /**
     * 面积
     */
    private String acreage;

    /**
     * 物业月费
     */
    private BigDecimal price;

    /**
     * 服务到期时间
     */
    private LocalDate serviceEnd;

    /**
     * 1正常、2空户、3公房、4出租、5老巢
     */
    private Boolean vastatus;

    /**
     * 关系
     */
    private String relation;

    private String deleteTime;


}
