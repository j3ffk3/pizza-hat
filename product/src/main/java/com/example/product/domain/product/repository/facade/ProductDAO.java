package com.example.product.domain.product.repository.facade;

import java.util.List;

import com.example.product.domain.product.Product;


public interface ProductDAO {

	/**
	 * find all
	 * 
	 * @return
	 */
	public List<Product> findAll();

	/**
	 * find by id
	 * 
	 * @return
	 */
	public Product findById(Long id);

	/**
	 * create product
	 * 
	 * @return
	 */
	public void create(Product product);

	/**
	 * update product
	 * 
	 * @return
	 */
	public void update(Product product);

	/**
	 * delete by id
	 * 
	 * @return
	 */
	public void deleteById(Long id);

}
