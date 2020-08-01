package com.pan.handler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pan.exception.BaseException;
import com.pan.utils.ExceptionResult;
import com.pan.utils.ResponseResult;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@RestControllerAdvice
public class PanResponseHandler implements ResponseBodyAdvice<Object> {


    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        ResponseResult responseResult = new ResponseResult(body);
        ObjectMapper objectMapper = new ObjectMapper();
        if(body instanceof ExceptionResult){
            System.out.println("BaseException");
            return  body;
        }
        try {
            System.out.println("!BaseException");
            return objectMapper.writeValueAsString(responseResult);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println("responseResult");

        return responseResult;
    }
}
