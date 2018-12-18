package com.magneto.dna.analyzer;


import com.magneto.dna.domain.AnalysisResult;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class VerticalAnalyzerTest {

    private VerticalAnalyzer analyzer;

    @Before
    public void setup() {
        analyzer = new VerticalAnalyzer();
    }

    @Test
    public void shouldReturnAnalysisResultWith2MutationOccurrencies() {
        String[] dna = {
                "AAAT",
                "AATA",
                "AAAT",
                "AATA"};

        AnalysisResult result = analyzer.analyze(dna);
        Assert.assertEquals(2, (int) result.getMutationOccurrency());

    }

    @Test
    public void shouldReturnAnalysisResultWith1MutationOccurrency() {
        String[] dna = {
                "AAAT",
                "ATTA",
                "AAAT",
                "AATA"};

        AnalysisResult result = analyzer.analyze(dna);
        Assert.assertEquals(1, (int) result.getMutationOccurrency());

    }

    @Test
    public void shouldReturnAnalysisResultWith0MutationOccurrency() {
        String[] dna = {
                "AAAT",
                "TTTA"};

        AnalysisResult result = analyzer.analyze(dna);
        Assert.assertEquals(0, (int) result.getMutationOccurrency());

    }

    @Test
    public void shouldReturnAnalysisResultWith2MutationOccurrenciesWhenDnaContainsMultiplesMutations() {
        String[] dna = {
                "AAAT",
                "AAAA",
                "AAAT",
                "AAAA"};

        AnalysisResult result = analyzer.analyze(dna);
        Assert.assertEquals(2, (int) result.getMutationOccurrency());

    }

}