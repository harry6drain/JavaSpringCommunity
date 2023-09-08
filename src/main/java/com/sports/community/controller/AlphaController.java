package com.sports.community.controller;

import com.sports.community.service.AlphaService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/alpha")
public class AlphaController {
    @Autowired
    private AlphaService alphaService;

    @RequestMapping("/hello")
    @ResponseBody
    public String hi() {
        return "Hello";
    }

    @RequestMapping("/data")
    @ResponseBody
    public String getData() {
        return alphaService.find();
    }

    @RequestMapping("/http")
    public void http(HttpServletRequest req, HttpServletResponse res) {
        System.out.println(req.getMethod());
        System.out.println(req.getServletPath());
        Enumeration<String> enumeration = req.getHeaderNames();
        while (enumeration.hasMoreElements()){
            String name = enumeration.nextElement();
            String value = req.getHeader(name);
            System.out.println(name + ": " + value);
        }

        System.out.println(req.getParameter("code"));

        res.setContentType("text/html;charset=utf-8");
        try (PrintWriter writer = res.getWriter()){
            writer.write("<h1>sss</h1>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(path = "/students",method = RequestMethod.GET)
    @ResponseBody
    public String getStudents(
            @RequestParam(name="current",required = false, defaultValue = "1") int current,
            @RequestParam(name="limit",required = false, defaultValue = "10") int limit) {
        System.out.println(current);
        System.out.println(limit);
        return "some students";
    }

    @GetMapping(path="/students/{id}")
    @ResponseBody
    public String getOneStud(@PathVariable("id") int id) {
        System.out.println(id);
        return "A student";
    }

    @PostMapping("/students")
    @ResponseBody
    public String saveStuds(String name, int age) {
        System.out.println(name);
        System.out.println(age);
        return "Success";
    }

    //响应html数据
    @GetMapping("/teacher")
    public ModelAndView getTeacher() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("name","Harry");
        mav.addObject("age",22);
        mav.setViewName("/demo/view");
        return mav;
    }

    @GetMapping("/school")
    public String getSchool(Model model) {
        model.addAttribute("name","SFLS");
        model.addAttribute("age","100");
        return "/demo/view";
    }

    @GetMapping("/emp")
    @ResponseBody
    public Map<String,Object> getEmp() {
        Map<String,Object> map = new HashMap<>();
        map.put("name","Harry");
        map.put("age",22);
        map.put("salary",12);
        return map;
    }

}
