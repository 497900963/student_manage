package cn.wang.manage.service.impl;

import cn.wang.manage.entity.Class;
import cn.wang.manage.dao.ClassDao;
import cn.wang.manage.service.ClassService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wangwei
 * @since 2021-04-10
 */
@Service
public class ClassServiceImpl extends ServiceImpl<ClassDao, Class> implements ClassService {

}
