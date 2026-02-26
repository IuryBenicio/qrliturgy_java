package com.example.qrliturgy.Tables.Liturgia;

public enum LiturgiaOrdemEnum {
    SAUDACAO_ORACAO("Saudação e Oração Inicial"),
    LOUVOR("Louvor"),
    ORACAO("Oração"),
    PALAVRA("Pregação"),
    AVISOS("Avisos"),
    ORACAO_FINAL("Oração Final");

    //apenas descreve o momento do culto para melhor compreensão do código
    private final String descricao;

    LiturgiaOrdemEnum(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
