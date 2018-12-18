package com.magneto.dna.analyzer;


import com.magneto.dna.domain.AnalysisResult;

public interface Analyzer {

    AnalysisResult analyze(String[] dna);

}
