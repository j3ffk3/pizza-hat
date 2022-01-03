package com.example.product.apis.dto;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponseDTO {

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
	 * size
	 */
	private String size;

	/**
	 * stuffing
	 */
	private String stuffing;

	/**
	 * price
	 */
	private BigDecimal price;

}
