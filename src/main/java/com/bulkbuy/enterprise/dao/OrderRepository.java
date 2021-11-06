package com.bulkbuy.enterprise.dao;

import com.bulkbuy.enterprise.dto.Order;
import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.CrudRepository;

@Profile("TBA")
public interface OrderRepository extends CrudRepository<Order, Integer> {


}
