package com.kedu.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Struct;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService service;

    @RequestMapping("/join")
    public String join (){
        return "user/join";
    }

    @RequestMapping(value = "/join", method = RequestMethod.POST)
    public String join(UserEntity param){
        service.joinUser(param);
    return "redirect:/user/login";
    }

    @RequestMapping("/login")
    public void login(@RequestParam(value = "err", defaultValue = "0")int err, Model model){
        switch (err){
            case 1:
                model.addAttribute("errMsg","아이디를 확인");
                break;
            case 2:
                model.addAttribute("errMsg","비밀번호를 확인");
                break;
        }
    }
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(UserEntity param){
        return "redirect:" + service.loginUser(param);
    }

    @RequestMapping("/receiveCode")
    public String receiveCode (){
        return "user/receiveCode";
    }

    @RequestMapping("/googleLogin")
    public String googleLogin (){
        return "user/googleLogin";
    }
}
