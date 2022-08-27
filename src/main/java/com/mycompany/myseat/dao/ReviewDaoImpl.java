package com.mycompany.myseat.dao;

import com.mycompany.myseat.domain.ReviewDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ReviewDaoImpl implements ReviewDao {
    @Autowired
    SqlSession session;

    String namespace = "com.mycompany.myseat.dao.ReviewMapper.";

    @Override
    public int insert(ReviewDto reviewDto) throws Exception{
        return session.insert(namespace+"insert", reviewDto);
    }

    @Override
    public List<ReviewDto> selectAll() throws Exception{
        return session.selectList(namespace+"selectAll");
    }

    @Override
    public ReviewDto select(Integer bno) throws Exception{
        return session.selectOne(namespace+"select", bno);
    }

    @Override
    public int update(ReviewDto reviewDto) throws Exception{
        return session.update(namespace+"update", reviewDto);
    }
}
