package com.example.qrliturgy.Tables.Avisos.Entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvisosRepository extends JpaRepository<AvisoEntity, Long> {
}
