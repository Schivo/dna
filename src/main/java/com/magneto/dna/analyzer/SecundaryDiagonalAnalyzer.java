package com.magneto.dna.analyzer;

import com.magneto.dna.domain.AnalysisResult;
import org.springframework.stereotype.Component;

@Component
public class SecundaryDiagonalAnalyzer implements Analyzer {

    @Override
    public AnalysisResult analyze(String[] dna) {
        int mutationOcurrency = 0;
        for (int j = 1; j < dna[0].length(); j++) {
            int matches = 0;
            if (dna[0].length() - j < 4) {
                break;
            }
            for (int i = 0, k = j; i < dna[j].length() - 1; i++, k++) {
                if (matches == 0 && dna[j].length() - i < 4) {
                    break;
                }
                if (dna[i].charAt(k) == dna[i + 1].charAt(k + 1)) {
                    matches++;
                    if (matches == 3) {
                        mutationOcurrency++;
                        matches = 0;
                        i += 1;
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
