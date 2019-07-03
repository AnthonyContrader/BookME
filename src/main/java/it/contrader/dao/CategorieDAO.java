package it.contrader.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.contrader.main.ConnectionSingleton;
import it.contrader.model.Categorie;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insert(Categorie dto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Categorie dto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
