package com.example.converter.imp.blog;

import com.example.converter.GenericConverter;
import com.example.dto.blog.CategoryDTO;
import com.example.entity.blog.Category;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoryConverter implements GenericConverter<Category, CategoryDTO> {
    @Override
    public Category toEntity(CategoryDTO dto) {
        return null;
    }

    @Override
    public CategoryDTO toDto(Category entity) {
        return null;
    }

    @Override
    public Category toEntity(Category entity, CategoryDTO dto) {
        return null;
    }

    @Override
    public CategoryDTO toDto(CategoryDTO dto, Category entity) {
        return null;
    }

    @Override
    public List<CategoryDTO> dtoList(List<Category> entityList) {
        return null;
    }
}
