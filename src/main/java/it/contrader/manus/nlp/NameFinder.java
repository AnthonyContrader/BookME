package it.manus.nlp;

import java.io.IOException;
import java.io.InputStream;

import opennlp.tools.namefind.*;

import opennlp.tools.namefind.TokenNameFinderModel;
import opennlp.tools.util.Span; 

public class NameFinder {

	private NameFinderME nf;
	private TokenNameFinderModel model;
	
	private Span[] names;
	private double[] probs;
	
	public NameFinder(String[] tokens) throws IOException {
		InputStream is = getClass().getResourceAsStream("en-ner-person.bin");
		model = new TokenNameFinderModel(is);
		nf = new NameFinderME(model);
	
		names = nf.find(tokens);
		probs = nf.probs();
		
		is.close();
		
	}

	public Span[] getNames() {
		return names;
	}

	public double[] getProbs() {
		return probs;
	}

	public int getLenght() {
		
		return names.length;
	}
	
	
}

