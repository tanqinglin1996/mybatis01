package com.zking.myba.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller
@RequestMapping("/")
public class LoginController {

    @RequestMapping("/ee")
    public String goLogin(){
        return "login";
    }


    /**
     * 重定向
     * @return
     */
    @RequestMapping("/aa")
    public String login1()throws Exception{
        return "redirect:ee";
    }

    /**
     * 转发
     * @return
     */
    @RequestMapping("/bb")
    public String login2(){

        return "forward:/WEB-INF/jsp/login.jsp";
    }


}
