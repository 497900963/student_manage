package cn.wang.manage.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.wang.manage.dao.StudentDao;
import cn.wang.manage.entity.Student;
import cn.wang.manage.service.StudentService;
import cn.wang.manage.vo.StudentDTO;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author wangwei
 * @since 2021-04-10
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentDao, Student> implements StudentService {


    private final StudentDao studentDao;

    public StudentServiceImpl(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public void saveStudent(StudentDTO studentDTO) {
        Student student = new Student();
        BeanUtil.copyProperties(studentDTO, student);
        if (StringUtils.isNotBlank(student.getId())) {
            studentDao.updateById(student);
            return;
        }
        studentDao.insert(student);
    }
}
