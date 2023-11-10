package com.example.api.blog;

import com.example.Service.imp.blog.BlogService;
import com.example.dto.blog.BlogDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BlogController {


    @Autowired
    private BlogService blogService;

    @PostMapping("/api/blogs")
    public BlogDTO createNewBlog(@RequestBody BlogDTO blogDTO) {
        return blogService.save(blogDTO);
    }

    @PutMapping("/api/blogs/{id}")
    public BlogDTO updateBlog(@PathVariable Long id,
                              @RequestBody BlogDTO blogDTO) {
        return null;
    }

    @DeleteMapping("/api/blogs/{id}")
    public BlogDTO deleteBlog(@PathVariable Long id) {
        return null;
    }

    @GetMapping("/api/blogs")
    public List<BlogDTO> getListBlog() {
        return blogService.list();
    }
}
