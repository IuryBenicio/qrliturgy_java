package com.example.qrliturgy.Tables.Liturgia;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface LiturgiaRepository extends JpaRepository<LiturgiaEntity, Long> {

    //retorna a ultima liturgia por ordem decrecente
    Optional<LiturgiaEntity> findFirstByOrderByIdDesc();

    @Transactional
    @Modifying
    void deleteByCriacaoBefore(LocalDateTime tempo);

}
