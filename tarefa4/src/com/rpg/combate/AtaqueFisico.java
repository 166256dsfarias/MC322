package com.rpg.combate;

/**
 * Representa a classe ataque fisico que implementa a interface ação de combate
 * Implementa e define os metodos da interface
 * @author Gabriel Casé da Costa, Daniel Farias
 * @version 
 * @since 2025-10-03
 */

public class AtaqueFisico implements AcaoDeCombate {
    private String descricao;
    private int dano;
    /**
     * Construtor da classe ataque fisico
     * @param descricao      descricao do ataque fisico
     * @param dano      dano do ataque fisico
     */
    public AtaqueFisico(String descricao, int dano) {
        this.descricao = descricao;
        this.dano = dano;
    }

    @Override
    public void executar(Combatente usuario, Combatente alvo) {
        System.out.println(usuario.getNome() + " usa " + descricao + " em " + alvo.getNome());
        alvo.receberDano(dano);
    }

    @Override
    public String getDescricao() {
        return descricao;
    }
}
