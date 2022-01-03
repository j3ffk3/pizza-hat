package com.example.product.infra.converter;

import org.mapstruct.Mapper;

import com.example.product.apis.dto.ProductRequestDTO;
import com.example.product.apis.dto.ProductResponseDTO;
import com.example.product.domain.product.Product;
import com.example.product.infra.po.ProductPO;
import com.example.product.infra.util.ApplicationContextUtils;

@Mapper(componentModel = "spring", uses = ApplicationContextUtils.class)
public interface ProductConverter {

	Product dtoToDo(ProductRequestDTO productRequestDTO);

	Product pathVarToDo(Long id);

	ProductPO doToPo(Product product);

	Product poToDo(ProductPO productPO);
	
	ProductResponseDTO doToDto(Product product);

}
