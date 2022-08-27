package com.mycompany.myseat.service;

import com.mycompany.myseat.domain.ReviewDto;

import java.util.List;
import java.util.Map;

public interface ReviewService {
    int write(ReviewDto reviewDto) throws Exception;

    List<ReviewDto> list() throws Exception;

    ReviewDto read(Integer bno) throws Exception;

    int modify(ReviewDto reviewDto) throws Exception;

    int remove(Integer bno, String nickname) throws Exception;

    List<ReviewDto> getPage(Map map) throws Exception;

    int getTotalCnt() throws Exception;
}
