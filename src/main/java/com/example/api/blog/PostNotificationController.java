package com.example.api.blog;

import java.util.List;

import com.example.entity.blog.PostNotification;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.Service.imp.blog.PostNotificationService;
import com.example.dto.blog.PostNotificationDTO;

@RestController
@CrossOrigin("*")
public class PostNotificationController {

	@Autowired
	private PostNotificationService postNotificationService;

	@PostMapping("/api/notification/posts")
	public PostNotificationDTO createNewPost(@RequestBody PostNotificationDTO post) {
		return postNotificationService.save(post);
	}

	@PutMapping("/api/notification/posts/{postId}")
	public PostNotificationDTO updatePost(@PathVariable Long postId, 
										  @RequestBody PostNotificationDTO post) {
		post = post.toBuilder().id(postId).build();
		return postNotificationService.save(post);
	}

	@GetMapping("/api/notification/posts")
	public List<PostNotificationDTO> getListPost() {
		return postNotificationService.list();
	}


	@DeleteMapping("/api/notification/posts/{postId}")
	public void deletePost(@PathVariable Long postId) {
		postNotificationService.delete(postId);
	}

	@DeleteMapping("/api/notification/posts")
	public void deletePost(@RequestBody Long[] ids) {
		postNotificationService.delete(ids);
	}
}
