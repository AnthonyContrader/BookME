package it.contrader.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.contrader.model.Personaggi;
import it.contrader.utils.ConnectionSingleton;

public class PersonaggiDAO implements DAO<Personaggi>{
	
	private final String QUERY_ALL = "SELECT * FROM personaggi";
	private final String QUERY_CREATE = "INSERT INTO personaggi (nome, id_Storie) VALUES (?,?)";
	private final String QUERY_READ = "SELECT * FROM personaggi WHERE id_Personaggio=?";
	private final String QUERY_UPDATE = "UPDATE storie SET nome=? ,id_Storia=? WHERE id_Personaggio=?";
	private final String QUERY_DELETE = "DELETE FROM storie WHERE id_Personaggio=?";

	@Override
	public List<Personaggi> getAll() {
		// TODO Auto-generated method stub
		List<Personaggi> personaggiList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Personaggi personaggi;
			while (resultSet.next()) {
				int id_Personaggio = resultSet.getInt("id_Personaggio");
				String nome = resultSet.getString("nome");
				int id_Storie = resultSet.getInt("id_Storie");
				
				personaggi = new Personaggi(id_Storie, nome);
				//user.setId(id);
				personaggiList.add(personaggi);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return personaggiList;
	}

	@Override
	public Personaggi read(int id_Personaggi) {
		
		Connection connection = ConnectionSingleton.getInstance();
		try {


			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, id_Personaggi);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			String nome;
			int id_Storie; 

			nome = resultSet.getString("nome");
			id_Storie = resultSet.getInt("id_Storie");
			
			Personaggi personaggi = new Personaggi(id_Storie, nome);
			personaggi.setId_Personaggio(resultSet.getInt("id_Personaggi"));

			return personaggi;
		} catch (SQLException e) {
			return null;
		}

	}

	public boolean insert(Personaggi x) {
		Connection connection = ConnectionSingleton.getInstance();
		try {	
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
			preparedStatement.setString(1, x.getnome());
			preparedStatement.setInt(2, x.getId_Storie());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			return false;
		}

	}

	public boolean update(Personaggi personaggiToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();

		// Check if id is present
		if (personaggiToUpdate.getId_Personaggio() == 0)
			return false;

		Personaggi personaggiRead = read(personaggiToUpdate.getId_Personaggio());
		if (!personaggiRead.equals(personaggiToUpdate)) {
			try {
				// Fill the userToUpdate object
				if (personaggiToUpdate.getnome() == null || personaggiToUpdate.getnome().equals("")) {
					personaggiToUpdate.setnome(personaggiRead.getnome());
				}

				// Update the user
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setString(1, personaggiToUpdate.getnome());
				preparedStatement.setInt(2, personaggiToUpdate.getId_Storie());
				preparedStatement.setInt(3, personaggiToUpdate.getId_Personaggio());
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


	public boolean delete(int id_Personaggio) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
			preparedStatement.setInt(1, id_Personaggio);
			int n = preparedStatement.executeUpdate();
			if (n != 0)
				return true;

		} catch (SQLException e) {
		}
		return false;
	}
   
}
