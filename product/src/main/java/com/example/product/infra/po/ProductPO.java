package com.example.product.infra.po;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Entity
@Table(name = "PRODUCT")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProductPO {

	/**
	 * id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
