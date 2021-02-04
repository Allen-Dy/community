package com.nowcoder.community.controller;

import com.nowcoder.community.dao.UserMapper;
import com.nowcoder.community.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@Controller
@RequestMapping("/alpha")
public class AlphaHello {

    @Resource
    private UserMapper userMapper;

    @RequestMapping("/queryUser")
    @ResponseBody
    public User queryUser(){
        User users = userMapper.selectById(1);
        return users;
    }

    @RequestMapping("/hello")
    @ResponseBody
    public String sayHello() {
        return "Hello SpringBoot";
    }

    @RequestMapping("/http")
    public void http(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
        System.out.println(httpServletRequest.getMethod());
        System.out.println(httpServletRequest.getServletPath());
        Enumeration<String> headerNames = httpServletRequest.getHeaderNames();
        while(headerNames.hasMoreElements()) {
            String name = headerNames.nextElement();
            String value = httpServletRequest.getHeader(name);
            System.out.println(name + "--------------" + value);
        }

        System.out.println(httpServletRequest.getParameter("code"));


        //返回响应数据
        httpServletResponse.setContentType("text/html;charset=utf-8");
        try (PrintWriter writer = httpServletResponse.getWriter()) {
            writer.write("<h1>牛客网</h1>");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    //GET请求
    // /students?current=2&name=Allen
    @RequestMapping(path="/gethttp",method = RequestMethod.GET)
    @ResponseBody
    public String getHttp(
            @RequestParam(name = "current",required = false,defaultValue = "100") String currentt,
            @RequestParam(name = "name",required = false,defaultValue = "dengy") String namee){
        System.out.println(currentt);
        System.out.println(namee);
        return "gethttp";
    }

    // /students?current=2&name=Allen
    @RequestMapping("/gethttp2/{id}")
    @ResponseBody
    public String getHttp2(@PathVariable("id") String id){
        System.out.println(id);
        return "gethttp2";
    }

    @RequestMapping(path = "/student",method = RequestMethod.POST)
    @ResponseBody
    public String addStudent(String name,String age){
        System.out.println(name);
        System.out.println(age);
        return "gethttp2";
    }


    //响应html数据
    @RequestMapping(path = "/teacher",method = RequestMethod.GET)
    public ModelAndView addTeacher(String name, String age){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("name",name);
        modelAndView.addObject("age",age);
        modelAndView.setViewName("/demo/view");

        return modelAndView;
    }

    @RequestMapping(path = "/school",method = RequestMethod.GET)
    public String addSchool(Model model){
        model.addAttribute("name","哈佛大学");
        model.addAttribute("age",100);
        return "/demo/view";
    }

    //异步请求
    //JSON
    //Java对象  JSON  JS对象
//    {name:12,age:1231,3213123}
//    {312,12321,[321312312,312]}
    @RequestMapping(path = "/msg",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> msg(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("name","zhangshan");
        map.put("age",13);
        map.put("salary",15000.00);

        return map;
    }

    @RequestMapping(path = "/msgs",method = RequestMethod.GET)
    @ResponseBody
    public List<Map<String,Object>> msgs(){
        List<Map<String, Object>> maps = new ArrayList<>();

        HashMap<String, Object> map = new HashMap<>();
        map.put("name","zhangshan");
        map.put("age",13);
        map.put("salary",13000.00);
        maps.add(map);

        map = new HashMap<>();
        map.put("name","lisi");
        map.put("age",15);
        map.put("salary",15000.00);
        maps.add(map);

        map = new HashMap<>();
        map.put("name","wangwu");
        map.put("age",17);
        map.put("salary",17000.00);
        maps.add(map);
        return maps;
    }


}
