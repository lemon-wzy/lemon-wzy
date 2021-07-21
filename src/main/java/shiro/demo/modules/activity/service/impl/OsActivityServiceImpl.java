package shiro.demo.modules.activity.service.impl;

import shiro.demo.modules.activity.entity.OsActivity;
import shiro.demo.modules.activity.mapper.OsActivityMapper;
import shiro.demo.modules.activity.service.IOsActivityService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 文章表 服务实现类
 * </p>
 *
 * @author jobob
 * @since 2021-07-21
 */
@Service
public class OsActivityServiceImpl extends ServiceImpl<OsActivityMapper, OsActivity> implements IOsActivityService {

}
