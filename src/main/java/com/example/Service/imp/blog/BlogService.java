package com.example.Service.imp.blog;


import com.example.Service.GenericService;
import com.example.Service.imp.search.GenericSearchBy;
import com.example.converter.imp.blog.BlogConverter;
import com.example.dto.blog.BlogDTO;
import com.example.entity.Person;
import com.example.entity.Student;
import com.example.entity.blog.Blog;
import com.example.entity.blog.Category;
import com.example.repository.StudentRepository;
import com.example.repository.blog.BlogRepository;
import com.example.repository.blog.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class BlogService implements GenericService<BlogDTO> {
    @Autowired
    private BlogConverter blogConverter;
    @Autowired
    private BlogRepository blogRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private GenericSearchBy searchBy;

    @Override
    public BlogDTO save(BlogDTO object) {
        Blog blog = null;
        Set<Category> categories = new HashSet<>();

        object.getCategoryIds().forEach(id -> {
            Category category = (Category) GenericSearchBy
                    .findOneById(
                            "Category",
                            id,
                            categoryRepository);
            categories.add(category);
        });

        if (object.getId() != null) {
            Blog oldBlog =
                    (Blog) GenericSearchBy
                            .findOneById(
                                    "Blog",
                                    object.getId(),
                                    blogRepository);
            blog = blogConverter.toEntity(oldBlog, object);
        } else {
            Person person = searchBy.findPersonByUsername(
                    SecurityContextHolder
                            .getContext()
                            .getAuthentication()
                            .getName()
            );
            blog = blogConverter
                    .toEntity(object)
                    .toBuilder()
                    .student(person.getStudent())
                    .build();
        }
        return blogConverter.toDto(blogRepository
                .save(blog
                        .toBuilder()
                        .categories(categories)
                        .build()));
    }

    @Override
    public void delete(Long[] ids) {
        for (Long id : ids) {
            deleteById(id);
        }
    }

    @Override
    public List<BlogDTO> list() {
        return blogConverter.dtoList(blogRepository.findAll());
    }

    public void deleteById(Long id) {
        blogRepository.delete(id);
    }
}
