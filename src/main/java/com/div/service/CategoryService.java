package com.div.service;

import com.div.dto.CategoryDto;
import com.div.entity.Category;
import com.div.mapper.CategoryMapper;
import com.div.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryService {
    private  final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public CategoryService(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }


    public CategoryDto creatCategory(CategoryDto categoryDto) {
        Category category = categoryMapper.toCategory(categoryDto);
        Category savedCategory = categoryRepository.save(category);
        return categoryMapper.toCategoryDto(savedCategory);
    }

    public List<CategoryDto> getAllCategory() {
        List<Category> all = categoryRepository.findAll();
        List<CategoryDto> categoryDtoList= all.stream()
                .map(categoryMapper::toCategoryDto)
                .collect(Collectors.toList());
        return categoryDtoList;
    }

    public CategoryDto getCategoryById(Long id) {
        Category category = categoryRepository.findById(id).orElse(null);
        return categoryMapper.toCategoryDto(category);
    }

    public void updateCategory(Long id, CategoryDto categoryDto) {
        Optional<Category>optionalCategory= categoryRepository.findById(id);
        if(optionalCategory.isPresent()){
            Category oldCategory = optionalCategory.get();
            oldCategory.setName(categoryDto.getName());
            oldCategory.setDesc(categoryDto.getDesc());
            categoryRepository.save(oldCategory);
        }


    }

    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);

    }
}
