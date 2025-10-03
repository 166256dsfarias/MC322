package com.rpg.cenario;

import java.util.List;

/**
 * Representa a interface gerador de fases
 * Define o metodo que gera cada fase baseado na quantidade de fases e na dificuldade
 * @author Gabriel Casé da Costa, Daniel Farias
 * @version 
 * @since 2025-10-03
 */

public interface GeradorDeFases {
    List<Fase> gerar(int quantidadeDeFases, Dificuldade dificuldade);
}