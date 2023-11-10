package com.example.repository.blog;

import com.example.entity.blog.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BlogRepository extends JpaRepository<Blog, Long> {
        Optional<Blog> findOneById(Long id);
}
