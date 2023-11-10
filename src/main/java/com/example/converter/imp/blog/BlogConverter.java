package com.example.converter.imp.blog;

import com.example.converter.GenericConverter;
import com.example.converter.imp.StudentConverter;
import com.example.dto.blog.BlogDTO;
import com.example.entity.blog.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BlogConverter implements GenericConverter<Blog, BlogDTO> {
    @Autowired
    private StudentConverter studentConverter;
    @Override
    public Blog toEntity(BlogDTO dto) {
        return Blog
                .builder()
                .content(dto.getContent())
                .shortDescription(dto.getShortDescription())
                .likeBlog(0)
                .thumbnail(dto.getThumbnail())
                .title(dto.getTitle())
                .approval(false)
                .build();
    }

    @Override
    public BlogDTO toDto(Blog entity) {
        return BlogDTO
                .builder()
                .id(entity.getId())
                .createBy(entity.getCreateBy())
                .createDate(entity.getCreateDate())
                .modifiedBy(entity.getModifiedBy())
                .modifiedDate(entity.getModifiedDate())
                .content(entity.getContent())
                .likeBlog(entity.getLikeBlog())
                .shortDescription(entity.getShortDescription())
                .title(entity.getTitle())
                .thumbnail(entity.getThumbnail())
                .studentDTO(studentConverter.toDto(entity.getStudent()))
                .approval(entity.getApproval())
                .build();
    }

    @Override
    public Blog toEntity(Blog entity, BlogDTO dto) {
        return Blog.builder()
                .title(dto.getTitle())
                .shortDescription(dto.getShortDescription())
                .content(dto.getContent())
                .thumbnail(dto.getThumbnail())
                .build();
    }

    @Override
    public BlogDTO toDto(BlogDTO dto, Blog entity) {
        return null;
    }

    @Override
    public List<BlogDTO> dtoList(List<Blog> entityList) {
        return entityList.stream().map(e -> toDto(e)).collect(Collectors.toList());
    }
}
