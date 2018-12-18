package com.magneto.dna.domain;

import javax.validation.constraints.NotNull;

public class DNACollect {

    @NotNull(message = "dna must not be null")
    private String[] dna;

    public DNACollect() {
    }

    public String[] getDna() {
        return dna;
    }
}
