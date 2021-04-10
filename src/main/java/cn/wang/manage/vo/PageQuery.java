package cn.wang.manage.vo;

import lombok.Data;

/**
 * @Program: student_manage
 * @Description:
 * @Author: wei.wang
 * @Date: 2021-04-10 18:11
 */
@Data
public class PageQuery {

    private Long pageSize = 10L;
    private Long pageNo = 1L;
}
