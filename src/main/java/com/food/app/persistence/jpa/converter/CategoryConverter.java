package com.food.app.persistence.jpa.converter;

import com.food.app.persistence.jpa.dto.CategoryDto;
import com.food.app.persistence.jpa.entity.category.entity.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CategoryConverter {

    public CategoryDto toDto(Category category){
        return CategoryDto.builder()
                .id(category.getId())
                .categoryName(category.getCategoryName())
                .build();
    }
}
