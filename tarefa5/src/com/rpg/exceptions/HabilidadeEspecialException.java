package com.rpg.exceptions;

/**
 * Representa a classe de exceção de habilidade especial
 * Implementa uma mensagem de erro quando não há magia sufuciente para usar a habilidade
 * @author Gabriel Casé da Costa, Daniel Farias
 * @version 
 * @since 2025-10-03
 */

public class HabilidadeEspecialException extends Exception {
    /**
     * Construtor da classe de exceção de habilidade especial
     * @param mensagem  mensagem de erro
     */
    public HabilidadeEspecialException(String mensagem) {
        super(mensagem);
    }
}
