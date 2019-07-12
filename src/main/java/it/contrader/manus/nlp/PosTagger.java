package it.manus.nlp;

import java.io.IOException;
import java.io.InputStream;

import opennlp.tools.postag.POSModel;
import opennlp.tools.postag.POSTaggerME;

public class PosTagger {

	private POSTaggerME tagger;
	private POSModel model;
	
	private String[] tags;
	private double[] probs;
	
	public PosTagger(String[] tokens) throws IOException {
		
		InputStream is = getClass().getResourceAsStream("en-pos-maxent.bin");
		model = new POSModel(is);
		tagger = new POSTaggerME(model);
		
		tags = tagger.tag(tokens);
		probs = tagger.probs();
		
		is.close();
	}

	public String[] getTags() {
		return tags;
	}

	public double[] getProbs() {
		return probs;
	}
	
	
}
