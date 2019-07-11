package it.contrader.service;

import java.util.List;

import it.contrader.converter.Converter;
import it.contrader.dao.DAO;

/**
 * 
 * @author Vittorio
 *
 * @param <DTO> Usa lo stesso tipo generico dell'interfaccia, verr� specificato
 * in ciascuna classe concreta. Tutti i metodi di CRUD sono quindi implementati usando dei tipi generici. 
 * Cos� facendo le classi che estendono questa classe astratta ereditano i metodi sotto descritti, risparmiandoci
 * la fatica di implementarli ogni volta cambiando solo i nomi!
 */
public abstract class AbstractService<Entity,DTO> implements Service<DTO> {

	protected DAO<Entity> dao;
	
	protected Converter<Entity,DTO> converter;
	
	public List<DTO> getAll() {
		// Ottiene una lista di entit� e le restituisce convertendole in DTO
		return converter.toDTOList(dao.getAll());
	}

	public DTO read(int id) {
		// Ottiene un'entit� e la restituisce convertendola in DTO
		return converter.toDTO(dao.read(id));
	}

	public boolean insert(DTO dto) {
		// Converte un DTO in entit� e lo passa al DAO per l'inserimento
		return dao.insert(converter.toEntity(dto));
	}

	public boolean update(DTO dto) {
		// Converte un DTO in entit� e lo passa al DAO per la modifica
		return dao.update(converter.toEntity(dto));
	}

	public boolean delete(int id) {
		// Questo mtodo chiama direttamente il DAO
		return dao.delete(id);
	}

}
