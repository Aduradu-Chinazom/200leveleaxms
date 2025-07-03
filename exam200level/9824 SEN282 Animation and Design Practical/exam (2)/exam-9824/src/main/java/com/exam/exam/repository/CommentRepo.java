package com.exam.exam.repository;

import com.exam.exam.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepo extends JpaRepository<Comment, Long>
{
    List<Comment>
      findByFoodOrderId(Long foodOrderId);
}
