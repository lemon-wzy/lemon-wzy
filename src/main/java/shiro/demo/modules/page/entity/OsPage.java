package shiro.demo.modules.page.entity;

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
public class OsPage implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 模块key
     */
    private String modular;

    /**
     * 调用标签
     */
    private String mark;

    private String areaIds;

    private String title;

    private String content;

    private String thumb;

    private Boolean status;

    private LocalDateTime createTime;

    private String deleteTime;


}
