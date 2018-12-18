package com.magneto.dna.service;

import com.magneto.dna.analyzer.Analyzer;
import com.magneto.dna.domain.AnalysisResult;
import com.magneto.dna.domain.AnalysisStats;
import com.magneto.dna.domain.DNAReport;
import com.magneto.dna.repository.DNAReportRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.Arrays.stream;

@Service
public class AnalysisService {

    private List<Analyzer> analyzers;
    private DNAReportRepository dnaReportRepository;

    public AnalysisService(List<Analyzer> analyzers, DNAReportRepository dnaReportRepository) {
        this.analyzers = analyzers;
        this.dnaReportRepository = dnaReportRepository;
    }

    public boolean isMutant(String[] dna) {

        if (isInvalid(dna)) {
            throw new IllegalArgumentException("Invalid DNA sequence");
        }

        Optional<DNAReport> dnaReport = dnaReportRepository.findByDna(dna);
        if (dnaReport.isPresent()) {
            return dnaReport.get().isMutant();
        }

        int mutations = 0;
        for (Analyzer analyzer : analyzers) {
            AnalysisResult result = analyzer.analyze(dna);
            mutations += result.getMutationOccurrency();
            if (mutations > 1) {
                dnaReportRepository.save(new DNAReport(dna, true));
                return true;
            }
        }

        dnaReportRepository.save(new DNAReport(dna, false));
        return false;

    }

    public AnalysisStats getStats() {
        List<DNAReport> dnaReports = dnaReportRepository.findAll();
        Long mutantQuantity = dnaReports.stream().filter(DNAReport::isMutant).count();
        Integer humanQuantity = dnaReports.size();
        Double mutantProportion = mutantQuantity.doubleValue() / humanQuantity.doubleValue();
        return new AnalysisStats(humanQuantity.longValue(), mutantQuantity, mutantProportion);
    }

    private static boolean isInvalid(String[] dna) {
        return stream(dna).anyMatch(dnaSequence -> dnaSequence.length() < 4);
    }

}
