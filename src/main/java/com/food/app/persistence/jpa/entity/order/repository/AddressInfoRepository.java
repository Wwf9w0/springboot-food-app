package com.food.app.persistence.jpa.entity.order.repository;

import com.food.app.persistence.jpa.entity.order.entity.AddressInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressInfoRepository extends CrudRepository<AddressInfo, Long> {
}
