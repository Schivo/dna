package com.magneto.dna.domain;


import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DNAReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonProperty("Dna")
    private String[] dna;

    private boolean isMutant;

    public DNAReport(String[] dna, boolean isMutant) {
        this.dna = dna;
        this.isMutant = isMutant;
    }

    public DNAReport() {
    }

    public Integer getId() {
        return id;
    }

    public String[] getDna() {
        return dna;
    }

    public boolean isMutant() {
        return isMutant;
    }
}