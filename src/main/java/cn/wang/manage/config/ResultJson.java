package cn.wang.manage.config;

import lombok.Data;

/**
 * @Program: k9_tms
 * @Description: 统一返回结果
 * @Author: wei.wang
 * @Date: 2021-04-05 18:16
 **/

@Data
public class ResultJson {
    private Integer code;
    private String msg;
    private Object data;

    public static ResultJson ok() {
        ResultJson resultJson = new ResultJson();

        resultJson.code = 200;
        resultJson.msg = "操作成功";

        return resultJson;
    }

    public static ResultJson ok(Object data) {
        ResultJson resultJson = new ResultJson();

        resultJson.code = 200;
        resultJson.msg = "操作成功";
        resultJson.data = data;

        return resultJson;
    }

    public static ResultJson err(Integer code, String msg){
        ResultJson resultJson = new ResultJson();

        resultJson.code = code;
        resultJson.msg = msg;

        return resultJson;

    }

}
