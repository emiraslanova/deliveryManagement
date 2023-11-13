package com.div.mapper;

import com.div.dto.CategoryDto;
import com.div.entity.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    Category toCategory(CategoryDto categoryDto);
    CategoryDto toCategoryDto(Category category);


}