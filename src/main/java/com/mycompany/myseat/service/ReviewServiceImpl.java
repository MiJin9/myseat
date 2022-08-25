package com.mycompany.myseat.service;

import com.mycompany.myseat.dao.ReviewDao;
import com.mycompany.myseat.domain.ReviewDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl implements ReviewService {
    @Autowired
    ReviewDao reviewDao;

    @Override
    public int write(ReviewDto reviewDto) throws Exception{
        return reviewDao.insert(reviewDto);
    }
}
