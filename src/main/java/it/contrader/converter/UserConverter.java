package it.contrader.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.contrader.dto.UserDTO;

import it.contrader.model.User;

/**
 * Questa classe implementa i metodi di conversione dell'entità User.
 *  
 * @author Vittorio Valent & Girolamo Murdaca
 * 
 *@see AbstractConverter
 *@see Converter
 */
@Component
public class UserConverter extends AbstractConverter<User,UserDTO> {

	@Autowired
	private StoryConverter storyConverter;
	
	@Override
	public User toEntity(UserDTO userDTO) {
		User user = null;
		if (userDTO != null) {
			user = new User();
			user.setId(userDTO.getId());
			user.setUsername(userDTO.getUsername());
			user.setPassword(userDTO.getPassword());
			user.setUsertype(userDTO.getUsertype());
			user.setActive(userDTO.isActive());
//			user.setStories(storyConverter.toEntityList(userDTO.getStories()));
			
		}
		return user;
	}

	@Override
	public UserDTO toDTO(User user) {
		UserDTO userDTO = null;
		if (user != null) {
			userDTO = new UserDTO();
			userDTO.setId(user.getId());
			userDTO.setUsername(user.getUsername());
			userDTO.setPassword(user.getPassword());
			userDTO.setUsertype(user.getUsertype());
			userDTO.setActive(user.isActive());
//			userDTO.setStories(storyConverter.toDTOList(user.getStories()));
		}
		return userDTO;
	}
}