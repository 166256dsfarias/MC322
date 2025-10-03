package com.rpg.combate;

/**
 * Representa a classe expelliarmus que implementa uma ação de combate
 * Implementa os métodos da interface para essa classe
 * @author Gabriel Casé da Costa, Daniel Farias
 * @version 
 * @since 2025-10-03
 */

public class Expelliarmus implements AcaoDeCombate {
    private int dano;
    /**
     * Construtor da classe expelliarmus
     * @param dano      dano do expelliarmus
     */
    public Expelliarmus(int dano) {
        this.dano = dano;
    }

    @Override
    public void executar(Combatente usuario, Combatente alvo) {
        System.out.println(usuario.getNome() + " lança Expelliarmus contra " + alvo.getNome() + "!");
        alvo.receberDano(dano); // ← DEVE causar dano
        System.out.println(alvo.getNome() + " recebeu " + dano + " de dano!");
    }

    @Override
    public String getDescricao() {
        return "Expelliarmus (Dano: " + dano + ")";
    }
}