package com.mycompany.myseat.dao;

import com.mycompany.myseat.domain.CommentDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CommentDaoImpl implements CommentDao {
    @Autowired
    SqlSession session;

    String namespace = "com.mycompany.myseat.dao.CommentMapper.";

    @Override
    public int insert(CommentDto commentDto) throws Exception{
        return session.insert(namespace+"insert", commentDto);
    }

    @Override
    public CommentDto select(int cno) throws Exception{
        return session.selectOne(namespace+"select", cno);
    }

    @Override
    public List<CommentDto> selectAll(Integer bno) throws Exception{
        return session.selectList(namespace+"selectAll", bno);
    }

    @Override
    public int delete(int cno, String commenter) throws Exception{
        Map map = new HashMap();
        map.put("cno", cno);
        map.put("commenter", commenter);
        return session.delete(namespace+"delete", map);
    }

    @Override
    public int update(CommentDto commentDto) throws Exception{
        return session.update(namespace+"update", commentDto);
    }
}
