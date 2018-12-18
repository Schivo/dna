package com.magneto.dna.analyzer;

import com.magneto.dna.domain.AnalysisResult;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PrimaryDiagonalAnalyzerTest {


    private PrimaryDiagonalAnalyzer analyzer;

    @Before
    public void setup() {
        analyzer = new PrimaryDiagonalAnalyzer();
    }

    @Test
    public void shouldReturnAnalysisResultWith2MutationOccurrencies() {
        String[] dna = {
                "ATTTT",
                "AATTT",
                "TAATT",
                "TTAAT",
                "TTTAA"};

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
                "TATTT",
                "TTAAT",
                "TTTAA"};

        AnalysisResult result = analyzer.analyze(dna);
        Assert.assertEquals(0, (int) result.getMutationOccurrency());

    }

    @Test
    public void shouldReturnAnalysisResultWith2MutationOccurrenciesWhenDnaContainsMultiplesMutations() {
        String[] dna = {
                "ATTTT",
                "AATTT",
                "TAATT",
                "TTAAT",
                "TTTAA",
                "TTTTA"};

        AnalysisResult result = analyzer.analyze(dna);
        Assert.assertEquals(2, (int) result.getMutationOccurrency());

    }

}