package com.mycompany.myseat.service;

import com.mycompany.myseat.domain.ReviewDto;

public interface ReviewService {
    int write(ReviewDto reviewDto) throws Exception;
}
