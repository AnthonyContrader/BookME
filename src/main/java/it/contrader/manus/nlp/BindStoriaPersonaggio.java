package it.manus.nlp;

import java.util.ArrayList;
import java.util.List;
import it.contrader.dto.StoryDTO;
import it.contrader.dto.PersonaggiDTO;

import opennlp.tools.util.Span;

public class BindStoriaPersonaggio {
	
	/**
	 * Copia incolla questo metodo nel servlet
	 * @param story
	 */
	public void collegaStoriaPersonaggi(StoryDTO story) {
		String trama = story.getTrama();
		List<PersonaggiDTO> lista = new ArrayList<>();
		SentenceDetector detector = new SentenceDetector(trama);
		
		/**
		 * Prende tutti i personaggi nominati nella storia e popola la lista,
		 * Ogni oggetto PersonaggioDTO contiene NomePersonaggio e IdStoria
		 */
		for(String s : detector.getSentences()) {
			Tokenizer tokenizer = new Tokenizer(s);
			NameFinder nf = new NameFinder(tokenizer.getTokens());
			for(Span span : nf.getNames()) {
				String nome_personaggio = tokenizer.getTokens()[span.getStart()];
				PersonaggiDTO p = new PersonaggiDTO(nome_personaggio, story.getId());
				if(!lista.contains(p)) {
					lista.add(p);
				}
			}
		}
		
		/**
		 * Inserisce tutti i nuovi personaggi nel db tramite il service
		 */
		for(PersonaggiDTO p : lista) {
			personaggiService.insert(p);
		}
	}
}
