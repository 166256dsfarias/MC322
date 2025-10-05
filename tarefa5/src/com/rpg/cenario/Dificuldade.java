package com.rpg.cenario;

/**
 * Representa a classe enum de dificuldade
 * Define as dificuldades existentes e atributos como multiplicador e descricao
 * para cada dificuldade
 * @author Gabriel Casé da Costa, Daniel Farias
 * @version 
 * @since 2025-10-03
 */

public enum Dificuldade {
    //definindo as dificuldades chamando o construtor
    FACIL(0.75, "Nessa dificuldade os monstros são mais fáceis"),
    NORMAL(1, "Dificuldade padrão"),
    DIFICIL(1.5, "Nessa dificuldade os monstros são mais difíceis, ideal para jogadores experientes");

    //definindo atributos
    private final double multiplicador;
    private final String descricao;

    /**
     * Construtor da classe enum de dificuldade
     * @param multiplicador      multiplicador de atributos da dificuldade
     * @param descricao      descricao da dificuldade
     */

    private Dificuldade(double multiplicador, String descricao) {
        this.multiplicador = multiplicador;
        this.descricao = descricao;
    }

    /**
     * Retorna o multiplicador da dificuldade
     * @return multiplicador da dificuldade
     */

    public double getMultiplicador() {
        return multiplicador;   //retorna o valor do multiplicador
    }
    /**
     * Retorna a descricao da dificuldade
     * @return descricao da dificuldade
     */

    public String getDescricao() {
        return descricao;  //retorna a descricao
    }

}
