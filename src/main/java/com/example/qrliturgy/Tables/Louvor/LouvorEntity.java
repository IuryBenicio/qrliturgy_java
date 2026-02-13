package com.example.qrliturgy.Tables.Louvor;

import com.example.qrliturgy.Tables.Liturgia.LiturgiaEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@Data
@Table(name = "louvor")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LouvorEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nome_musica")
    @NotBlank(message = "Nome da música é obrigatório")
    private String nome;


    @Column(name = "letra_musica", columnDefinition = "TEXT")
    private String letra;


    @ManyToMany(mappedBy = "louvores")
    private List<LiturgiaEntity> liturgia;

}