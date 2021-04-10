package cn.wang.manage.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @Program: student_manage
 * @Description:
 * @Author: wei.wang
 * @Date: 2021-04-10 17:51
 */
@Data
public class StudentDTO {


    private String id;

    @NotBlank(message = "姓名不能为空")
    private String name;

    private Integer age;

    private String sex;

    private String classId;
}
