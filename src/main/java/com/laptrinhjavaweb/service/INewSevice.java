package com.laptrinhjavaweb.service;

import java.util.List;

import com.laptrinhjavaweb.model.NewModel;

public interface INewSevice {
	List<NewModel> findBycategoryId(Long categogyId);
}
