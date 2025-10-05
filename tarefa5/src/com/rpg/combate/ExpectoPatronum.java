package com.rpg.combate;

/**
 * Representa a classe expecto patronum que implementa uma ação de combate
 * Implementa os métodos da interface para essa classe
 * @author Gabriel Casé da Costa, Daniel Farias
 * @version 
 * @since 2025-10-03
 */

public class ExpectoPatronum implements AcaoDeCombate {
    private int dano;
    /**
     * Construtor da classe expecto patronum
     * @param dano      dano do expecto patronum
     */
    public ExpectoPatronum(int dano) {
        this.dano = dano;
    }

    @Override
    public void executar(Combatente usuario, Combatente alvo) {
        System.out.println(usuario.getNome() + " conjura um Patrono brilhante com EXPECTO PATRONUM!");
        alvo.receberDano(dano);
        System.out.println("O Patrono causa " + dano + " de dano em " + alvo.getNome() + "!");
    }

    @Override
    public String getDescricao() {
        return "Expecto Patronum (Dano: " + dano + ")";
    }
}