package com.mycompany.myseat.service;

import com.mycompany.myseat.domain.CommentDto;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CommentService {
    @Transactional(rollbackFor = Exception.class)
    int write(CommentDto commentDto) throws Exception;

    CommentDto read(int cno) throws Exception;

    List<CommentDto> getList(Integer bno) throws Exception;
}
