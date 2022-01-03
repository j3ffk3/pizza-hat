package com.example.product.application;

import org.springframework.stereotype.Service;

import com.example.product.domain.product.Product;

@Service
public class DeleteProductApplicationService {

	public void execute(Product product) {
		product.delete();
	}
}
