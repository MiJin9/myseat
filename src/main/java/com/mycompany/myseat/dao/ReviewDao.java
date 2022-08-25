package com.mycompany.myseat.dao;

import com.mycompany.myseat.domain.ReviewDto;

public interface ReviewDao {
    int insert(ReviewDto reviewDto) throws Exception;
}
