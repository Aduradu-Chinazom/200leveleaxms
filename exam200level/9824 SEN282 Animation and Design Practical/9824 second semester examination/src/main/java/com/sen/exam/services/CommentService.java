package com.sen.exam.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sen.exam.models.Comment;
import com.sen.exam.repository.CommentRepo;

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

