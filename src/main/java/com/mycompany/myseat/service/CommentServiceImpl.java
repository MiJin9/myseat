package com.mycompany.myseat.service;

import com.mycompany.myseat.dao.CommentDao;
import com.mycompany.myseat.dao.ReviewDao;
import com.mycompany.myseat.domain.CommentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    CommentDao commentDao;
    ReviewDao reviewDao;

    @Autowired
    public CommentServiceImpl(CommentDao commentDao, ReviewDao reviewDao){
        this.commentDao = commentDao;
        this.reviewDao = reviewDao;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int write(CommentDto commentDto) throws Exception{
        reviewDao.updateCommentCnt(commentDto.getBno(), 1);
//        throw new Exception("test");
        return commentDao.insert(commentDto);
    }

    @Override
    public CommentDto read(int cno) throws Exception{
        return commentDao.select(cno);
    }

    @Override
    public List<CommentDto> getList(Integer bno) throws Exception{
        return commentDao.selectAll(bno);
    }

}
