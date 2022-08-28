package com.mycompany.myseat.dao;

import com.mycompany.myseat.domain.CommentDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class CommentDaoImplTest {

    @Autowired
    CommentDao commentDao;

    @Test
    public void insert() throws Exception{
        CommentDto commentDto = new CommentDto(173, 0, "comment", "asdf");
        assertTrue(commentDao.insert(commentDto)==1);
    }
}