package it.contrader.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.contrader.model.Category;
import it.contrader.model.User;
import it.contrader.utils.ConnectionSingleton;

public class CategoryDAO implements DAO<Category>
{
	private final String QUERY_ALL = "SELECT * FROM categorie";
	private final String QUERY_CREATE = "INSERT INTO categorie (nome_Categorie) VALUES (?)";
	private final String QUERY_READ = "SELECT * FROM categorie WHERE id=?";
	private final String QUERY_UPDATE = "UPDATE categorie SET nome_Categorie=? WHERE id=?";
	private final String QUERY_DELETE = "DELETE FROM categorie WHERE id=?";

	@Override
	public List<Category> getAll()
	{
		List<Category> categoryList = new ArrayList<Category>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Category c;
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				
				String usertype = resultSet.getString("nome_Categorie");
				c = new Category(id, usertype);
				
				categoryList.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return categoryList;
	}

	@Override
	public Category read(int id) {
		Connection connection = ConnectionSingleton.getInstance();
		try {


			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			String nomeCategoria;

			
			nomeCategoria = resultSet.getString("nome_Categorie");
			Category c = new Category(nomeCategoria);
			

			return c;
		} catch (SQLException e) {
			return null;
		}
	}

	@Override
	public boolean insert(Category dto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Category dto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	

}
