package com.sports.community.controller;

import com.sports.community.entity.DiscussPost;
import com.sports.community.entity.Page;
import com.sports.community.entity.User;
import com.sports.community.service.DiscussPostService;
import com.sports.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {
    @Autowired
    DiscussPostService discussPostService;
    @Autowired
    UserService userService;

    @GetMapping("/index")
    public String getIndexPage(Model model, Page page){
        page.setRows(discussPostService.findDiscussPostRows(0));
        page.setPath("/index");
        List<DiscussPost> list = discussPostService.findDiscussPosts(0,page.getOffset(),page.getLimit());
        List<Map<String,Object>> discussPosts = new ArrayList<>();
        if (list != null) {
            for (DiscussPost post: list) {
                User user = userService.findUserById(post.getUserId());
                Map<String,Object> map = new HashMap<>();
                map.put("post",post);
                map.put("user",user);
                discussPosts.add(map);
            }
        }
        model.addAttribute("discussPosts",discussPosts);
        return "/index";
    }
}
