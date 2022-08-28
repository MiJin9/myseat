package com.mycompany.myseat.service;

import com.mycompany.myseat.dao.CommentDao;
import com.mycompany.myseat.dao.ReviewDao;
import com.mycompany.myseat.domain.CommentDto;
import com.mycompany.myseat.domain.ReviewDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class CommentServiceImplTest {

    @Autowired
    CommentService commentService;
    @Autowired
    ReviewDao reviewDao;
    @Autowired
    CommentDao commentDao;

    @Test
    public void write() throws Exception{
        ReviewDto reviewDto = new ReviewDto("hello", "hello", "kk", 2);
        assertTrue(reviewDao.insert(reviewDto)==1);
        Integer bno = reviewDao.selectAll().get(0).getBno();

        CommentDto commentDto = new CommentDto(bno, 0, "hi", "aa");

        assertTrue(reviewDao.select(bno).getComment_cnt()==0);
        assertTrue(commentService.write(commentDto)==1);


    }
}