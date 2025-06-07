package com.delivery.daily.service;

import java.util.List;
import java.util.Optional;

import com.delivery.daily.dto.WarehouseDTO;

public interface WarehouseService {
	List<WarehouseDTO> getAllWarehouses();
	WarehouseDTO saveWarehouse(WarehouseDTO userDTO);
	Optional<WarehouseDTO> getWarehouseById(Integer id);
	WarehouseDTO updateWarehouse(Integer id, WarehouseDTO userDTO);
}
