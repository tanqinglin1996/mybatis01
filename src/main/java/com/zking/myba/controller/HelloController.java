package com.zking.myba.controller;

import com.zking.myba.model.Book;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HelloController {


   //请求处理方法
    @RequestMapping("/hello")
    public String hello(Book book){
        System.out.println(book);
        return "index";
    }
//非请求处理方法
    @ModelAttribute
    public ModelAndView cc(){
        System.out.println("你调用了ModelAndView");
        return new ModelAndView();
    }

    @RequestMapping("/ff")
    public String hello(HttpServletRequest request){
        System.out.println(request.getRequestURI());
        return "index";
    }


}
