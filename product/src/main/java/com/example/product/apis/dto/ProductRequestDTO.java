package com.example.product.apis.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequestDTO {

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
