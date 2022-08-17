package com.mycompany.myseat.dao;

import com.mycompany.myseat.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class UserDaoImplTest {
    @Autowired
    private UserDao userDao;

    @Test
    public void insertUser() throws Exception {
        User u = new User("asdf", "1234", "hong", "hh");
        assertTrue(userDao.insertUser(u)==1);
    }

    @Test
    public void loginTest() throws Exception{
        User u = new User("a@a.com", "4321", "kimk", "kkk");
        assertTrue(userDao.insertUser(u)==1);
        assertTrue(userDao.selectUser("a@a.com").getName().equals(u.getName()));
    }

    @Test
    public void emailCheckTest() throws Exception{
        assertTrue(userDao.emailCheck("c@c.com")==0);
        assertTrue(userDao.emailCheck("a@a.com")==1);
    }
}