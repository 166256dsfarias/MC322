package com.rpg.personagens;
import java.util.Arrays;

import com.rpg.combate.Combatente;
import com.rpg.combate.Expelliarmus;
import com.rpg.itens.Arma;

/**
 * Representa a classe abstrata de professor
 * Define os atributos e métodos que um professor possui 
 * @author Gabriel Casé da Costa, Daniel Farias
 * @version 
 * @since 2025-10-03
 */

public class Professor extends Heroi {
    private int tempoDeMagisterio;

    /**
     * Construtor da classe professor
     * @param nome      nome do professor
     * @param pontosDeVida      vida inicial do professor
     * @param forca     força inicial do professor
     * @param nivel     nivel inicial do professor
     * @param sorte     sorte inicial do professor
     * @param experiencia       experiencia do professor
     * @param tempoDeMagisterio     tempo de magisterio do professor
     * @param arma      arma inicial do professor
     * @param magia     pontos de magia inicial do professor
     */
    public Professor(String nome, double pontosDeVida, double forca, int nivel, double sorte, int experiencia, int tempoDeMagisterio, Arma arma, int magia) {
        super(nome, pontosDeVida, forca, nivel, sorte, experiencia, arma, magia);
        this.tempoDeMagisterio = tempoDeMagisterio;

        /**
         * define as acoes do professor
         */
        this.acoes.addAll(Arrays.asList(
            new Expelliarmus(10)
        ));
    }

    @Override
    public void usarHabilidadeEspecial(Combatente alvo) {
        System.out.println(this.nome + " conjura um feitiço avançado contra " + alvo.getNome() + "!");
        double dano = (this.forca + tempoDeMagisterio) * this.nivel;
        alvo.receberDano(dano);
        System.out.println(alvo.getNome() + " recebeu " + dano + " de dano!");
    }
}
