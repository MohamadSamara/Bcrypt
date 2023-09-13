package com.example.AuthWithBcrypt.controller;

import com.example.AuthWithBcrypt.models.SitePost;
import com.example.AuthWithBcrypt.models.SiteUser;
import com.example.AuthWithBcrypt.repository.SitePostRepository;
import com.example.AuthWithBcrypt.repository.SiteUserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    SiteUserRepository userRepository;
    @Autowired
    SitePostRepository postRepository;

    @GetMapping("/signDone")
    public String signDone(HttpServletRequest request, Model model) {

        HttpSession session = request.getSession();
        String username = session.getAttribute("username").toString();

        model.addAttribute("username", username);
        SiteUser siteUser = userRepository.findByUsername(username);
        if (siteUser != null) {
            List<SitePost> userPosts = siteUser.getSitePostList();
            model.addAttribute("postInfo", userPosts);
        }

        return "signDone.html";
    }

    @PostMapping("/addPost")
    public RedirectView addPost(HttpServletRequest request, String postInfo) {
        HttpSession session = request.getSession();
        String username = session.getAttribute("username").toString();
        SiteUser siteUser = userRepository.findByUsername(username);
        if (siteUser != null) {
            SitePost sitePost = new SitePost(postInfo, siteUser);
            postRepository.save(sitePost);
        }

        return new RedirectView("/signDone");
    }

}