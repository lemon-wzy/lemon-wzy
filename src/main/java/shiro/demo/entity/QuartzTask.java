package shiro.demo.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;

/**
 * @author lichi
 */

@Data
@TableName("quartz_task")
public class QuartzTask {
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    private String type;

    private String jobGroup;

    private String jobName;

    private String invokeParam;

    private String quartzTime;

    private String status;

    @TableField("execute_end_time")
    private Date executeEndtime;

    @TableLogic
    private Integer isDelete;


}
