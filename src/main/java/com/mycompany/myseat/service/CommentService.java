package com.mycompany.myseat.service;

import com.mycompany.myseat.domain.CommentDto;
import org.springframework.transaction.annotation.Transactional;

public interface CommentService {
    @Transactional(rollbackFor = Exception.class)
    int write(CommentDto commentDto) throws Exception;
}
