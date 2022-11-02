package com.SpringCURDE.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.SpringCURDE.Entity.Product;
import com.SpringCURDE.Repository.Productrepository;

@Service
public class ProductService {
	
	@Autowired
	private Productrepository repository;
	
	// post method or create 
	
	public Product saveProduct(Product product) { // single product
		return repository.save(product);
	}
	
	public List<Product> saveProduct(List<Product> products) { // list products
		return repository.saveAll(products);
	}
	
	// get method or show
	
	public List<Product> getProducts(){ // list all product in the db
		return repository.findAll();
	}
	
	public Product getProductById(int id){ // shows by id
		return repository.findById(id).orElse(null);
	}
	
	public Product getProductByName(String name){ // shows by name
		return repository.findByName(name);
	}
	
	
	// delete
	
	public String delectProduct(int id) {
		repository.deleteById(id);
		return "product removed || " +id;
	}
	
	// put or update
	 public Product updateProduct(Product product) {
	        Product existingProduct = repository.findById(product.getId()).orElse(null);
	        existingProduct.setName(product.getName());
	        existingProduct.setQuantity(product.getQuantity());
	        existingProduct.setPrice(product.getPrice());
	        return repository.save(existingProduct);
	    }
	 
	 
	 // Sort the product 
	 public List<Product> findProductWithSorting(String field ){
		 return repository.findAll(Sort.by(Sort.Direction.ASC, field));
	 }


}
