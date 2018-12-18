# dna-analysis

- Endpoint para verificar se o humano é um mutante
 - Post para https://mutant-dna-analysis.herokuapp.com/mutant
 - Body:  { "dna" : ["AAAA", "AAAA","AAAA","AAAA"] }
 - Resposta: 200 se for mutante, 403 se for humano

- Endpoint para verificar estatísticas
 - Get para https://mutant-dna-analysis.herokuapp.com/stats
 - Reposta: {
                "count_human_dna": 2,
                "count_mutant_dna": 1,
                "ratio" : 0.5
            }

