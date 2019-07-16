package it.contrader.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.contrader.model.Story;
import it.contrader.model.User;
import it.contrader.utils.ConnectionSingleton;

public class StoryDAO implements DAO<Story>{
	
	private final String QUERY_ALL = "SELECT * FROM storie";
	private final String QUERY_CREATE = "INSERT INTO storie (trama, id_Categoria) VALUES (?,?)";
	private final String QUERY_READ = "SELECT * FROM storie WHERE id_Storie=?";
	private final String QUERY_UPDATE = "UPDATE storie SET trama=? WHERE id_Storie=?";
	private final String QUERY_DELETE = "DELETE FROM storie WHERE id_Storie=?";

	@Override
	public List<Story> getAll() {
		// TODO Auto-generated method stub
		List<Story> storyList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Story story;
			while (resultSet.next()) {
				int id_Storie = resultSet.getInt("id_Storie");
				String trama = resultSet.getString("trama");
				int id_Categoria = resultSet.getInt("id_Categoria");
				story = new Story(trama, id_Categoria,id_Storie);
				//user.setId(id);
				storyList.add(story);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return storyList;
	}

	@Override
	public Story read(int id_Storie) {
		
		Connection connection = ConnectionSingleton.getInstance();
		try {


			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, id_Storie);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			String trama;
			int id_Categoria; 

			trama = resultSet.getString("trama");
			id_Categoria = resultSet.getInt("id_Categoria");
			
			Story story = new Story(trama, id_Categoria,id_Storie);
			story.setId_Storie(resultSet.getInt("id_Storie"));

			return story;
		} catch (SQLException e) {
			return null;
		}

	}

	public boolean insert(Story storyToInsert) {
		Connection connection = ConnectionSingleton.getInstance();
		try {	
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
			preparedStatement.setString(1, storyToInsert.getTrama());
			preparedStatement.setInt(2, storyToInsert.getId_Categoria());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			return false;
		}

	}

	public boolean update(Story storyToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();

		// Check if id is present
		if (storyToUpdate.getId_Storie() == 0)
			return false;

		Story storyRead = read(storyToUpdate.getId_Storie());
		if (!storyRead.equals(storyToUpdate)) {
			try {
				// Fill the userToUpdate object
				if (storyToUpdate.getTrama() == null || storyToUpdate.getTrama().equals("")) {
					storyToUpdate.setTrama(storyRead.getTrama());
				}

				// Update the user
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setString(1, storyToUpdate.getTrama());
				//preparedStatement.setInt(2, storyToUpdate.getId_Categoria());
				preparedStatement.setInt(2, storyToUpdate.getId_Storie());
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


	public boolean delete(int id_Storie)
	{
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
			preparedStatement.setInt(1, id_Storie);
			int n = preparedStatement.executeUpdate();
			if (n != 0)
				return true;

		} catch (SQLException e) {
		}
		return false;
	}
   
}
