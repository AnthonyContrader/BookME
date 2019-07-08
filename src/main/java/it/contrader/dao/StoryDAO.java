package it.contrader.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.contrader.main.ConnectionSingleton;
import it.contrader.model.Story;
import it.contrader.model.User;

public class StoryDAO implements DAO<Story>{
	
	private final String QUERY_ALL = "SELECT * FROM storie";
	private final String QUERY_CREATE = "INSERT INTO storie (trama) VALUES (?)";
	private final String QUERY_READ = "SELECT * FROM storie WHERE id_Storie=?";
	private final String QUERY_UPDATE = "UPDATE storie SET trama=? WHERE id_Storie=?";
	private final String QUERY_DELETE = "DELETE FROM storie WHERE id_Storie=?";
	
	public StoryDAO() {
		
	}
	
	public List<Story> getAll() {
		List<Story> storiesList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Story story;
			while (resultSet.next()) {
				int id = resultSet.getInt("id_Storie");
				String trama = resultSet.getString("trama");
				int categoryId = resultSet.getInt("id_Categoria");
				story = new Story(id,trama,categoryId);
				storiesList.add(story);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return storiesList;
	}
	
	public boolean insert(Story storyToInsert) {
		Connection connection = ConnectionSingleton.getInstance();
		try {	
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
			preparedStatement.setString(1, storyToInsert.getTrama());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			return false;
		}

	}
	
	public Story read(int storyId) {
		Connection connection = ConnectionSingleton.getInstance();
		try {


			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, storyId);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			String trama;

			trama = resultSet.getString("trama");
			Story story = new Story(trama);
			story.setId_storie(resultSet.getInt("id_Storie"));

			return story;
		} catch (SQLException e) {
			return null;
		}

	}
	
	public boolean update(Story storyToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();

		// Check if id is present
		if (storyToUpdate.getId_storie() == 0)
			return false;

		Story storyRead = read(storyToUpdate.getId_storie());
		if (!storyRead.equals(storyToUpdate)) {
			try {
				// Fill the storyToUpdate object
				if (storyToUpdate.getTrama() == null || storyToUpdate.getTrama().equals("")) {
					storyToUpdate.setTrama(storyRead.getTrama());
				}

				// Update the user
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setString(1, storyToUpdate.getTrama());
				preparedStatement.setInt(2, storyToUpdate.getId_storie());
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
