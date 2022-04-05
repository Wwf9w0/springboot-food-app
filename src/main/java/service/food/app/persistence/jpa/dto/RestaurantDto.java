package service.food.app.persistence.jpa.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class RestaurantDto {

    private Long id;
    private String name;
    private String city;
    private String address;
}
