package com.example.product.apis.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GenericResponseDTO {

	/**
	 * Code
	 */
	private String code;

	/**
	 * Message
	 */
	private String messamge;

	/**
	 * Response Body
	 */
	@JsonInclude(Include.NON_NULL)
	private Object data;
}
