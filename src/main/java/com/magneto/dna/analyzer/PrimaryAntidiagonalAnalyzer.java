package com.magneto.dna.analyzer;

import com.magneto.dna.domain.AnalysisResult;
import org.springframework.stereotype.Component;

@Component
public class PrimaryAntidiagonalAnalyzer implements Analyzer {

    @Override
    public AnalysisResult analyze(String[] dna) {
        int mutationOcurrency = 0;
        for (int i = dna.length - 1; i > -1; i--) {
            int matches = 0;
            if (dna.length - i >= 3) {
                break;
            }
            for (int j = i, k = 0; j > 0; j--, k++) {
                if (matches == 0 && dna.length - j >= 3) {
                    break;
                }
                if (dna[j].charAt(k) == dna[j - 1].charAt(k + 1)) {
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
