package com.qiumengke.Controller;

import org.apache.catalina.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LogoutController {
    @RequestMapping("/logout")
    public String logout(HttpServletRequest request){
        HttpSession session=request.getSession();
        session.removeAttribute("user");
        System.out.println("tttttt");
        return "index";
    }
}
