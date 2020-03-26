package com.laptrinhjavaweb.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.laptrinhjavaweb.dao.ICategoryDao;
import com.laptrinhjavaweb.model.CategoryModel;

public class CategoryDAO implements ICategoryDao {

	public Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Drive");
			String url = "jdbc:mysql://localhost:3306/jspservletjdbc";
			String user = "root";
			String password = "123456789";
			return DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException | SQLException e) {
			return null;

		}

	}

	@Override
	public List<CategoryModel> findAll() {
		List<CategoryModel> results = new ArrayList<>();
		String sql = "select *from category";
		Connection connection = getConnection();
		PreparedStatement statement = null; // đối tượng để thực thi câu lệnh sql
		ResultSet resultset = null;

		if (connection != null) {

			try {
				statement = connection.prepareStatement(sql);
				resultset = statement.executeQuery();
				while (resultset.next()) {
					CategoryModel category = new CategoryModel();
					category.setId(resultset.getLong("id"));
					category.setName("name");
					results.add(category);

				}

			} catch (SQLException e) {

				return results;
			} finally {
				try {
					if (connection != null) {
						connection.close();

					}
					if (statement != null) {
						statement.close();

					}
					if (results != null) {
						resultset.close();
					}

				} catch (SQLException e) {
					return null;
				}

			}
		}
		return null;
	}

}
