package com.example.qrliturgy;

import com.example.qrliturgy.Tables.Admin.exceptions.AdminExists;
import com.example.qrliturgy.Tables.Admin.exceptions.AdminNotFounded;
import com.example.qrliturgy.Tables.Admin.exceptions.SenhaIncorreta;
import com.example.qrliturgy.Tables.Liturgia.exceptions.LiturgiaNotFounded;
import com.example.qrliturgy.Tables.Louvor.exceptions.LouvorNotCreated;
import com.example.qrliturgy.Tables.Louvor.exceptions.LouvorNotFounded;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AdminNotFounded.class)
    public ResponseEntity<String> AdminNotFounded(AdminNotFounded ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(SenhaIncorreta.class)
    public ResponseEntity<String> SenhaIncorreta(SenhaIncorreta ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @ExceptionHandler(AdminExists.class)
    public ResponseEntity<String> AdminExists(AdminExists ex){
        return ResponseEntity.status(HttpStatus.FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(LiturgiaNotFounded.class)
    public ResponseEntity<String> LiturgiaNotFounded(LiturgiaNotFounded ex){
        return ResponseEntity.status(HttpStatus.FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(LouvorNotCreated.class)
    public ResponseEntity<String> LouvorNotCreated(LouvorNotCreated ex){
        return ResponseEntity.status(HttpStatus.FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(LouvorNotFounded.class)
    public ResponseEntity<String> LouvorNotFounded(LouvorNotFounded ex) {
        return ResponseEntity.status(HttpStatus.FOUND).body(ex.getMessage());
    }
}
