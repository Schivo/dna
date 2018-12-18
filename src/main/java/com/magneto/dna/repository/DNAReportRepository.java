package com.magneto.dna.repository;

import com.magneto.dna.domain.DNAReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DNAReportRepository extends JpaRepository<DNAReport, Integer> {

    Optional<DNAReport> findByDna(String[] dna);
}