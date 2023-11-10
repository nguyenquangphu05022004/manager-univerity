package com.example.api.blog;

import com.example.Service.imp.blog.CommentService;
import com.example.dto.blog.CommentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/api/comments")
    public CommentDTO createNewComment(@RequestBody CommentDTO commentDTO) {
        return commentService.save(commentDTO);
    }

}
