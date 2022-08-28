package com.mycompany.myseat.dao;

import com.mycompany.myseat.domain.CommentDto;

import java.util.List;

public interface CommentDao {
    int insert(CommentDto commentDto) throws Exception;

    CommentDto select(int cno) throws Exception;

    List<CommentDto> selectAll(Integer bno) throws Exception;
}
