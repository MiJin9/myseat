package com.mycompany.myseat.controller;

import com.mycompany.myseat.domain.PageHandler;
import com.mycompany.myseat.domain.ReviewDto;
import com.mycompany.myseat.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/review")
public class ReviewController {

    @Autowired
    ReviewService reviewService;

    //글목록
    @GetMapping("/list")
    public String goList(Integer page, Integer pageSize, HttpServletRequest request, Model m){
        if(!loginCheck(request))
            return "redirect:/user/login.tiles";

        if(page==null) page=1;
        if(pageSize==null) pageSize=10;

        try {
            int totalCnt = reviewService.getTotalCnt();
            PageHandler pageHandler = new PageHandler(totalCnt, page, pageSize);

            Map map = new HashMap();
            map.put("offset", (page-1)*pageSize);
            map.put("pageSize", pageSize);
            List<ReviewDto> list = reviewService.getPage(map);
            m.addAttribute("list", list);
            m.addAttribute("ph", pageHandler);
            m.addAttribute("page", page);
            m.addAttribute("pageSize", pageSize);
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

    //글 읽기
    @GetMapping("/read")
    public String readReview(Integer bno, Model m, Integer page, Integer pageSize){
        try {
            ReviewDto reviewDto = reviewService.read(bno);
            m.addAttribute("reviewDto", reviewDto);
            m.addAttribute("page", page);
            m.addAttribute("pageSize", pageSize);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "review/review.tiles";
    }

    //글 수정
    @PostMapping("/modify")
    public String modifyReview(ReviewDto reviewDto, RedirectAttributes rattr, Model m, HttpSession session){
        String nickname = (String) session.getAttribute("nickname");
        reviewDto.setNickname(nickname);
        try {
            if(reviewService.modify(reviewDto)!=1)
                throw new Exception("Modify failed");

            rattr.addFlashAttribute("msg", "MOD_OK");
            return "redirect:/review/list.tiles";
        } catch (Exception e) {
            e.printStackTrace();
            m.addAttribute("msg", "MOD_ERR");
            m.addAttribute(reviewDto);
            return "review/review.tiles";
        }
    }

    //글 삭제
    @PostMapping("/remove")
    public String removeReview(Integer bno, HttpSession session, RedirectAttributes rattr, Model m){
        String nickname = (String)session.getAttribute("nickname");
        try {
            if(reviewService.remove(bno, nickname)!=1)
                throw new Exception("Remove failed");

            rattr.addFlashAttribute("msg", "DEL_OK");
        } catch (Exception e) {
            e.printStackTrace();
            m.addAttribute("msg", "DEL_ERR");
        }
        return "redirect:/review/list.tiles";
    }
}
