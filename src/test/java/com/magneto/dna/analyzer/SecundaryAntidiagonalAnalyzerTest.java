package com.magneto.dna.analyzer;

import com.magneto.dna.domain.AnalysisResult;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SecundaryAntidiagonalAnalyzerTest {

    private SecundaryAntidiagonalAnalyzer analyzer;

    @Before
    public void setup() {
        analyzer = new SecundaryAntidiagonalAnalyzer();
    }

    @Test
    public void shouldReturnAnalysisResultWith2MutationOccurrencies() {
        String[] dna = {
                "AATTAA",
                "AATTAA",
                "ATTAAA",
                "TTAAAA",
                "TAAAAA"};

        AnalysisResult result = analyzer.analyze(dna);
        Assert.assertEquals(2, (int) result.getMutationOccurrency());

    }

    @Test
    public void shouldReturnAnalysisResultWith1MutationOccurrency() {
        String[] dna = {
                "AATTAA",
                "AATTAA",
                "ATTATT",
                "TTAAAA",
                "TAAAAA"};

        AnalysisResult result = analyzer.analyze(dna);
        Assert.assertEquals(1, (int) result.getMutationOccurrency());

    }

    @Test
    public void shouldReturnAnalysisResultWith0MutationOccurrency() {
        String[] dna = {
                "AATT",
                "AAAA",
                "ATTA",
                "TTAA",
                "TAAA"};

        AnalysisResult result = analyzer.analyze(dna);
        Assert.assertEquals(0, (int) result.getMutationOccurrency());

    }

    @Test
    public void shouldReturnAnalysisResultWith2MutationOccurrenciesWhenDnaContainsMultiplesMutations() {
        String[] dna = {
                "AATTAAA",
                "AATTAAA",
                "ATTAAAA",
                "TTAAAAA",
                "TAAAAAA"};

        AnalysisResult result = analyzer.analyze(dna);
        Assert.assertEquals(2, (int) result.getMutationOccurrency());

    }


}