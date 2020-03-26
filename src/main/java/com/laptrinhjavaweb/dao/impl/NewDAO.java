package com.laptrinhjavaweb.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.laptrinhjavaweb.dao.INewDao;
import com.laptrinhjavaweb.model.CategoryModel;
import com.laptrinhjavaweb.model.NewModel;

public class NewDAO implements INewDao {

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
	public List<NewModel> findByCategoryId(Long caterogyId) {
		List<NewModel> results = new ArrayList<>();
		String sql = "select *from news WHERE categoryid = ? ";
		Connection connection = getConnection();
		PreparedStatement statement = null; // đối tượng để thực thi câu lệnh sql
		ResultSet resultset = null;

		if (connection != null) {

			try {
				statement = connection.prepareStatement(sql);
				statement.setLong(1, caterogyId);
				resultset = statement.executeQuery();
				while (resultset.next()) {
					NewModel news = new NewModel();
					news.setId(resultset.getLong("id"));
					news.setTitle(resultset.getString("title"));
					results.add(news);
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
