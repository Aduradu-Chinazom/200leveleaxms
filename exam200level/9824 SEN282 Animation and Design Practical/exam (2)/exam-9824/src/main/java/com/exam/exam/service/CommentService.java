package com.exam.exam.service;

import com.exam.exam.model.Comment;
import com.exam.exam.repository.CommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepo commentRepo;

    public Comment saveComment(Comment comment) {
        return commentRepo.save(comment);
    }

    public List<Comment> getCommentsByOrderId(Long orderId) {
        return commentRepo.findByFoodOrderId(orderId);
    }

}

