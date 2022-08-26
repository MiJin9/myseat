package com.mycompany.myseat.dao;

import com.mycompany.myseat.domain.ReviewDto;

import java.util.List;

public interface ReviewDao {
    int insert(ReviewDto reviewDto) throws Exception;

    List<ReviewDto> selectAll() throws Exception;

    ReviewDto select(Integer bno) throws Exception;
}
