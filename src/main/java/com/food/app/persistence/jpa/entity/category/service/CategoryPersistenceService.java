package com.food.app.persistence.jpa.entity.category.service;

import com.food.app.persistence.jpa.entity.category.entity.Category;
import com.food.app.persistence.jpa.entity.category.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CategoryPersistenceService {

    private final CategoryRepository categoryRepository;

    public List<Category> getAllCategory(){
        return (List<Category>) categoryRepository.findAll();
    }

    public Optional<Category> getCategoryById(Long id){
        return categoryRepository.findById(id);
    }

    public void deleteCategory(Long id){
        categoryRepository.deleteById(id);
    }


}
