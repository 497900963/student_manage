package cn.wang.manage.dao;


import cn.wang.manage.entity.Student;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author wangwei
 * @since 2021-04-10
 */
@Mapper
public interface StudentDao extends BaseMapper<Student> {

}
