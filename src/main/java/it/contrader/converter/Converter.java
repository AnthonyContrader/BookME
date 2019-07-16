package it.contrader.converter;

public interface Converter<Entity,DTO> {

	public Entity convertToEntity(DTO dto);
	
	public DTO covertToDTO(Entity entity);
	
}
