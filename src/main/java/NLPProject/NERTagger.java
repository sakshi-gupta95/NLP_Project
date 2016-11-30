package NLPProject;

import java.io.File;
import java.io.FileInputStream;

import opennlp.tools.namefind.NameFinderME;
import opennlp.tools.namefind.TokenNameFinderModel;
import opennlp.tools.tokenize.SimpleTokenizer;
import opennlp.tools.tokenize.Tokenizer;
import opennlp.tools.util.Span;

public class NERTagger {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String[] sentences = {"Former first lady Nancy Reagan was taken to a " +
				"suburban Los Angeles " +
				"hospital 'as a precaution' Sunday after a " +
				"fall at her home, an " +
				"aide said. ",
				"The 86-year-old Reagan will remain overnight for " +
						"observation at a hospital in Santa Monica, California, " +
						"said Joanne " +
		"Drake, chief of staff for the Reagan Foundation.",
		"Sakshi is the CEO of Salesforce corp. "};
		
		NameFinderME finder = new NameFinderME(new TokenNameFinderModel(new FileInputStream(new File("/home/jyoti/workspace-jee/QA/src/main/resources/en-ner-person.bin"))));
		Tokenizer tokenizer = SimpleTokenizer.INSTANCE;
		for(int si=0; si<sentences.length;si++){
			String[] tokens = tokenizer.tokenize(sentences[si]);
			Span[] names = finder.find(tokens);
			double[] spanProbs = finder.probs(names);
			for(int ni=0;ni<names.length;ni++){
				System.out.print(names[ni]+"\t"+spanProbs[ni]+'\t');
			}
			System.out.println();
		}
		
		finder.clearAdaptiveData();
	}

}
