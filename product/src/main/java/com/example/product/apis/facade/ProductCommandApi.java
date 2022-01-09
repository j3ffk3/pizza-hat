package com.example.product.apis.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.product.apis.dto.GenericResponseDTO;
import com.example.product.apis.dto.ProductRequestDTO;
import com.example.product.application.CreateProductApplicationService;
import com.example.product.application.DeleteProductApplicationService;
import com.example.product.application.UpdateProductApplicationService;
import com.example.product.domain.product.Product;
import com.example.product.infra.converter.ProductConverter;

import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class ProductCommandApi {

	@Autowired
	private CreateProductApplicationService createProductApplicationService;

	@Autowired
	private UpdateProductApplicationService updateProductApplicationService;

	@Autowired
	private DeleteProductApplicationService deleteProductApplicationService;

	@Autowired
	private ProductConverter productConverter;

	/**
	 * Create Product API
	 * 
	 * @return
	 */
	@ApiOperation(value = "Create Product API", notes = "Create Product API")
	@PostMapping(value = "/product", produces = "application/json;charset=utf-8")
	public ResponseEntity<GenericResponseDTO> createProduct(@RequestBody ProductRequestDTO productRequestDTO) {
		createProductApplicationService.execute(productConverter.dtoToDo(productRequestDTO));
		return new ResponseEntity<>(GenericResponseDTO.builder().code("200").messamge("OK").build(), HttpStatus.OK);
	}

	/**
	 * Update Product API
	 * 
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "Update Product API", notes = "Update Product API")
	@PutMapping(value = "/product/{id}", produces = "application/json;charset=utf-8")
	public ResponseEntity<GenericResponseDTO> updateProduct(@PathVariable Long id,
			@RequestBody ProductRequestDTO productRequestDTO) {
		Product product = productConverter.dtoToDo(productRequestDTO);
		product.setId(id);
		updateProductApplicationService.execute(product);
		return new ResponseEntity<>(GenericResponseDTO.builder().code("200").messamge("OK").build(), HttpStatus.OK);
	}

	/**
	 * Delete Product API
	 * 
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "Delete Product API", notes = "Delete Product API")
	@DeleteMapping(value = "/product/{id}", produces = "application/json;charset=utf-8")
	public ResponseEntity<GenericResponseDTO> deleteProduct(@PathVariable Long id) {
		deleteProductApplicationService.execute(productConverter.pathVarToDo(id));
		return new ResponseEntity<>(GenericResponseDTO.builder().code("200").messamge("OK").build(), HttpStatus.OK);
	}

}
