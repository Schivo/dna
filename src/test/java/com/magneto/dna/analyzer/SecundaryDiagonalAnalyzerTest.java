package com.magneto.dna.analyzer;

import com.magneto.dna.domain.AnalysisResult;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SecundaryDiagonalAnalyzerTest {

    private SecundaryDiagonalAnalyzer analyzer;

    @Before
    public void setup() {
        analyzer = new SecundaryDiagonalAnalyzer();
    }

    @Test
    public void shouldReturnAnalysisResultWith2MutationOccurrencies() {
        String[] dna = {
                "ATTTTT",
                "AATTTT",
                "TAATTT",
                "TTAATT",
                "TTTAAT"};

        AnalysisResult result = analyzer.analyze(dna);
        Assert.assertEquals(2, (int) result.getMutationOccurrency());

    }

    @Test
    public void shouldReturnAnalysisResultWith1MutationOccurrency() {
        String[] dna = {
                "ATTTT",
                "TATTT",
                "TAATT",
                "TTAAT",
                "TTTAA"};

        AnalysisResult result = analyzer.analyze(dna);
        Assert.assertEquals(1, (int) result.getMutationOccurrency());

    }

    @Test
    public void shouldReturnAnalysisResultWith0MutationOccurrency() {
        String[] dna = {
                "TTTTT",
                "TATTT",
                "TATAT",
                "TTAAT",
                "TTTAA"};

        AnalysisResult result = analyzer.analyze(dna);
        Assert.assertEquals(0, (int) result.getMutationOccurrency());

    }

    @Test
    public void shouldReturnAnalysisResultWith2MutationOccurrenciesWhenDnaContainsMultiplesMutations() {
        String[] dna = {
                "ATTTTTT",
                "AATTTTT",
                "TAATTTT",
                "TTAATTT",
                "TTTAATT",
                "TTTTATT"};

        AnalysisResult result = analyzer.analyze(dna);
        Assert.assertEquals(2, (int) result.getMutationOccurrency());

    }

}