package it.contrader.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import it.contrader.main.ConnectionSingleton;
import it.contrader.model.Libro;

/**
 * 
 * @author Vittorio
 *
 *         Per i dettagli della classe vedi Guida sez 6: DAO
 */
public class LibroDAO implements DAO<Libro> {
//todo artem
	private final String QUERY_ALL = "SELECT * FROM libro";
	private final String QUERY_CREATE = "INSERT INTO libro (nome_Libro, id_Categoria) VALUES (?,?)";
	private final String QUERY_READ = "SELECT * FROM libro WHERE id_Libro=?";
	private final String QUERY_UPDATE = "UPDATE libro SET id_libro=?, nome_Libro=?, id_Categoria=?";
	private final String QUERY_DELETE = "DELETE FROM libro WHERE id_Libro=?";

	public LibroDAO() {

	}

	public List<Libro> getAll() {
		List<Libro> libriList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Libro libro;
			while (resultSet.next()) {
				int id_Libro = resultSet.getInt("id_Libro");
				String nome_Libro = resultSet.getString("nome_Libro");
				int id_Categoria = resultSet.getInt("id_Categoria");
				String storia_Libro = resultSet.getString("storia");
				libro = new Libro(id_Libro, nome_Libro, id_Categoria, storia_Libro);
				libriList.add(libro);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return libriList;
	}

	public boolean insert(Libro libroToInsert) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
			preparedStatement.setString(1, libroToInsert.getNome_Libro());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			return false;
		}

	}

	public Libro read(int libroid_Libro) {
		Connection connection = ConnectionSingleton.getInstance();
		try {

			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, libroid_Libro);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			int id_Libro;
			int id_Categoria;
			String nome_Libro,storia;

			id_Libro = resultSet.getInt("id_Libro");
			nome_Libro = resultSet.getString("nome_Libro");
			id_Categoria = resultSet.getInt("id_Categoria");
			storia = resultSet.getString("storia");
			Libro libro = new Libro(id_Libro, nome_Libro, id_Categoria,storia);

			return libro;
		} catch (SQLException e) {
			return null;
		}

	}

	public boolean update(Libro libroToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();

		// Check if id is present
		if (libroToUpdate.getId_Libro() == 0)
			return false;

		Libro libroRead = read(libroToUpdate.getId_Libro());
		if (!libroRead.equals(libroToUpdate)) {
			try {
				// Fill the userToUpdate object
				if (libroToUpdate.getNome_Libro() == null || libroToUpdate.getNome_Libro().equals("")) {
					libroToUpdate.setNome_Libro(libroRead.getNome_Libro());
				}

				// Update the user
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setString(1, libroToUpdate.getNome_Libro());
				preparedStatement.setInt(2, libroToUpdate.getId_Libro());
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
