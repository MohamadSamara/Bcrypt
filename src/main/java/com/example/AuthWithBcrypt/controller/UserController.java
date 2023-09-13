package com.example.AuthWithBcrypt.controller;

import com.example.AuthWithBcrypt.models.SiteUser;
import com.example.AuthWithBcrypt.repository.SiteUserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class UserController {
    @Autowired
    SiteUserRepository userRepository ;

    @GetMapping("/")
    public String hello(){
        return "hello.html";
    }

    @GetMapping("/signUp")
    public String signUp (){
        return  "signUp.html";
    }

    @PostMapping("/signUp")
    public RedirectView signUp(String username,String password){
        String hashedPassword= BCrypt.hashpw(password, BCrypt.gensalt(12));
        SiteUser siteUser = new SiteUser(username , hashedPassword);
        userRepository.save(siteUser);
        return  new RedirectView("/signIn");
    }

    @GetMapping("/signIn")
    public String signIn (){
        return  "signIn.html";
    }

    @PostMapping("/signIn")
    public RedirectView signIn(HttpServletRequest request , String username , String password){
        SiteUser siteUser = userRepository.findByUsername(username);

        if(siteUser == null || !BCrypt.checkpw(password,siteUser.getPassword()) )
        {
            return new RedirectView ("/signIn");
        }
        HttpSession session= request.getSession();
        session.setAttribute("username", username);
        return new RedirectView("/signDone");
    }

    @PostMapping("logout")
    public RedirectView logOutUser(HttpServletRequest request){

        HttpSession session= request.getSession();
        session.invalidate();

        return new RedirectView("/");
    }


}
