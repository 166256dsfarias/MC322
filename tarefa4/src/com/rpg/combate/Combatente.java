package com.rpg.combate;

/**
 * Representa a interface de combatentes
 * Define os métodos que um combatente possui 
 * @author Gabriel Casé da Costa, Daniel Farias
 * @version 
 * @since 2025-10-03
 */

public interface Combatente {
    String getNome(); 
    boolean estaVivo();            
    void receberDano(double dano);
    void receberCura(int cura);
    AcaoDeCombate escolherAcao(Combatente alvo);
}
