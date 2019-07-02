package it.contrader.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import it.contrader.main.ConnectionSingleton;
import it.contrader.model.Personaggi;

/**
 * 
 * @author Vittorio
 *
 *Per i dettagli della classe vedi Guida sez 6: DAO
 */
public class PersonaggiDAO implements DAO<Personaggi> {

	private final String QUERY_ALL = "SELECT * FROM Personaggi";
	private final String QUERY_CREATE = "INSERT INTO Personaggi (Personagginame, password, Personaggitype) VALUES (?,?,?)";
	private final String QUERY_READ = "SELECT * FROM Personaggi WHERE id=?";
	private final String QUERY_UPDATE = "UPDATE Personaggi SET Personagginame=?, password=?, Personaggitype=? WHERE id=?";
	private final String QUERY_DELETE = "DELETE FROM Personaggi WHERE id=?";

	public PersonaggiDAO() {

	}

	public List<Personaggi> getAll() {
		List<Personaggi> PersonaggisList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Personaggi Personaggi;
			while (resultSet.next()) {
				int id_Personaggio = resultSet.getInt("id_Personaggio");
				String nota = resultSet.getString("nota");
				
				Personaggi = new Personaggi(id_Personaggio, nota);
				Personaggi.setId_Personaggio(id_Personaggio);
				PersonaggisList.add(Personaggi);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return PersonaggisList;
	}

	public boolean insert(Personaggi PersonaggiToInsert) {
		Connection connection = ConnectionSingleton.getInstance();
		try {	
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
			//preparedStatement.setString(1, PersonaggiToInsert.getId_Personaggio());
			preparedStatement.setString(2, PersonaggiToInsert.getNota());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			return false;
		}

	}

	public Personaggi read(int idPersonaggi) {
		Connection connection = ConnectionSingleton.getInstance();
		try {


			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, idPersonaggi);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			String id_Personaggi, nota;

			id_Personaggi = resultSet.getString("id_Personaggi");
			nota = resultSet.getString("nota");
	
			Personaggi Personaggi = new Personaggi(idPersonaggi, nota);
			Personaggi.setId_Personaggio(resultSet.getInt("id_Personaggi"));

			return Personaggi;
		} catch (SQLException e) {
			return null;
		}

	}

	public boolean update(Personaggi PersonaggiToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();

		// Check if id is present
		if (PersonaggiToUpdate.getId_Personaggio() == 0)
			return false;

		Personaggi PersonaggiRead = read(PersonaggiToUpdate.getId_Personaggio());
		if (!PersonaggiRead.equals(PersonaggiToUpdate)) {
			try {
				// Fill the PersonaggiToUpdate object
			

				if (PersonaggiToUpdate.getNota() == null || PersonaggiToUpdate.getNota().equals("")) {
					PersonaggiToUpdate.setNota(PersonaggiRead.getNota());
				}


				// Update the Personaggi
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setString(1, PersonaggiToUpdate.getNota());

				preparedStatement.setInt(2, PersonaggiToUpdate.getId_Personaggio());
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

