package cn.wang.manage.controller;


import cn.wang.manage.config.ResultJson;
import cn.wang.manage.entity.Student;
import cn.wang.manage.service.StudentService;
import cn.wang.manage.vo.StudentDTO;
import cn.wang.manage.vo.StudentQuery;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author wangwei
 * @since 2021-04-10
 */
@Controller
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    @ResponseBody
    public ResultJson save(@Validated StudentDTO student) {
        studentService.saveStudent(student);
        return ResultJson.ok();
    }


    @GetMapping("/{id}")
    @ResponseBody
    public ResultJson detail(@PathVariable String id) {
        return ResultJson.ok(studentService.getById(id));
    }


    @GetMapping
    @ResponseBody
    public ResultJson pageList(StudentQuery studentQuery) {
        IPage<Student> page = new Page<>(studentQuery.getPageNo(), studentQuery.getPageSize());
        LambdaQueryWrapper<Student> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(StringUtils.isNotBlank(studentQuery.getKeywords())
                , Student::getName, studentQuery.getKeywords()
        );
        return ResultJson.ok(studentService.page(page, wrapper));
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public ResultJson delete(@PathVariable String id) {
        studentService.removeById(id);
        return ResultJson.ok();
    }

    @GetMapping("index")
    public String index(){
        return "index";
    }
}

