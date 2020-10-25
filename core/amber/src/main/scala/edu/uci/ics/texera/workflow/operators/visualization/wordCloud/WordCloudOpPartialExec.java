package edu.uci.ics.texera.workflow.operators.visualization.wordCloud;

import edu.uci.ics.amber.engine.common.InputExhausted;
import edu.uci.ics.texera.workflow.common.operators.OperatorExecutor;
import edu.uci.ics.texera.workflow.common.tuple.Tuple;
import edu.uci.ics.texera.workflow.common.tuple.schema.Attribute;
import edu.uci.ics.texera.workflow.common.tuple.schema.AttributeType;
import edu.uci.ics.texera.workflow.common.tuple.schema.Schema;
import org.apache.curator.shaded.com.google.common.collect.Iterators;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.core.StopAnalyzer;
import org.apache.lucene.analysis.tokenattributes.OffsetAttribute;
import scala.collection.Iterator;
import scala.collection.JavaConverters;
import scala.util.Either;

import java.io.StringReader;
import java.util.*;

public class WordCloudOpPartialExec implements OperatorExecutor {
    private final String textColumn;
    private final String luceneAnalyzerName;
    private List<String> textList;
    private static final Schema resultSchema = Schema.newBuilder().add(
            new Attribute("word", AttributeType.STRING),
            new Attribute("size", AttributeType.INTEGER)
    ).build();

    public WordCloudOpPartialExec(String textColumn, String luceneAnalyzerName) {
        this.textColumn = textColumn;
        this.luceneAnalyzerName = luceneAnalyzerName;
    }

    private static List<Tuple> calculateWordCount(List<String> texts, String analyzerName) throws Exception {
        HashMap<String, Integer> termFreqMap = new HashMap<>();

        for (String text : texts) {
            Analyzer luceneAnalyzer = LuceneAnalyzerConstants.getLuceneAnalyzer(analyzerName);
            TokenStream tokenStream = luceneAnalyzer.tokenStream(null, new StringReader(text));
            OffsetAttribute offsetAttribute = tokenStream.addAttribute(OffsetAttribute.class);

            tokenStream.reset();
            while (tokenStream.incrementToken()) {
                int charStart = offsetAttribute.startOffset();
                int charEnd = offsetAttribute.endOffset();
                String termStr = text.substring(charStart, charEnd).toLowerCase();
                if (!StopAnalyzer.ENGLISH_STOP_WORDS_SET.contains(termStr))
                    termFreqMap.put(termStr, termFreqMap.get(termStr)==null ? 1 : termFreqMap.get(termStr) + 1);
            }
            tokenStream.close();
        }
        List<Tuple> termFreqTuples = new ArrayList<>();

        for (Map.Entry<String, Integer> e : termFreqMap.entrySet()) {
            termFreqTuples.add(Tuple.newBuilder().add(resultSchema, Arrays.asList(e.getKey(), e.getValue())).build());
        }
        return termFreqTuples;
    }

    @Override
    public void open() {
        textList = new ArrayList<>();
    }

    @Override
    public void close() {

    }

    @Override
    public String getParam(String query) {
        return null;
    }

    @Override
    public Iterator<Tuple> processTexeraTuple(Either<Tuple, InputExhausted> tuple, int input) {
        if(tuple.isLeft()) {
            textList.add(tuple.left().get().getField(textColumn));
            return JavaConverters.asScalaIterator(Iterators.emptyIterator());
        }
        else {
            try {
                return(JavaConverters.asScalaIterator(calculateWordCount(textList, luceneAnalyzerName).iterator()));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
