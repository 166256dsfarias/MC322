package com.rpg.exceptions;

/**
 * Representa a classe de exceção de nível insuficiente
 * Implementa uma mensagem de erro quando não há nível suficiente para equipar a arma
 * @author Gabriel Casé da Costa, Daniel Farias
 * @version 
 * @since 2025-10-03
 */

public class NivelInsuficienteException extends Exception{

    /**
     * Construtor da classe de exceção de nível insuficiente
     * @param mensagem  mensagem de erro
     */
    public NivelInsuficienteException(String mensagem){
        super(mensagem);
    }

}
