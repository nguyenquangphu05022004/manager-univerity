package com.example.Service.imp.blog;

import com.example.Service.GenericService;
import com.example.Service.imp.search.GenericSearchBy;
import com.example.converter.imp.blog.CommentConverter;
import com.example.dto.blog.CommentDTO;
import com.example.entity.Person;
import com.example.entity.Student;
import com.example.entity.blog.Blog;
import com.example.entity.blog.Comment;
import com.example.repository.StudentRepository;
import com.example.repository.blog.BlogRepository;
import com.example.repository.blog.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService implements GenericService<CommentDTO> {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private CommentConverter commentConverter;
    @Autowired
    private BlogRepository blogRepository;
    @Autowired
    private GenericSearchBy searchBy;

    @Override
    public CommentDTO save(CommentDTO object) {
        Comment comment = null;
        if (object.getId() != null) {
            Comment oldComment = (Comment) GenericSearchBy
                    .findOneById(
                            "Comment",
                            object.getId(),
                            commentRepository
                    );
            comment = commentConverter.toEntity(oldComment, object);
        } else {
            Blog blog = (Blog) GenericSearchBy
                    .findOneById(
                            "Blog",
                            object.getBlogDTO().getId(),
                            blogRepository
                    );
            Person person = searchBy.findPersonByUsername(
                    SecurityContextHolder
                    .getContext()
                    .getAuthentication()
                    .getName()
            );
            comment = commentConverter.toEntity(object);
            comment = comment.toBuilder()
                    .blog(blog)
                    .student(person.getStudent())
                    .build();
        }
        return commentConverter.toDto(commentRepository.save(comment));
    }

    @Override
    public void delete(Long[] ids) {
        for(Long id : ids) {
            delete(id);
        }
    }

    @Override
    public List<CommentDTO> list() {
        return commentConverter.dtoList(commentRepository.findAll());
    }
    public void delete(Long id) {
        commentRepository.delete(id);
    }
}
