package com.mycompany.myseat.controller;

import com.mycompany.myseat.dao.UserDao;
import com.mycompany.myseat.domain.User;
import com.mycompany.myseat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.http.HttpResponse;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    //    회원가입
    @GetMapping("/signUp")
    public String signUpForm() {
        return "user/signUp.tiles";
    }

    @PostMapping("/signUp")
    public String singUp(User user, Model m, RedirectAttributes rattr) {
        try {
            if (userService.signUp(user) != 1)
                throw new Exception("Join failed.");

            rattr.addFlashAttribute("msg", "JOIN_OK");
            return "redirect:/";
        } catch (Exception e) {
            System.out.println();
            e.printStackTrace();
            m.addAttribute(user);
            m.addAttribute("msg", "JOIN_FAIL");
            return "user/signUp";
        }
    }

    //    로그인
    @GetMapping("/login")
    public String loginForm() {
        return "user/loginForm.tiles";
    }

    @PostMapping("/login")
    public String login(String email, String pw, HttpServletRequest request, HttpServletResponse response, boolean rememberId) {
        //1.id, pw를 확인
        if (!loginCheck(email, pw)) {
            //1-1. 일치하지 않으면 loginForm으로 이동
            return "user/loginForm";
        } else {
            //1-2. 일치하면 세션 객체를 얻어오기
            HttpSession session = request.getSession();
            //1-2-1. 세션 객체에 id를 저장
            session.setAttribute("email", email);
            try {
                String nickname = userService.getNickName(email);
                session.setAttribute("nickname", nickname);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (rememberId) {
            //1. 쿠키를 생성
            Cookie cookie = new Cookie("email", email);
            //2. 응답에 저장
            response.addCookie(cookie);
        } else {
            Cookie cookie = new Cookie("email", email);
            cookie.setMaxAge(0);
            response.addCookie(cookie);
        }

        return "redirect:/";
    }

    private boolean loginCheck(String email, String pw) {
        User u = null;

        try {
            u = userService.login(email);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return u != null && u.getPw().equals(pw);
    }

    //    로그아웃
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "/index.tiles";
    }

//    아이디 중복체크
//    @PostMapping("/check")
//    @ResponseBody
//    public String checkId(@RequestBody String email){
//        System.out.println(email);
//        return email;
//    }

    @PostMapping(value = "/check")
    @ResponseBody
    public int checkId(@RequestBody String email) throws Exception {
        return userService.getEmailCheck(email);
    }

    @PostMapping(value = "/checkNickname")
    @ResponseBody
    public int checkNickname(@RequestBody String nickname) throws Exception {
        return userService.getNicknameCheck(nickname);
    }

    //아이디찾기
    @GetMapping("/findUser")
    public String findId(){
        return "user/findIdPw.tiles";
    }
}
