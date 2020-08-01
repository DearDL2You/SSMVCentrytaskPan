package com.pan.controller;

import com.pan.enums.BaseExceptionEunm;
import com.pan.exception.BaseException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/shopee")
public class ShopeeController {

    /*@GetMapping("/test")
    public @ResponseBody Object PanAction(@RequestParam(value = "a") int a, @RequestParam(value = "b")  String b){
        System.out.println("=================" + a + "---" + b);
        if("null".equals(String.valueOf(a)))
            throw  new BaseException(BaseExceptionEunm.PARAMS_ERRCODE);
        if(b == null || b.length() <= 0)
            throw  new BaseException(BaseExceptionEunm.PARAMS_ERRCODE);

        String resultStr = "No." + a + " is " + b;
        return  resultStr;
    }*/

    @GetMapping("/test")
    public @ResponseBody Object PanRequest(HttpServletRequest request){
        String url = request.getRequestURL().toString();
        if (null == url || url.length() <= 0)
            throw  new BaseException(BaseExceptionEunm.PARAMS_ERRCODE);
        Map requestMap = getAllRequestParam(request);
        System.out.println( "======size===" + requestMap.size());
        if(null != requestMap && requestMap.size() > 2)
            throw  new BaseException(BaseExceptionEunm.PARAMS_ERRCODE_MODE);
        String a = request.getParameter("a");
        String b = request.getParameter("b");
        System.out.println("----" + a + " == " + b);
        if(null == a || a.length() <= 0 || null == b || b.length() <= 0)
            throw  new BaseException(BaseExceptionEunm.PARAMS_ERRCODE);
        try{
            Integer.parseInt(a);
        }catch (NumberFormatException e){
            System.out.println("类型转换异常");
            throw  new BaseException(BaseExceptionEunm.PARAMS_ERRCODE);
        }
        String resultStr = "No." + a + " is " + b;
        return  resultStr;
    }

    /**
     * 获取客户端请求参数中所有的信息
     * @param request
     * @return
     */
    private Map<String, String> getAllRequestParam(final HttpServletRequest request) {
        Map<String, String> res = new HashMap<String, String>();
        Enumeration<?> temp = request.getParameterNames();
        if (null != temp) {
            while (temp.hasMoreElements()) {
                String en = (String) temp.nextElement();
                String value = request.getParameter(en);
                res.put(en, value);
            }
        }
        return res;
    }
}
