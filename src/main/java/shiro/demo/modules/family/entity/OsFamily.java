package shiro.demo.modules.family.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
public class OsFamily implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 业主ID
     */
    private Integer uid;

    /**
     * 房屋ID
     */
    private Integer villageuserId;

    /**
     * 亲属手机号码
     */
    private String mobile;

    private String name;

    /**
     * 类型
     */
    private Integer typeId;

    /**
     * 其它联系方式
     */
    private String otherLink;

    /**
     * 现居住地址
     */
    private String address;

    /**
     * 备注
     */
    private String remark;

    /**
     * 1居住，0未居住
     */
    private Boolean isLive;

    private String photo;

    private String sex;

    /**
     * 生日
     */
    private LocalDate birthday;

    private Integer relationId;

    /**
     * 于relation_id关系
     */
    private Integer toRelationId;

    /**
     * 身份证号码
     */
    private String cardno;

    /**
     * 党员1是，0不是
     */
    private Boolean party;

    /**
     * 民族
     */
    private String nation;

    /**
     * 学历
     */
    private Integer education;

    /**
     * 工作单位
     */
    private String work;

    /**
     * 工作状态
     */
    private String workStatus;

    /**
     * 未婚，已婚，离异
     */
    private String marriage;

    /**
     * 户籍登记地
     */
    private String censusReg;

    /**
     * 残疾（残疾证号)
     */
    private String disabilityCard;

    /**
     * 是否低保人员
     */
    private Boolean isAllowances;

    /**
     * 是否退役人员
     */
    private Boolean isRetire;

    /**
     * 是否重点人员
     */
    private Boolean isStress;

    /**
     * 重点人员类型(选填)
     */
    private String stressType;

    /**
     * 车牌号
     */
    private String licensePlate;

    private LocalDateTime createTime;

    private String deleteTime;


}
