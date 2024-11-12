package com.koreait.db.controller;

import com.koreait.db.dto.UserClubDTO;
import com.koreait.db.mapper.ClubMapper;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainController {
    @Autowired private ClubMapper clubMapper;

    @GetMapping("/view")
    public String get_view(HttpSession session, Model model) {
        System.out.println("get_view 실행됨");
        Object object = session.getAttribute("user");
        if(object == null){ // 로그인 안되었어요
            System.out.println("로그인 안되어있음 => login창 이동");
            return "redirect:/user/login"; // GET요청
        }

        List<UserClubDTO> userClubDTOS = clubMapper.selectUserWithClub();
        model.addAttribute("userClubDTOS", userClubDTOS);

        System.out.println("조회된 UserClubDTO >> ");
        for(UserClubDTO userClubDTO : userClubDTOS){
            System.out.println(userClubDTO);
        }

        return "view"; // view.html 화면 보여준다
    }
}
