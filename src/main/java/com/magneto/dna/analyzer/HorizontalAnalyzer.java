package com.magneto.dna.analyzer;


import com.magneto.dna.domain.AnalysisResult;
import org.springframework.stereotype.Component;

@Component
public class HorizontalAnalyzer implements Analyzer
{
    @Override
    public AnalysisResult analyze(String[] dna) {
        int mutationOccurrency = 0;
        for(int i =0; i < dna.length; i++){
            int matches = 0;
            for (int j = 0; j < dna[i].length() - 1; j++) {
                if (matches == 0 && dna[i].length() - j < 4) {
                    break;
                }
                if (dna[i].charAt(j) == dna[i].charAt(j + 1)) {
                    matches++;
                    if (matches == 3) {
                        mutationOccurrency++;
                        matches = 0;
                        j += 1;
                    }
                    if (mutationOccurrency == 2) {
                        return new AnalysisResult(mutationOccurrency);
                    }
                    continue;
                }
                matches = 0;
            }
        }
        return new AnalysisResult(mutationOccurrency);
    }
}
