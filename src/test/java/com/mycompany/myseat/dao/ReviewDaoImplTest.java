package com.mycompany.myseat.dao;

import com.mycompany.myseat.domain.ReviewDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class ReviewDaoImplTest {

    @Autowired
    private ReviewDao reviewDao;


    @Test
    public void insert() throws Exception{
        for(int i=1; i<=20; i++){
//            ReviewDto
        }
    }

    @Test
    public void list() throws Exception{
        List<ReviewDto> list = reviewDao.selectAll();
        for(int i=0; i<list.size(); i++){
            System.out.println(list.get(i));
        }
    }

    @Test
    public void read() throws Exception{
        ReviewDto reviewDto = new ReviewDto("no title", "no content", "asdf", 1);
        assertTrue(reviewDao.insert(reviewDto)==1);

        Integer bno = reviewDao.selectAll().get(0).getBno();
        reviewDto.setBno(bno);
        ReviewDto reviewDto2 = reviewDao.select(bno);
        assertTrue(reviewDto.equals(reviewDto2));
    }

    @Test
    public void update() throws Exception{
        ReviewDto reviewDto = new ReviewDto("test", "test", "kk", 1);
        assertTrue(reviewDao.insert(reviewDto)==1);

        Integer bno = reviewDao.selectAll().get(0).getBno();
        reviewDto.setBno(bno);
        reviewDto.setTitle("change");
        System.out.println("reviewDto = " + reviewDto);
        assertTrue(reviewDao.update(reviewDto)==1);
    }

    @Test
    public void delete() throws Exception{
        ReviewDto reviewDto = new ReviewDto("title", "content", "kk", 2);
        assertTrue(reviewDao.insert(reviewDto)==1);

        assertTrue(reviewDao.delete(47, "kk")==1);
    }
}