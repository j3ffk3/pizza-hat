package com.example.product.apis.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.product.apis.dto.GenericResponseDTO;
import com.example.product.infra.persistence.ProductDAOImpl;

import io.swagger.annotations.ApiOperation;

@RestController
public class ProductQueryApi {

	@Autowired
	private ProductDAOImpl productDAOImpl;

	/**
	 * Get Product API
	 * 
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "Get Product API", notes = "Get Product API")
	@GetMapping(value = "/prodcut/{id}", produces = "application/json;charset=utf-8")
	public ResponseEntity<GenericResponseDTO> getProduct(@PathVariable Long id) {
		return new ResponseEntity<>(
				GenericResponseDTO.builder().code("200").messamge("OK").data(productDAOImpl.findById(id)).build(),
				HttpStatus.OK);
	}

	/**
	 * Get All Product API
	 * 
	 * @return
	 */
	@ApiOperation(value = "Get All Product API", notes = "Get All Product API")
	@GetMapping(value = "/prodcut", produces = "application/json;charset=utf-8")
	public ResponseEntity<GenericResponseDTO> getAllProduct() {
		return new ResponseEntity<>(
				GenericResponseDTO.builder().code("200").messamge("OK").data(productDAOImpl.findAll()).build(),
				HttpStatus.OK);
	}
}
