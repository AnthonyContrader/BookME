package it.contrader.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.contrader.model.Libro;
import it.contrader.model.Story;
import it.contrader.utils.ConnectionSingleton;

public class LibriDAO implements DAO<Libro>
{
	private final String QUERY_ALL = "SELECT * FROM libro";
	private final String QUERY_CREATE = "INSERT INTO libro (nome_Libro, id_Categoria) VALUES (?,?)";
	private final String QUERY_READ = "SELECT * FROM libro WHERE id_Libro=?";
	private final String QUERY_UPDATE = "UPDATE libro SET nome_Libro=? ,id_Categoria=? WHERE id_Libro=?";
	private final String QUERY_DELETE = "DELETE FROM libro WHERE id_Libro=?";

	@Override
	public List<Libro> getAll() {
		
		List<Libro> listaLibri = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Libro libro;
			while (resultSet.next()) {
				int id_Libro = resultSet.getInt("id_Libro");
				String nomeLibro = resultSet.getString("nome_Libro");
				int id_Categoria = resultSet.getInt("id_Categoria");
				libro = new Libro(nomeLibro, id_Libro, id_Categoria);
				//user.setId(id);
				listaLibri.add(libro);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaLibri;
	}

	@Override
	public Libro read(int id) {
		try {

			Connection connection = ConnectionSingleton.getInstance();
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			String nomeLibro;
			int id_Categoria; 

			nomeLibro = resultSet.getString("nome:Libro");
			id_Categoria = resultSet.getInt("id_Categoria");
			
			Libro libro = new Libro(nomeLibro, id_Categoria);
			

			return libro;
		} catch (SQLException e) {
			return null;
		}

	}

	@Override
	public boolean insert(Libro libroDto) {
		Connection connection = ConnectionSingleton.getInstance();
		try {	
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
			preparedStatement.setString(1, libroDto.getNomeLibro());
			preparedStatement.setInt(2, libroDto.getId_Categoria());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			return false;
		}
	}

	@Override
	public boolean update(Libro dto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id_Libro) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
			preparedStatement.setInt(1, id_Libro);
			int n = preparedStatement.executeUpdate();
			if (n != 0)
				return true;

		} catch (SQLException e) {
		}
		return false;
	}
	}

	


