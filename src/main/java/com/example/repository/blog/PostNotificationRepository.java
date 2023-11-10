package com.example.repository.blog;

import com.example.entity.blog.PostNotification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostNotificationRepository extends JpaRepository<PostNotification, Long> {
	
	Optional<PostNotification> findOneById(Long id);
}
