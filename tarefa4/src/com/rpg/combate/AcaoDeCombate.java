package com.rpg.combate;

/**
 * Representa a interface ação de combate
 * Define os métodos de ações de combate
 * @author Gabriel Casé da Costa, Daniel Farias
 * @version 
 * @since 2025-10-03
 */

public interface AcaoDeCombate {
    void executar(Combatente atacante, Combatente alvo);
    String getDescricao();
}