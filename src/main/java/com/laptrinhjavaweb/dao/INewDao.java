package com.laptrinhjavaweb.dao;

import java.util.List;

import com.laptrinhjavaweb.model.NewModel;

public interface INewDao {
	List<NewModel>findByCategoryId(Long caterogyId);

}
