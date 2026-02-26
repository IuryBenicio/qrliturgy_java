package com.example.qrliturgy.Tables.Liturgia;

import com.example.qrliturgy.Tables.Avisos.Entity.AvisoEntity;
import com.example.qrliturgy.Tables.Louvor.LouvorEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "liturgia")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LiturgiaEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "Culto")
    @NotBlank(message = "Nome do culto precisa ser identificado")
    private String culto;

    @Column(name = "Tema",columnDefinition = "TEXT")
    @NotBlank(message = "tema do culto é obrigatório")
    private String tema;

    @Column(name = "passagem_biblica", columnDefinition = "TEXT")
    @NotBlank(message = "passagem bíblica é obrigatória")
    private String passagemBiblica;

    @Column(name = "pregador")
    private String pregador;

    @Column(name="ceia")
    @NotNull(message = "campo ceia é obrigatório")
    private boolean ceia;

    @Column(name = "observacações", columnDefinition = "TEXT")
    private String observacao;

    @ElementCollection
    @Enumerated(EnumType.STRING)
    @OrderColumn(name = "posicao_cronograma")
    private List<LiturgiaOrdemEnum> ordemLiturgica;

    @ManyToMany
    @JoinTable(name = "liturgia_louvor")
    @OrderColumn(name = "posicao_musica")
    private List<LouvorEntity> louvores;

    @OneToMany(mappedBy = "liturgia", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AvisoEntity> avisos;

    @CreationTimestamp
    @Column(name = "data_criacao", nullable = false, updatable = false)
    private LocalDateTime criacao;
}
