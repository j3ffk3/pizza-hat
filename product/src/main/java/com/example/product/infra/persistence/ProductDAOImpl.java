package com.example.product.infra.persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.product.domain.product.Product;
import com.example.product.domain.product.repository.facade.ProductDAO;
import com.example.product.infra.converter.ProductConverter;
import com.example.product.infra.mapper.ProductRepository;
import com.example.product.infra.po.ProductPO;

@Service
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ProductConverter productConverter;

	@Override
	public List<Product> findAll() {
		List<Product> doList = new ArrayList<>();
		productRepository.findAll().forEach(item -> {
			doList.add(productConverter.poToDo(item));
		});
		return doList;
	}

	@Override
	public Product findById(Long id) {
		Optional<ProductPO> productPO = productRepository.findById(id);
		if (productPO.isPresent()) {
			return productConverter.poToDo(productPO.get());
		} else {
			return null;
		}
	}

	@Override
	public void create(Product product) {
		ProductPO productPo = productConverter.doToPo(product);
		productRepository.save(productPo);

	}

	@Override
	public void update(Product product) {
		ProductPO productPo = productConverter.doToPo(product);
		productRepository.save(productPo);
	}

	@Override
	public void deleteById(Long id) {
		productRepository.deleteById(id);

	}

}
