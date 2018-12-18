package com.magneto.dna.analyzer;

import com.magneto.dna.domain.AnalysisResult;
import org.springframework.stereotype.Component;

@Component
public class SecundaryAntidiagonalAnalyzer implements Analyzer {

    @Override
    public AnalysisResult analyze(String[] dna) {
        int mutationOcurrency = 0;
        for (int i = dna[0].length() - 1; i > 0; i--) {
            int matches = 0;
            if (dna[0].length() - (dna[0].length() - i) < 4) {
                break;
            }
            for (int j = dna.length - 1, k = dna[0].length() - (i + 1) + 1; j > 0; j--, k++) {
                if (matches == 0 && dna[0].length() - k < 4) {
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
