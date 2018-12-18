package com.magneto.dna.analyzer;

import com.magneto.dna.domain.AnalysisResult;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class PrimaryAntidiagonalAnalyzerTest {

    private PrimaryAntidiagonalAnalyzer analyzer;

    @Before
    public void setup() {
        analyzer = new PrimaryAntidiagonalAnalyzer();
    }

    @Test
    public void shouldReturnAnalysisResultWith2MutationOccurrencies() {
        String[] dna = {
                "AATT",
                "AATT",
                "ATTA",
                "TTAA",
                "TAAA"};

        AnalysisResult result = analyzer.analyze(dna);
        Assert.assertEquals(2, (int) result.getMutationOccurrency());

    }

    @Test
    public void shouldReturnAnalysisResultWith1MutationOccurrency() {
        String[] dna = {
                "AATT",
                "AATA",
                "ATTA",
                "TTAA",
                "TAAA"};

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
                "AATT",
                "AATT",
                "ATTA",
                "TTAA",
                "TAAA",
                "AAAA"};


        AnalysisResult result = analyzer.analyze(dna);
        Assert.assertEquals(2, (int) result.getMutationOccurrency());

    }


}

