package com.delivery.daily.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="warehouses")
public class Warehouse {
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Integer id;
	  
	  private String name;
	  
	  private Double latitude;
	  
	  private Double longitude;
	  
	   
	  // Hibernate expects entities to have a no-arg constructor,
	  // though it does not necessarily have to be public.
	  private Warehouse() {}
	  
	  public Warehouse(String name, Double latitude, Double longitude) {
		  this.name = name;
		  this.latitude = latitude;
		  this.longitude = longitude;
	  }
	  
	  public Integer getId() {
	    return this.id;
	  }
	  
	  public String getName() {
	    return this.name;
	  }
	  
	  public Double getLatitide() {
		    return this.latitude;
	  }
	  
	  public Double getLongitude() {
		    return this.longitude;
	  }
	  
	  public void setName(String name) {
		    this.name = name;
	  }
	  
	  public void setLatitude(Double latitude) {
		    this.latitude = latitude;
	  }
	  
	  public void setLongitude(Double longitude) {
		    this.longitude = longitude;
	  }

}
