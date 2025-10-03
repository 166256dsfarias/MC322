package com.rpg.cenario;

import com.rpg.personagens.Monstro;
import com.rpg.personagens.Heroi;
import java.util.List;

/**
 * Representa a classe de Fase de Combate
 * Define os métodos que cada fase vai possuir e apresentar
 * @author Gabriel Casé da Costa, Daniel Farias
 * @version 
 * @since 2025-10-03
 */

public class FaseDeCombate implements Fase {
    private TipoCenario tipo;
    private List<Monstro> monstros;
    /**
     * Construtor da classe de fase de combate
     * @param tipo tipo de cenario da fase
     * @param monstros lista de monstros da fase
     */
     
    public FaseDeCombate(TipoCenario tipo, List<Monstro> monstros) {
        this.tipo = tipo;
        this.monstros = monstros;
    }

    @Override
    public void iniciar(Heroi heroi) {
        System.out.println("Entrando na fase: " + tipo.getDescricao());
        tipo.aplicarEfeitos(heroi);
    }

    @Override
    public boolean isConcluida() {
        return monstros.stream().allMatch(m -> !m.estaVivo());
    }

    @Override
    public TipoCenario getTipoDeCenario() {
        return tipo;
    }

    @Override
    public List<Monstro> getMonstros() {
        return monstros;
    }
}
