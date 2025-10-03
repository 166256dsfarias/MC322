package com.rpg.itens;
/**
 * Representa a classe abstrata de arma
 * Define os atributos e métodos que uma arma possui 
 * @author Gabriel Casé da Costa, Daniel Farias
 * @version 
 * @since 2025-10-03
 */
public abstract class Arma implements Item {
    protected int dano;
    protected int minNivel;
    protected String nome;
    
    /**
     * Construtor da classe arma
     * @param nome      nome da arma
     * @param dano      dano da arma
     * @param minNivel  nivel minimo para usar a arma
     */
    public Arma(String nome, int dano, int minNivel){
        this.nome = nome;
        this.dano = dano;
        this.minNivel = minNivel;
    }

    @Override
    public String getNome() {
        return nome;
    }
    public int getDano() {
        return dano;
    }
    public int getMinNivel() {
        return minNivel;
    }

}