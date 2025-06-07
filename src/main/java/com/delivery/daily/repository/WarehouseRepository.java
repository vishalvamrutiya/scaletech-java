package com.delivery.daily.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.delivery.daily.entity.Warehouse;

public interface WarehouseRepository extends JpaRepository<Warehouse, Integer> {
}
