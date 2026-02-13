package com.example.qrliturgy.Tables.Louvor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LouvorRepository extends JpaRepository<LouvorEntity,Long> {
}
