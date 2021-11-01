package com.bulkbuy.enterprise.dao;

import com.bulkbuy.enterprise.dto.Order;
import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/***
 * Crud Repository responsible for providing various methods to interact with the database
 */
@Profile("TBA")
public interface OrderRepository extends CrudRepository<Order, Integer> {


}
