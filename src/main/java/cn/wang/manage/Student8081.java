package cn.wang.manage;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

/**
 * @Program: student_manage
 * @Description:
 * @Author: wei.wang
 * @Date: 2021-04-10 17:12
 */
@MapperScan(value = "cn.wang.manage.dao")
@SpringBootApplication
public class Student8081 {
    public static void main(String[] args) {
        SpringApplication.run(Student8081.class);
    }
}
