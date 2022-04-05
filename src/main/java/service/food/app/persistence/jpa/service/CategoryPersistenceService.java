package service.food.app.persistence.jpa.service;

import service.food.app.persistence.jpa.entity.CategoryEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CategoryPersistenceService {

    private final CategoryReposiyory categoryReposiyory;

    public List<CategoryEntity> getAllCategory(){
        return (List<CategoryEntity>) categoryRepository.findAll();
    }

    public Optional<CategoryEntity> getCategoryById(Long id){
        return categoryRepository.findById(id);
    }

    public void deleteCategory(Long id){
        categoryRepository.deleteById(id);
    }


}
