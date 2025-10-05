package com.rpg.personagens;

import java.util.Arrays;

import com.rpg.combate.Combatente;
import com.rpg.combate.ExpectoPatronum;
import com.rpg.exceptions.HabilidadeEspecialException;
import com.rpg.itens.Arma;

/**
 * Representa a classe de alunos
 * Define os atributos e métodos que um aluno possui 
 * @author Gabriel Casé da Costa, Daniel Farias
 * @version 
 * @since 2025-10-03
 */

public class Aluno extends Heroi {
    private String casa;
    /**
    * Construtor da classe aluno
    * @param nome      nome do aluno
    * @param pontosDeVida      vida inicial do aluno
    * @param forca     força inicial do aluno
    * @param nivel     nivel inicial do aluno
    * @param sorte     sorte inicial do aluno
    * @param experiencia       experiencia do aluno
    * @param arma      arma inicial do aluno
    * @param casa      casa do aluno
    * @param magia     pontos de magia inicial do aluno
    */
    
    public Aluno(String nome, int pontosDeVida, int forca, int nivel, double sorte, int experiencia, Arma arma, String casa, int magia) {
        super(nome, pontosDeVida, forca, nivel, sorte, experiencia, arma, magia);
        this.casa = casa;

        // AUMENTE A CURA/DANO
        this.acoes.addAll(Arrays.asList(
            new ExpectoPatronum(40)
        ));
    }

    @Override
    public void usarHabilidadeEspecial(Combatente alvo) throws HabilidadeEspecialException{
        final int CUSTO_MAGIA = 40;
        if(this.magia < CUSTO_MAGIA){
            String mensagem = "ERRO: MAGIA INSUFICIENTE PARA USAR HABILIDADE ESPACIAL!";
            throw new HabilidadeEspecialException(mensagem);
        }
        this.magia -= CUSTO_MAGIA;
        System.out.println(this.nome + " da casa " + this.casa + " usa Protego Maxima!");
        this.receberCura(30);
    }


}