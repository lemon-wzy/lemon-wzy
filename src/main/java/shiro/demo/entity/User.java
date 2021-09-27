package shiro.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import shiro.demo.utils.SFAttributeConverter;

import javax.persistence.Convert;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * user实体类
 * @author lichi
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("user")
public class User {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.ASSIGN_ID)
    private Integer id;

    @Convert(converter = SFAttributeConverter.class)
    private String username;

    @Convert(converter = SFAttributeConverter.class)
    private String password;

    @TableLogic
    private Integer isDelete;

    private Date createTime;


}
