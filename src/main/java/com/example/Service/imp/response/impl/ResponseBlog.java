package com.example.Service.imp.response.impl;

import com.example.Service.imp.response.IResponseService;
import com.example.Service.imp.search.GenericSearchBy;
import com.example.entity.blog.Blog;
import com.example.repository.blog.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component("responseBlog")
public class ResponseBlog implements IResponseService {
    @Autowired
    private BlogRepository blogRepository;


    @Override
    public Boolean confirm(Object... params) {
        Blog blog = (Blog) GenericSearchBy
                .findOneById(
                        "Blog",
                        (Long) params[0],
                        blogRepository
                );
        return blogRepository.save(blog
                .toBuilder()
                .approval(true)
                .build()) != null ? true : false;
    }
}
