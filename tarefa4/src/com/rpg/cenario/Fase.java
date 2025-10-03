package com.rpg.cenario;
import com.rpg.personagens.Heroi;
import com.rpg.personagens.Monstro;
import java.util.List;

/**
 * Representa a interface de fase
 * Define os métodos que uma fase possui 
 * @author Gabriel Casé da Costa, Daniel Farias
 * @version 
 * @since 2025-10-03
 */

public interface Fase {
    void iniciar(Heroi heroi);
    boolean isConcluida();
    TipoCenario getTipoDeCenario();

    List<Monstro> getMonstros();
}
