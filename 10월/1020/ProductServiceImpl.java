package com.ssafy.model.service;

import java.util.List;

import com.ssafy.model.dto.Product;
import com.ssafy.model.repository.ProductRepo;
import com.ssafy.model.repository.ProductRepoImpl;

public class ProductServiceImpl implements ProductService {

	ProductRepo repo;
	
	@Override
	public ProductRepo getRepo() {
		if(repo == null) {
			repo = new ProductRepoImpl();
		}
		return repo;
	}

	@Override
	public List<Product> selectAll() {
		return getRepo().selectAll();
	}

	@Override
	public Product select(String id) {
		return getRepo().select(id);
	}

	@Override
	public int insert(Product product) {
		return getRepo().insert(product);
	}

	@Override
	public int update(Product product) {
		return getRepo().update(product);
	}

	@Override
	public int delete(Product product) {
		return getRepo().delete(product);
	}

}
