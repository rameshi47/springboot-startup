package com.SpringCURDE.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.SpringCURDE.Entity.Product;
import com.SpringCURDE.Service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	// create 
	@PostMapping("/addProduct")
	public Product addProduct(@RequestBody Product product) {
		return service.saveProduct(product);
	}
	
	@PostMapping("/addProducts")
	public List<Product> addProduct(@RequestBody List<Product> products) {
		return service.saveProduct(products);
	}
	
	// show
	@GetMapping("/products")
	public List<Product> findAllProducts(){
		return service.getProducts();
	}
	
	@GetMapping("/productID/{id}")
	public Product findProductById(@PathVariable int id){
		return service.getProductById(id);
	}
	
	@GetMapping("/productNAME/{name}")
	public Product findProductByName(@PathVariable String  name){
		return service.getProductByName(name);
	}
	
	//put or post
	@PutMapping("/update")
	public Product updateProduct(@RequestBody Product product) {
		return service.updateProduct(product);
	} 
	
	// delete
	
	@DeleteMapping("/delete/{id}")
	public String delectProduct(@PathVariable int id) {
		return service.delectProduct(id);
	}
	
	// sort method
	@GetMapping("/{field}")
	public List<Product> getProductwithSort(@PathVariable String field){
		 List<Product> allProduct = service.findProductWithSorting(field);
         return allProduct;
	}

}
