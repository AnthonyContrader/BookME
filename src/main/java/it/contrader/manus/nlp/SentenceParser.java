package it.manus.nlp;

import java.io.IOException;
import java.io.InputStream;

import opennlp.tools.cmdline.parser.ParserTool;
import opennlp.tools.parser.*;

public class SentenceParser {

	private ParserModel model;
	private Parser parser;
	private Parse[] topParse;
	
	public SentenceParser(String sentence) throws IOException {
		InputStream is = getClass().getResourceAsStream("en-parser-chunking.bin");
		model = new ParserModel(is);
		parser = ParserFactory.create(model);
		topParse = ParserTool.parseLine(sentence, parser, 1);
		is.close();
		
	}

	public Parse[] getTopParse() {
		return topParse;
	}
	
	
}
