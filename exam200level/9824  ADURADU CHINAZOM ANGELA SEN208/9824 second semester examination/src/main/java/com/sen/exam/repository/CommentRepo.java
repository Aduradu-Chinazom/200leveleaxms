package com.sen.exam.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sen.exam.models.Comment;

import java.util.List;

@Repository
public interface CommentRepo extends JpaRepository<Comment, Long>
{
    List<Comment>
      findByFoodOrderId(Long foodOrderId);
}
