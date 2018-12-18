package com.magneto.dna.domain;

import static com.google.common.base.Preconditions.checkNotNull;

public class AnalysisResult {

    private Integer mutationOccurrency;

    public AnalysisResult(Integer mutationOccurrency) {
        this.mutationOccurrency = checkNotNull(mutationOccurrency, "mutation occurrency must not be null");
    }


    public Integer getMutationOccurrency() {
        return mutationOccurrency;
    }
}
