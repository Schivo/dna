package com.magneto.dna.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AnalysisStats {

    @JsonProperty("count_human_dna")
    private Long humanQuantity;

    @JsonProperty("count_mutant_dna")
    private Long mutantQuantity;

    @JsonProperty("ratio")
    private Double mutantProportion;

    public AnalysisStats(Long humanQuantity, Long mutantQuantity, Double mutantProportion) {
        this.humanQuantity = humanQuantity;
        this.mutantQuantity = mutantQuantity;
        this.mutantProportion = mutantProportion;
    }

    public Long getHumanQuantity() {
        return humanQuantity;
    }

    public Long getMutantQuantity() {
        return mutantQuantity;
    }

    public Double getMutantProportion() {
        return mutantProportion;
    }
}
