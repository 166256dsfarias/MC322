package com.rpg.cenario;
import com.rpg.personagens.Heroi;

/**
 * Representa a interface de evento
 * Define os métodos que um evento possui 
 * @author Gabriel Casé da Costa, Daniel Farias
 * @version 
 * @since 2025-10-03
 */

public interface Evento {
    boolean verificarGatilho(Heroi heroi); 
    void executar(Heroi heroi);
}