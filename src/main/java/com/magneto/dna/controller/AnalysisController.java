package com.magneto.dna.controller;

import com.magneto.dna.domain.DNACollect;
import com.magneto.dna.service.AnalysisService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.FORBIDDEN;

@RestController
public class AnalysisController {

    private AnalysisService analysisService;

    public AnalysisController(AnalysisService analysisService) {
        this.analysisService = analysisService;
    }

    @PostMapping("/mutant")
    public ResponseEntity isMutant(@RequestBody DNACollect collect) {
        if (analysisService.isMutant(collect.getDna()))
            return ResponseEntity.ok().build();
        return ResponseEntity.status(FORBIDDEN).build();
    }

    @GetMapping("/stats")
    public ResponseEntity getStats() {
        return ResponseEntity.ok(analysisService.getStats());
    }
}
