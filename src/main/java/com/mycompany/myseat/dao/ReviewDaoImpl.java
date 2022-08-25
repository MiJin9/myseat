package com.mycompany.myseat.dao;

import com.mycompany.myseat.domain.ReviewDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ReviewDaoImpl implements ReviewDao {
    @Autowired
    SqlSession session;

    String namespace = "com.mycompany.myseat.dao.ReviewMapper.";

    @Override
    public int insert(ReviewDto reviewDto) throws Exception{
        return session.insert(namespace+"insert", reviewDto);
    }
}
