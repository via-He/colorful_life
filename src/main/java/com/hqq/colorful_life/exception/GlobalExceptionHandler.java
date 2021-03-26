package com.hqq.colorful_life.exception;

import com.hqq.colorful_life.common.ApiRestResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Qingqing.He
 * @date 2020/12/29 15:12
 * 描述：处理统一系统异常
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    private final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(java.lang.Exception.class)
    @ResponseBody
    public Object handleException(java.lang.Exception e){
        log.error("Default Exception:",e);
        return ApiRestResponse.error(ExceptionEnum.SYSTEM_ERROR);

    }

    @ExceptionHandler(UniteException.class)
    @ResponseBody
    public Object handleUniteException(UniteException ex){
        log.error("UniteException:",ex);
        return ApiRestResponse.error(ex.getCode(),ex.getMessage());

    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ApiRestResponse handleMethodArgumentNotValidException(MethodArgumentNotValidException e){
        log.error("MethodArgumentNotValidException",e);
        return handleBindingResult(e.getBindingResult());

    }

    private ApiRestResponse handleBindingResult(BindingResult result){
        //把异常处理为对外暴露的提示
        List<String> list = new ArrayList<>();
        //是否包含错误
        if (result.hasErrors()) {
            List<ObjectError> allErrors = result.getAllErrors();
            for (ObjectError objectError : allErrors) {
                String message = objectError.getDefaultMessage();
                list.add(message);
            }

        }
        if (list.size() == 0) {
            return ApiRestResponse.error(ExceptionEnum.REQUEST_PARAM_ERROR);
        }
        return ApiRestResponse.error(ExceptionEnum.REQUEST_PARAM_ERROR.getCode(),list.toString());

    }
}
