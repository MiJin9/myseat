package com.mycompany.myseat.controller;

import com.mycompany.myseat.domain.CommentDto;
import com.mycompany.myseat.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class CommentController {

    @Autowired
    CommentService commentService;

    @GetMapping("/comments")
    @ResponseBody
    public ResponseEntity<List<CommentDto>> list(Integer bno) throws Exception{
        List<CommentDto> list = null;

        try {
            list = commentService.getList(bno);
            return new ResponseEntity<List<CommentDto>>(list, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<List<CommentDto>>(HttpStatus.BAD_REQUEST);
        }
    }

    @ResponseBody
    @PostMapping("/comments")
    public ResponseEntity<String> write(@RequestBody CommentDto commentDto, Integer bno, HttpSession session) throws Exception{
//        String commenter = (String) session.getAttribute("nickname");
        String commenter = "kk";
        commentDto.setCommenter(commenter);
        commentDto.setBno(bno);
        try {
            int rowCnt = commentService.write(commentDto);
            if(rowCnt!=1)
                throw new Exception("Write failed");

            return new ResponseEntity<>("WRT_OK", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("WRT_ERR", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/comments/{cno}")
    public ResponseEntity<String> remove(@PathVariable int cno, Integer bno, HttpSession session) throws Exception{
//        String commenter = (String) session.getAttribute("nickname");
        String commenter = "asdf";
        try {
            int rowCnt = commentService.remove(commenter, cno, bno);
            if(rowCnt!=1)
                throw new Exception("Delete failed");

            return new ResponseEntity<>("DEL_OK", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("DEL_ERR", HttpStatus.BAD_REQUEST);
        }
    }
}
