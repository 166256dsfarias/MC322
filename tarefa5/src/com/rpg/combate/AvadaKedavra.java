package com.rpg.combate;

/**
 * Representa a classe Avada Kedavra que implementa uma ação de combate
 * Implementa os métodos da interface para essa classe
 * @author Gabriel Casé da Costa, Daniel Farias
 * @version 
 * @since 2025-10-03
 */

public class AvadaKedavra implements AcaoDeCombate {
    private double poder;
    /**
     * Construtor da classe Avada Kedavra
     * @param poder      poder do Avada Kedavra
     */
    public AvadaKedavra(double poder) {
        this.poder = poder;
    }

    @Override
    public void executar(Combatente usuario, Combatente alvo) {
        System.out.println(usuario.getNome() + " grita: AVADA KEDAVRA!");
        alvo.receberDano(poder);
    }

    @Override
    public String getDescricao() {
        return "Avada Kedavra";
    }
}
