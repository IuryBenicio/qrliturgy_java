package com.example.qrliturgy.Tables.Liturgia;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class LiturgiaScheduller {

    private final LiturgiaRepository liturgiaRepository;

    public LiturgiaScheduller(LiturgiaRepository liturgiaRepository) {
        this.liturgiaRepository = liturgiaRepository;
    }


    @Scheduled(cron = "0 0 0 * * *")
    public void LimpaHistoricoLiturgias(){
        LocalDateTime agora = LocalDateTime.now();

        liturgiaRepository.deleteByCriacaoBefore(agora.minusYears(3));

        System.out.println("Liturgias antigas limpas na data de " + agora);
    }
}
