package com.example.converter.imp.blog;

import com.example.converter.GenericConverter;
import com.example.converter.imp.StudentConverter;
import com.example.dto.blog.CommentDTO;
import com.example.entity.blog.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CommentConverter implements GenericConverter<Comment, CommentDTO> {

    @Autowired
    private BlogConverter blogConverter;
    @Autowired
    private StudentConverter studentConverter;

    @Override
    public Comment toEntity(CommentDTO dto) {
        return Comment
                .builder()
                .content(dto.getContent())
                .likeComment(0)
                .build();
    }

    @Override
    public CommentDTO toDto(Comment entity) {
        return CommentDTO
                .builder()
                .blogDTO(blogConverter.toDto(entity.getBlog()))
                .studentDTO(studentConverter.toDto(entity.getStudent()))
                .id(entity.getId())
                .createDate(entity.getCreateDate())
                .modifiedDate(entity.getModifiedDate())
                .build();
    }

    @Override
    public Comment toEntity(Comment entity, CommentDTO dto) {
        return entity
                .toBuilder()
                .content(dto.getContent())
                .build();
    }

    @Override
    public CommentDTO toDto(CommentDTO dto, Comment entity) {
        return null;
    }

    @Override
    public List<CommentDTO> dtoList(List<Comment> entityList) {
        return null;
    }
}
