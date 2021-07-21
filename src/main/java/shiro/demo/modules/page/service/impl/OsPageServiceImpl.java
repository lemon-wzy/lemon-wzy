package shiro.demo.modules.page.service.impl;

import shiro.demo.modules.page.entity.OsPage;
import shiro.demo.modules.page.mapper.OsPageMapper;
import shiro.demo.modules.page.service.IOsPageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jobob
 * @since 2021-07-21
 */
@Service
public class OsPageServiceImpl extends ServiceImpl<OsPageMapper, OsPage> implements IOsPageService {

}
