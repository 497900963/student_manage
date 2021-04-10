package cn.wang.manage.config;

import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Program: k9_tms
 * @Description:
 * @Author: wei.wang
 * @Date: 2021-04-05 19:01
 **/
@RestControllerAdvice
public class GlobalException {
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResultJson excHandler(Exception e){
        e.printStackTrace();
        return ResultJson.err(500,"未知异常，请联系管理员");
    }

    @ExceptionHandler({BindException.class, MethodArgumentNotValidException.class})
    @ResponseBody
    public ResultJson bindExceptionHandler(Exception e) {
        BindingResult result;
        if (e instanceof BindException) {
            result = ((BindException) e).getBindingResult();
        } else {
            result = ((MethodArgumentNotValidException) e).getBindingResult();
        }
        Map<String, String> messages = new HashMap<>(16);
        // 遍历所有字段的异常信息
        if (result.hasErrors()) {
            List<ObjectError> errors = result.getAllErrors();
            for (ObjectError error : errors) {
                FieldError fieldError = (FieldError) error;
                // 判断是否是某个字段转换失败
                if (fieldError.isBindingFailure()) {
                    messages.put(fieldError.getField(), "数据格式非法！");
                } else {
                    messages.put(fieldError.getField(), fieldError.getDefaultMessage());
                }
            }
        }
        return ResultJson.err(400,messages.toString());
    }
}
