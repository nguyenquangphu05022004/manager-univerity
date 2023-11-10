package com.example.Service.imp.blog;

import com.example.Service.GenericService;
import com.example.Service.imp.search.GenericSearchBy;
import com.example.converter.imp.blog.CategoryConverter;
import com.example.dto.blog.CategoryDTO;
import com.example.entity.blog.Category;
import com.example.repository.blog.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements GenericService<CategoryDTO> {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private CategoryConverter categoryConverter;

    public CategoryDTO save(CategoryDTO object) {
        Category category = null;
        if(object.getId() != null) {
            Category oldCategory =
                    (Category)GenericSearchBy
                    .findOneById(
                            "Category",
                            object.getId(),
                            categoryRepository
                    );
            category = categoryConverter.toEntity(oldCategory, object);
        } else {
            category = categoryConverter.toEntity(object);
        }
        return categoryConverter.toDto(categoryRepository.save(category));
    }

    @Override
    public void delete(Long[] ids) {
        for(Long id : ids) {delete(id);}
    }

    @Override
    public List<CategoryDTO> list() {
        return categoryConverter.dtoList(categoryRepository.findAll());
    }
    public void delete(Long id) {
        categoryRepository.delete(id);
    }
}
