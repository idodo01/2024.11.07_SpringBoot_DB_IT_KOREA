package com.koreait.db.controller;

import com.koreait.db.dto.ClubDTO;
import com.koreait.db.dto.UserDTO;
import com.koreait.db.mapper.ClubMapper;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/club")
public class ClubController {
    @Autowired private ClubMapper clubMapper;

    @GetMapping("/register")
    public String get_register(HttpSession session){
        System.out.println("get_view 실행됨");
        Object object = session.getAttribute("user");
        if(object == null){ // 로그인 안되었어요
            System.out.println("로그인 안되어있음 => login창 이동");
            return "redirect:/user/login"; // GET요청
        }
        // 로그인되어있는 유저로 다운캐스팅
        UserDTO user = (UserDTO) object;
        // 로그인 되어있는 유저가 일반 유저다
        if(user.getRole().equals("normal")){
            return "redirect:/view"; // view화면으로 GET요청
        }
        // 로그인 되어잇는 유저가 admin이다
        return "club/register"; // club/register.html 화면 보여준다
    }

    @PostMapping("/register")
    public String post_register(ClubDTO club){
        clubMapper.insertClub(club);
        return "redirect:/view"; // view 화면으로 돌아간다
    }


}
