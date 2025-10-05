package com.rpg.itens;

/**
 * Representa a classe varinha de sabugueiro
 * Implementa um tipo de arma
 * @author Gabriel Casé da Costa, Daniel Farias
 * @version 
 * @since 2025-10-03
 */

public class VarinhaDeSabugueiro extends Arma {
    //sem atributos adicionais

    /**
     * Construtor da classe varinha de sabugueiro
     * @param nome      nome da varinha de sabugueiro
     * @param dano      dano da varinha de sabugueiro
     * @param minNivel  nivel minimo para usar a varinha de sabugueiro
     */
     
    public VarinhaDeSabugueiro(){
        super("Varinha de Sabugueiro", 25, 1); 
    }
}