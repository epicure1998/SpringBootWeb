package com.qiumengke.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {
    @RequestMapping("/user/login")
    //@ResponseBody
    public String login(@RequestParam("username") String name,
                        @RequestParam("password") String password,
                        Model model,
                        HttpServletRequest request){
        System.out.println(name+"::"+password);
        if(name.equals("qiumengke")&& password.equals("123456")) {
              request.getSession().setAttribute("user",name);
              return "redirect:/main.html";
        }
        else {
            model.addAttribute("msg","用户名或者密码有错误");
            return "index";

        }
    }
}
