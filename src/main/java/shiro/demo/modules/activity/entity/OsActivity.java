package shiro.demo.modules.activity.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 文章表
 * </p>
 *
 * @author jobob
 * @since 2021-07-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class OsActivity implements Serializable {

    private static final long serialVersionUID = 1L;

    private String areaIds;

    /**
     * 活动主题
     */
    private String title;

    /**
     * 地址
     */
    private String addr;

    private Float lng;

    private Float lat;

    /**
     * 经纬度字符串
     */
    private String latlng;

    private String tel;

    private Integer point;

    /**
     * 多少分钟算一次分，0一次性结算，
     */
    private Integer pointtime;

    /**
     * 允许报名的用户，1全部，2仅限志愿者参加，3仅限非志愿者
     */
    private Boolean usertype;

    /**
     * 报名开始时间
     */
    private LocalDateTime stardate;

    /**
     * 报名结束
     */
    private LocalDateTime enddate;

    /**
     * 活动开始时间，签到时间
     */
    private LocalDateTime actstartdate;

    /**
     * 活动结束时间
     */
    private LocalDateTime actenddate;

    /**
     * 活动具体内容
     */
    private String info;

    /**
     * 状态 0 待审核  1 审核
     */
    private Boolean status;

    /**
     * 阅读量
     */
    private Integer reading;

    /**
     * 最大报名人数
     */
    private Integer singmax;

    /**
     * 参与人数
     */
    private Integer singnum;

    /**
     * 当前签退人数
     */
    private Integer hasoutnum;

    /**
     * 当前签到人数
     */
    private Integer hassingnum;

    /**
     * 最大签到人数
     */
    private Integer usersingmax;

    private String thumb;

    /**
     * 图集
     */
    private String photo;

    /**
     * 活动内容
     */
    private String content;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 发布时间
     */
    private LocalDateTime publishTime;

    private String deleteTime;

    private Integer sort;


}
