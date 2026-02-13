package com.example.qrliturgy.Tables.Admin;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<AdminEntity, Long> {

    Optional<AdminEntity> findByEmail(String email);
    Optional<AdminEntity> findByNome(String nome);

}
