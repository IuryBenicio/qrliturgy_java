package com.example.qrliturgy.Tables.Avisos.Entity;

import com.example.qrliturgy.Tables.Liturgia.LiturgiaEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "aviso")
@AllArgsConstructor
@NoArgsConstructor
public class AvisoEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "aviso_titulo")
    @NotBlank(message = "Título do aviso é obrigatório")
    private String titulo;

    @Column(name = "aviso_descricao",columnDefinition = "TEXT")
    @NotBlank(message = "Descrição do aviso é obrigatório")
    private String descricao;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "liturgia_id", nullable = false)
    private LiturgiaEntity liturgia;

}
