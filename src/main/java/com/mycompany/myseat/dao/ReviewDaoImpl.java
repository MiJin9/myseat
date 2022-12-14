package com.mycompany.myseat.dao;

import com.mycompany.myseat.domain.ReviewDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Override
    public int delete(Integer bno, String nickname) throws Exception{
        Map map = new HashMap<>();
        map.put("bno", bno);
        map.put("nickname", nickname);
        return session.delete(namespace+"delete", map);
    }

    @Override
    public List<ReviewDto> selectPage(Map map) throws Exception{
        return session.selectList(namespace+"selectPage", map);
    }

    @Override
    public int count() throws Exception{
        return session.selectOne(namespace+"count");
    }

    @Override
    public int updateCommentCnt(Integer bno, int cnt) throws Exception{
        Map map = new HashMap();
        map.put("bno", bno);
        map.put("cnt", cnt);
        return session.update(namespace+"updateCommentCnt", map);
    }
}
