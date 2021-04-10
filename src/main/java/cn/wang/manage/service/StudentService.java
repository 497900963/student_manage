package cn.wang.manage.service;

import cn.wang.manage.entity.Student;
import cn.wang.manage.vo.StudentDTO;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author wangwei
 * @since 2021-04-10
 */
public interface StudentService extends IService<Student> {

    void saveStudent(StudentDTO student);
}
