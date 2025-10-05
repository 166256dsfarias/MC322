package com.rpg.itens;
/**
 * Representa a classe varinha de azevinho
 * Implementa um tipo de arma
 * @author Gabriel Casé da Costa, Daniel Farias
 * @version 
 * @since 2025-10-03
 */

public class VarinhaDeAzevinho extends Arma {
    //sem atributos adicionais

    /**
     * Construtor da classe varinha de azevinho
     * @param nome      nome da varinha de azevinho
     * @param dano      dano da varinha de azevinho
     * @param minNivel  nivel minimo para usar a varinha de azevinho
     */

    public VarinhaDeAzevinho(){
        super("VarinhaDeAzevinho", 30, 1);
    }
}
