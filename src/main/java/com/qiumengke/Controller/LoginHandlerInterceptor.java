package com.qiumengke.Controller;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object user=request.getSession().getAttribute("user");
        if(user!=null) {
            System.out.println(user.toString());
            return true;
        }
        else {
            request.setAttribute("msg","请先登陆");
            request.getRequestDispatcher("/index.html").forward(request,response);//请求转发业务
            return false;
        }
    }

}
