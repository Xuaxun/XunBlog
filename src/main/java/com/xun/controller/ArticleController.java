package com.xun.controller;

import com.xun.entity.Article;
import com.xun.entity.User;
import com.xun.service.ArticleService;
import com.xun.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ArticleController {
    @Autowired
    UserService userService;

    @Autowired
    ArticleService articleService;

    @RequestMapping("/")
    public String index(Model model) {
        List<Article> articles = articleService.getFirst10Article();
        for (Article article : articles) {
            System.out.println(article.getCategory());
        }
        model.addAttribute("articles", articles);
        return "views/index";
    }

    @RequestMapping("/sang")
    public String admin(Model model) {
        model.addAttribute("articles", articleService.getFirst10Article());
        return "admin/index";
    }

    @RequestMapping("/sang/login")
    public String login() {
        return "admin/login";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/sang/dologin")
    public String doLogin(HttpServletRequest request, Model model) {
        if (request.getSession().getAttribute("user") == null) {
            return "admin/login";
        }
        return "redirect:/sang";
    }

    @RequestMapping(value = "/sang/dologin", method = RequestMethod.POST)
    public String doLogin(HttpServletRequest request, User user, Model model) {
        System.out.println("user.getUsername():" + user.getUsername() + ";user.getPassword():" + user.getPassword());
        if (userService.login(user.getUsername(), user.getPassword())) {
            request.getSession().setAttribute("user", user);
            model.addAttribute("user", user);
            return "redirect:/sang";
        } else {
            model.addAttribute("error", "用户名或密码错误");
            return "admin/login";
        }
    }
}
