package com.mycompany.myseat.controller;

import com.mycompany.myseat.dao.UserDao;
import com.mycompany.myseat.domain.User;
import com.mycompany.myseat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.http.HttpResponse;
import java.security.SecureRandom;
import java.util.Date;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    JavaMailSender mailSender;

    //        회원가입
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


    //        로그인
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


    //      로그아웃
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "/index.tiles";
    }


    //    이메일 중복체크
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


    //    이메일 찾기
    @GetMapping("/findUser")
    public String goFindIdPw() {
        return "user/findIdPw.tiles";
    }

    @PostMapping(value = "/findEmail")
    @ResponseBody
    public String findEmail(User user) throws Exception {
        return userService.searchEmail(user.getName(), user.getNickname());
    }

    //    이메일 보내기
//    @RequestMapping(value = "/sendMail", method = {RequestMethod.GET, RequestMethod.POST})
    @GetMapping(value = "/sendMail")
    @ResponseBody
    public void sendMail(@RequestParam String email) throws Exception {

        String newPw = getRamdomPassword(10);
        String subject = "[myseat] 비밀번호 초기화";
        String content = "임시 비밀번호는 ["+newPw+"] 입니다.";
        String from = "myseat_@naver.com";
        String to = email;

        try {
            MimeMessage mail = mailSender.createMimeMessage();
            MimeMessageHelper mailHelper = new MimeMessageHelper(mail,"UTF-8");

            mailHelper.setFrom(from);
            mailHelper.setTo(to);
            mailHelper.setSubject(subject);
            mailHelper.setText(content);

            mailSender.send(mail);
            userService.updatePw(email, newPw);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    임시 비밀번호 만들기
    public String getRamdomPassword(int size) {
        char[] charSet = new char[] {
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
                'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
                '!', '@', '#', '$', '%', '^', '&' };

        StringBuffer sb = new StringBuffer();
        SecureRandom sr = new SecureRandom();
        sr.setSeed(new Date().getTime());

        int idx = 0;
        int len = charSet.length;
        for (int i=0; i<size; i++) {
            // idx = (int) (len * Math.random());
            idx = sr.nextInt(len);    // 강력한 난수를 발생시키기 위해 SecureRandom을 사용한다.
            sb.append(charSet[idx]);
        }

        return sb.toString();
    }
}
