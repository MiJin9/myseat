package com.mycompany.myseat.controller;

import com.mycompany.myseat.domain.ReviewDto;
import com.mycompany.myseat.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/review")
public class reviewController {

    @Autowired
    ReviewService reviewService;

    //글목록
    @GetMapping("/list")
    public String goList(HttpServletRequest request, Model m){
        if(!loginCheck(request))
            return "redirect:/user/login.tiles";

        try {
            List<ReviewDto> list = reviewService.list();
            m.addAttribute("list", list);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "review/reviewList.tiles";
    }

    private boolean loginCheck(HttpServletRequest request) {
        HttpSession session = request.getSession();
        return session.getAttribute("nickname")!=null;
    }

    //글쓰기
    @GetMapping("/write")
    public String writeReview(Model m){
        m.addAttribute("mode", "new");
        return "review/review.tiles";
    }

    @PostMapping("/write")
    public String writeReview(Model m, RedirectAttributes rattr, ReviewDto reviewDto, HttpSession session){
        String nickname = (String) session.getAttribute("nickname");
        reviewDto.setNickname(nickname);
        try {
            if(reviewService.write(reviewDto)!=1)
                throw new Exception("Write failed");
            rattr.addFlashAttribute("msg", "WRT_OK");
            return "redirect:/review/list.tiles";

        } catch (Exception e) {
            e.printStackTrace();
            m.addAttribute("msg", "WRT_ERR");
            m.addAttribute("mode", "new");
            m.addAttribute(reviewDto);
            return "review/review.tiles";
        }
    }

    //글읽기
    @GetMapping("/read")
    public String readReview(Integer bno, Model m){
        try {
            ReviewDto reviewDto = reviewService.read(bno);
            m.addAttribute("reviewDto", reviewDto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "review/review.tiles";
    }
}
