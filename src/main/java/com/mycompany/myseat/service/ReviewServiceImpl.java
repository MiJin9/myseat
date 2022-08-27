package com.mycompany.myseat.service;

import com.mycompany.myseat.dao.ReviewDao;
import com.mycompany.myseat.domain.ReviewDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {
    @Autowired
    ReviewDao reviewDao;

    @Override
    public int write(ReviewDto reviewDto) throws Exception{
        return reviewDao.insert(reviewDto);
    }

    @Override
    public List<ReviewDto> list() throws Exception{
        return reviewDao.selectAll();
    }

    @Override
    public ReviewDto read(Integer bno) throws Exception{
        return reviewDao.select(bno);
    }

    @Override
    public int modify(ReviewDto reviewDto) throws Exception{
        return reviewDao.update(reviewDto);
    }
}
