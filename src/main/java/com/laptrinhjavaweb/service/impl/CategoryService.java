package com.laptrinhjavaweb.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.laptrinhjavaweb.dao.ICategoryDao;
import com.laptrinhjavaweb.model.CategoryModel;
import com.laptrinhjavaweb.service.ICategoryService;

public class CategoryService implements ICategoryService {
//	private ICategoryDao categorydao;
//	public public CategoryService() {
//		categorydao  = new CategoryDAO();
//		
//	}
@Inject
	private ICategoryDao categoryDao;
	
	
	@Override
	public List<CategoryModel> findAll() {
		
		return categoryDao.findAll();
		
	}
	

}
