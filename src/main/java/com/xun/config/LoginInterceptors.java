package com.xun.config;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录拦截器
 */
public class LoginInterceptors implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest request,HttpServletResponse response ,Object o) throws Exception {
        request.setCharacterEncoding("UTF-8");
        StringBuffer requestURL = request.getRequestURL();
        if (requestURL.toString().contains("sang")&&!requestURL.toString().contains("sang/login")&&!request.toString().contains("sang/dologin")){
            Object user = request.getSession().getAttribute("user");
            if (user==null){
                response.sendRedirect("/sang/login");
                return false;
            }else {
                return true;
            }
        }else{
            return true;
        }
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object o, ModelAndView modelAndView) throws Exception{}

    public void afterCompletion(HttpServletRequest request,HttpServletResponse response,Object o,Exception e) throws Exception{}
}
