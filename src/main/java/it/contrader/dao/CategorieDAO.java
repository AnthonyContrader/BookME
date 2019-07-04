package it.contrader.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.contrader.main.ConnectionSingleton;
import it.contrader.model.Categorie;
import it.contrader.model.User;

public class CategorieDAO implements DAO<Categorie>{

	private final String QUERY_ALL = "SELECT * FROM Categorie";
	private final String QUERY_CREATE = "INSERT INTO Categorie (id, nome_Categorie) VALUES (?,?)";
	private final String QUERY_READ = "SELECT * FROM Categorie WHERE id=?";
	private final String QUERY_UPDATE = "UPDATE Categorie SET id=?, nome_Categorie=? WHERE id=?";
	private final String QUERY_DELETE = "DELETE FROM Categorie WHERE id=?";
	@Override
	public List<Categorie> getAll() {
		// TODO Auto-generated method stub
		
		List<Categorie> CategorieList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Categorie categorie;
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String nome_Categoria = resultSet.getString("nome_Categorie");
				
				categorie = new Categorie(id, nome_Categoria);
				CategorieList.add(categorie);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return CategorieList;
	}

	@Override
	public Categorie read(int id) {
		Connection connection = ConnectionSingleton.getInstance();
		try {


			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			String categoryName;

			categoryName = resultSet.getString("nome_Categorie");
			Categorie categoria = new Categorie(id,categoryName);
			return categoria;
		} catch (SQLException e) {
			return null;
		}
	}

	@Override
	public boolean insert(Categorie categoria) {
		Connection connection = ConnectionSingleton.getInstance();
		try {	
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
			preparedStatement.setInt(1,categoria.getId());
			preparedStatement.setString(2, categoria.getNome_Categorie());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			return false;
		}
	}

	@Override
	public boolean update(Categorie categoriaToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();

		// Check if id is present
		if (categoriaToUpdate.getId() == 0)
			return false;

		Categorie categoriaRead = read(categoriaToUpdate.getId());
		if (!categoriaRead.equals(categoriaToUpdate)) {
			try {
				// Fill the userToUpdate object
				if (categoriaToUpdate.getNome_Categorie() == null || categoriaToUpdate.getNome_Categorie().equals("")) {
					categoriaToUpdate.setNome_Categorie(categoriaRead.getNome_Categorie());
				}

				if (categoriaToUpdate.getId() < 0) {
					categoriaToUpdate.setId(categoriaRead.getId());
				}


				// Update the user
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setInt(1, categoriaToUpdate.getId());
				preparedStatement.setString(2, categoriaToUpdate.getNome_Categorie());
				preparedStatement.setInt(3, categoriaToUpdate.getId());
				preparedStatement.setInt(4, categoriaToUpdate.getId());
				int a = preparedStatement.executeUpdate();
				if (a > 0)
					return true;
				else
					return false;

			} catch (SQLException e) {
				return false;
			}
		}

		return false;
	}

	@Override
	public boolean delete(int id) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
			preparedStatement.setInt(1, id);
			int n = preparedStatement.executeUpdate();
			if (n != 0)
				return true;

		} catch (SQLException e) {
		}
		return false;
	}

}
