package com.delivery.daily.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.delivery.daily.dto.UserDTO;
import com.delivery.daily.dto.WarehouseDTO;
import com.delivery.daily.entity.User;
import com.delivery.daily.repository.UserRepository;
import com.delivery.daily.service.UserService;
import com.delivery.daily.service.WarehouseService;

@RestController
@RequestMapping("/api") // Base URL for all endpoints in this controller
public class WarehouseController {

	
	private final WarehouseService warehouseService;

	public WarehouseController(WarehouseService warehouseService) {
		this.warehouseService = warehouseService;
	}
    
	@CrossOrigin
    @GetMapping("/warehouses")
    public List<WarehouseDTO> findAllWarehouses() {
      return this.warehouseService.getAllWarehouses();
    }
	
	@CrossOrigin
	@PostMapping("/warehouses")
	public ResponseEntity<WarehouseDTO> createUser(@RequestBody WarehouseDTO warehouse) {
		System.out.println("Test " + warehouse.name());
		return ResponseEntity.ok(this.warehouseService.saveWarehouse(warehouse));
	}
	
	@CrossOrigin
	@GetMapping("/warehouses/{id}")
    public ResponseEntity<WarehouseDTO> getWarehouseById(@PathVariable Integer id) {
        Optional<WarehouseDTO> warehouse = this.warehouseService.getWarehouseById(id);
        return warehouse.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
	
	@CrossOrigin
	@PutMapping("/warehouses/{id}")
    public ResponseEntity<WarehouseDTO> updateUser(@PathVariable Integer id, @RequestBody WarehouseDTO warehouseDTO) {
        try {
        	WarehouseDTO updatedWarehouse = this.warehouseService.updateWarehouse(id, warehouseDTO);
            return ResponseEntity.ok(updatedWarehouse);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
