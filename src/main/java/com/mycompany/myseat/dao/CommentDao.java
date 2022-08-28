package com.mycompany.myseat.dao;

import com.mycompany.myseat.domain.CommentDto;

public interface CommentDao {
    int insert(CommentDto commentDto) throws Exception;
}
