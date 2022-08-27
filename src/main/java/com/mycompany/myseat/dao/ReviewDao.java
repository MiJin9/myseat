package com.mycompany.myseat.dao;

import com.mycompany.myseat.domain.ReviewDto;

import java.util.List;
import java.util.Map;

public interface ReviewDao {
    int insert(ReviewDto reviewDto) throws Exception;

    List<ReviewDto> selectAll() throws Exception;

    ReviewDto select(Integer bno) throws Exception;

    int update(ReviewDto reviewDto) throws Exception;

    int delete(Integer bno, String nickname) throws Exception;

    List<ReviewDto> selectPage(Map map) throws Exception;

    int count() throws Exception;
}
