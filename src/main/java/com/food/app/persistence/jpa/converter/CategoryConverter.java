package com.food.app.persistence.jpa.converter;

import com.food.app.persistence.jpa.dto.CategoryDto;
import com.food.app.persistence.jpa.entity.CategoryEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CategoryConverter {

    public CategoryDto toCategoryDto(CategoryEntity category){
        return CategoryDto.builder()
                .id(category.getId())
                .categoryName(category.getCategoryName())
                .build();
    }
}
