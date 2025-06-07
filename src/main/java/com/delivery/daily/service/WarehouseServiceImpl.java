package com.delivery.daily.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.delivery.daily.dto.UserDTO;
import com.delivery.daily.dto.WarehouseDTO;
import com.delivery.daily.entity.User;
import com.delivery.daily.entity.Warehouse;
import com.delivery.daily.repository.UserRepository;
import com.delivery.daily.repository.WarehouseRepository;

@Service
public class WarehouseServiceImpl implements WarehouseService {

	private final WarehouseRepository warehouseRepository;

    public WarehouseServiceImpl(WarehouseRepository warehouseRepository) {
	    this.warehouseRepository = warehouseRepository;
    }

    @Override
    public List<WarehouseDTO> getAllWarehouses() {
        return warehouseRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    @Override
    public WarehouseDTO saveWarehouse(WarehouseDTO warehouseDTO) {
    	Warehouse warehouse = convertToEntity(warehouseDTO);
    	Warehouse savedWarehouse= warehouseRepository.save(warehouse);
        return convertToDTO(savedWarehouse);
    }
    
    @Override
    public Optional<WarehouseDTO> getWarehouseById(Integer id) {
        return warehouseRepository.findById(id).map(this::convertToDTO);
    }
    
    @Override
    public WarehouseDTO updateWarehouse(Integer id, WarehouseDTO warehouseDTO) {
    	Warehouse warehouse = warehouseRepository.findById(id).orElseThrow();
    	warehouse.setName(warehouseDTO.name());
    	warehouse.setLatitude(warehouseDTO.latitude());
    	warehouse.setLongitude(warehouseDTO.longitude());
        Warehouse updatedWarehouse= warehouseRepository.save(warehouse);
        return convertToDTO(updatedWarehouse);
    }
    
    // Convert User Entity to UserDTO
    private WarehouseDTO convertToDTO(Warehouse warehouse) {
        return new WarehouseDTO(warehouse.getId(), warehouse.getName(), warehouse.getLatitide(), warehouse.getLongitude());
    }
    
 // Convert UserDTO to User Entity
    private Warehouse convertToEntity(WarehouseDTO warehouseDTO) {
    	Warehouse warehouse = new Warehouse(warehouseDTO.name(), warehouseDTO.latitude(), warehouseDTO.longitude());
        return warehouse;
    }

}
