package com.mycompany.myseat.dao;

import com.mycompany.myseat.domain.ReviewDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class ReviewDaoImplTest {

    @Autowired
    private ReviewDao reviewDao;

    @Test
    public void insert() throws Exception{
        ReviewDto reviewDto = new ReviewDto("title3", "content3", "asdf", 0);
        System.out.println("ReviewDto = " + reviewDto);
        assertTrue(reviewDao.insert(reviewDto)==1);
    }
}