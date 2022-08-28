package com.mycompany.myseat.dao;

import com.mycompany.myseat.domain.CommentDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CommentDaoImpl implements CommentDao {
    @Autowired
    SqlSession session;

    String namespace = "com.mycompany.myseat.dao.CommentMapper.";

    @Override
    public int insert(CommentDto commentDto) throws Exception{
        return session.insert(namespace+"insert", commentDto);
    }
}
