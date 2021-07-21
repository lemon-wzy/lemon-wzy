package shiro.demo.modules.family.service.impl;

import shiro.demo.modules.family.entity.OsFamily;
import shiro.demo.modules.family.mapper.OsFamilyMapper;
import shiro.demo.modules.family.service.IOsFamilyService;
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
public class OsFamilyServiceImpl extends ServiceImpl<OsFamilyMapper, OsFamily> implements IOsFamilyService {

}
