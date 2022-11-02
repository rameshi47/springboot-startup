package com.SpringCURDE.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SpringCURDE.Entity.Product;

public interface Productrepository extends JpaRepository<Product, Integer>{

	Product findByName(String name);

	

}
