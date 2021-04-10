package cn.wang.manage.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Program: student_manage
 * @Description:
 * @Author: wei.wang
 * @Date: 2021-04-10 18:12
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class StudentQuery extends PageQuery {

    String keywords;
}
