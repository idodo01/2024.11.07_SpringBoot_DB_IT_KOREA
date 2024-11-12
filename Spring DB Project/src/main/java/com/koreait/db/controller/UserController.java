package com.koreait.db.controller;

import com.koreait.db.dto.UserDTO;
import com.koreait.db.mapper.UserMapper;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired private UserMapper userMapper;

    // templates 폴더에 있는 /user/login.html 을 view로 보여줘라
    @GetMapping("/login")
    public void get_login(){}

    @PostMapping("/login")
    public String post_login(UserDTO user, HttpSession session){
        System.out.println("post_login 실행됨");
        UserDTO findedUser = userMapper.selectUserByUserName(user.getName());
        // name을 없는 거 적어서 null 이다
        if(findedUser == null){
            System.out.println("USER가 없었음.");
            return "redirect:/user/login"; // GET요청
        }
        System.out.println("USER를 찾았다. " + findedUser);
        session.setAttribute("user", findedUser);
        return "redirect:/view";
    }



    @GetMapping("/register")
    public void get_register() {}

    @PostMapping("/register")
    public String post_register(UserDTO user) {
        System.out.println("post_register가 실행되었음");
        System.out.println("받은 UserDTO: " + user);
        userMapper.insertUser(user);
        System.out.println("INSERT 완료!");
        return "redirect:/user/login";
    }





}









