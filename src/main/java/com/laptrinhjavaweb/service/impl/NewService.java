package com.laptrinhjavaweb.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.laptrinhjavaweb.dao.INewDao;
import com.laptrinhjavaweb.model.NewModel;
import com.laptrinhjavaweb.service.INewSevice;

public class NewService implements INewSevice {
@Inject
private INewDao newDao;

	@Override
	public List<NewModel> findBycategoryId(Long categogyId) {
		
		return newDao.findByCategoryId(categogyId);
	}

}
