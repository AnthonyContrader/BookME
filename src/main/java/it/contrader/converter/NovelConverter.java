package it.contrader.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.contrader.dto.NovelDTO;
import it.contrader.model.Novel;

@Component
public class NovelConverter extends AbstractConverter<Novel,NovelDTO>{

	@Autowired
	CategoryConverter catconv;
	
	@Override
	public Novel toEntity(NovelDTO dto) {
		Novel n = null;
		if(dto != null) {
			n = new Novel();
			n.setIdNovel(dto.getIdCategory());
			n.setTitle(dto.getTitle());
			n.setPlot(dto.getPlot());
			n.setCategory(catconv.toEntity(dto.getCategory()));
		}
		return n;
	}

	@Override
	public NovelDTO toDTO(Novel entity) {
		NovelDTO n = null;
		if(entity != null) {
			n = new NovelDTO();
			n.setIdCategory(entity.getIdNovel());
			n.setTitle(entity.getTitle());
			n.setPlot(entity.getPlot());
			n.setCategory(catconv.toDTO(entity.getCategory()));
		}
		return n;
	}
	
}