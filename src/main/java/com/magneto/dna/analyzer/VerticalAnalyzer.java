package com.magneto.dna.analyzer;

import com.magneto.dna.domain.AnalysisResult;
import org.springframework.stereotype.Component;

@Component
public class VerticalAnalyzer implements Analyzer {

    @Override
    public AnalysisResult analyze(String[] dna) {
        int mutationOcurrency = 0;
        for (int i = 0; i < dna[0].length(); i++) {
            int matches = 0;
            for (int j = 0; j < dna.length - 1; j++) {
                if (matches == 0 && dna.length - j < 4) {
                    break;
                }
                if (dna[j].charAt(i) == dna[j + 1].charAt(i)) {
                    matches++;
                    if (matches == 3) {
                        mutationOcurrency++;
                        matches = 0;
                        j += 1;
                    }
                    if (mutationOcurrency == 2) {
                        return new AnalysisResult(mutationOcurrency);
                    }
                    continue;
                }
                matches = 0;
            }

        }
        return new AnalysisResult(mutationOcurrency);
    }
}
