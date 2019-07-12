package it.manus.nlp;

import java.io.IOException;
import java.io.InputStream;

import opennlp.tools.tokenize.*;
import opennlp.tools.util.Span;

public class Tokenizer {

	private TokenizerME tokenizer;
	private TokenizerModel model;
	
	private String[] tokens;
	private Span[] spans;
	private double[] probs;
	
	public Tokenizer(String sentence) throws IOException {
		
		InputStream is = getClass().getResourceAsStream("en-token.bin");
		
		model = new TokenizerModel(is);
		tokenizer = new TokenizerME(model);
		
		tokens = tokenizer.tokenize(sentence);
		spans = tokenizer.tokenizePos(sentence);
		probs = tokenizer.getTokenProbabilities();
		
		is.close();
	}

	public String[] getTokens() {
		return tokens;
	}

	public Span[] getSpans() {
		return spans;
	}

	public double[] getProbs() {
		return probs;
	}
	
	public int getLenght() {
		return tokens.length;
	}
	
}
