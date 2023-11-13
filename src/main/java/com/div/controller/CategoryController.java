package com.div.controller;

import com.div.dto.CategoryDto;
import com.div.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public CategoryDto creatCategory(@RequestBody CategoryDto categoryDto){
        return categoryService.creatCategory(categoryDto);
    }

    @GetMapping
    public List<CategoryDto> getAllCategory(){
        return categoryService.getAllCategory();
    }

    @GetMapping("/{id}")
    public  CategoryDto getCategoryById(@PathVariable Long id){
        return categoryService.getCategoryById(id);
    }

    @PutMapping("/{id}")
    public  void  updateCategory(@PathVariable Long id,@RequestBody CategoryDto categoryDto){
        categoryService.updateCategory(id,categoryDto);

    }

    @DeleteMapping("/{id}")
    public void  deleteCategory(@PathVariable Long id){
        categoryService.deleteCategory(id);
    }
}
