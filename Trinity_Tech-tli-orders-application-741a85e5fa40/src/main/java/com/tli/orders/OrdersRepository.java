package com.tli.orders;

import org.springframework.data.repository.CrudRepository;

public interface OrdersRepository extends CrudRepository<orders, Long> {
  }