package com.example.product.domain.product;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.example.product.domain.product.repository.facade.ProductDAO;
import com.example.product.domain.product.vo.Size;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@Scope("prototype")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {

	@JsonIgnore
	@Autowired
	private ProductDAO productDAO;

	/**
	 * id
	 */
	private long id;

	/**
	 * name
	 */
	private String name;

	/**
	 * desc
	 */
	private String desc;

	/**
	 * stuffing
	 */
	private String stuffing;

	/**
	 * price
	 */
	private BigDecimal price;

	/**
	 * size
	 */
	private Size size;

	/**
	 * create
	 * 
	 * @return
	 */
	public void create() {
		log.info("{}", productDAO);
		log.info("create product id:{}", id);
		productDAO.create(this);
	}

	/**
	 * update
	 * 
	 * @return
	 */
	public void update() {
		log.info("update product id:{}", id);
		productDAO.update(this);
	}

	/**
	 * delete
	 * 
	 * @return
	 */
	public void delete() {
		log.info("delete product id:{}", id);
		productDAO.deleteById(id);
	}

}
