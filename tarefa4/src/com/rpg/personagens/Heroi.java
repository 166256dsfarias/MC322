package com.rpg.personagens;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import com.rpg.exceptions.NivelInsuficienteException;
import com.rpg.exceptions.HabilidadeEspecialException;
import com.rpg.combate.AcaoDeCombate;
import com.rpg.combate.Combatente;
import com.rpg.itens.Arma;

/**
 * Representa a classe abstrata de herois
 * Define os atributos e métodos que um herói possui 
 * @author Gabriel Casé da Costa, Daniel Farias
 * @version 
 * @since 2025-10-03
 */

public abstract class Heroi extends Personagem {
    protected int nivel;
    protected int experiencia;
    protected int expProximoNivel;
    protected double sorte;
    protected List<AcaoDeCombate> acoes;
    protected int magia;

    /**
     * Construtor da classe heroi
     * @param nome      O nome do heroi
     * @param pontosDeVida      A quantidade de vida do herói
     * @param forca     A força do heroi
     * @param nivel     O nível do herói
     * @param sorte     A sorte do heroi
     * @param experiencia       Experiencia do herói
     * @param arma      Arma inicial do herói
     * @param magia         Quantidade de magia do herói, usada para habilidade especial
     */
    public Heroi(String nome, double pontosDeVida, double forca, int nivel, double sorte, int experiencia, Arma arma, int magia) {
        super(nome, pontosDeVida, forca, arma);
        this.nivel = nivel;
        this.experiencia = experiencia;
        this.sorte = sorte;
        this.expProximoNivel = 100; // valor inicial
        this.acoes = new ArrayList<>();
        this.magia = magia;
    }
    /**
     * Função de ganhar experiência
     * 
     * @param pontos   Experiencia adquirida
     */
    public void ganharExperiencia(int pontos) {
        this.experiencia += pontos;

        while (this.experiencia >= this.expProximoNivel) {
            this.experiencia -= this.expProximoNivel;
            subirDeNivel();
        }
    }


    @Override
    public void exibirStatus() {
        super.exibirStatus();
        System.out.println("Nível: " + this.nivel);
        System.out.println("Experiência: " + this.experiencia + "/" + this.expProximoNivel);
    }

    /**
     * Método abstrato para o herói usar habilidade especial
     * 
     * @param alvo
     * @throws HabilidadeEspecialException
     */
    public abstract void usarHabilidadeEspecial(Combatente alvo) throws HabilidadeEspecialException;

    /**
     * Método para equipar uma nova arma
     * 
     * @param novaArma
     * @throws NivelInsuficienteException
     */
    public void equiparArma(Arma novaArma) throws NivelInsuficienteException {
        if(this.getNivel() < novaArma.getMinNivel()){
            String mensagem = "Nível insuficiente! Você precisa ser nível " + novaArma.getMinNivel() + " para usar a arma " + novaArma.getNome() + ".";
            throw new NivelInsuficienteException(mensagem);
        }
        this.arma = novaArma;
        System.out.println("Nova arma equipada: " + novaArma.getClass().getSimpleName());
    }
    /**
    * Método privado para subir de nível
    */
    private void subirDeNivel() {
            this.nivel++;
            this.expProximoNivel = 100 + 25 * (this.nivel * this.nivel); // atualiza limite para próximo nível
            this.pontosDeVida += 20; // aumenta vida
            this.forca += 5;         // aumenta força
            System.out.println(this.nome + " subiu para o nível " + this.nivel + "!");
            System.out.println("Pontos de vida aumentados para: " + this.pontosDeVida);
            System.out.println("Força aumentada para: " + this.forca);
    }

    @Override
    public AcaoDeCombate escolherAcao(Combatente alvo) {
        if (acoes.isEmpty()) {
            System.out.println(nome + " não tem nenhuma ação definida!");
            return null;
        }
        Random rand = new Random();
        AcaoDeCombate escolhida = acoes.get(rand.nextInt(acoes.size()));
        System.out.println(nome + " escolheu a ação: " + escolhida.getDescricao());
        return escolhida;
    }
    /**
     * Retornar o nível do herói
     * @return nivel do herói
     */
    public int getNivel(){
        return nivel;
    }

    /**
     * Retornar a experiencia do herói
     * @return experiencia do herói
     */
    public int getExperiencia(){
        return experiencia;
    }
    /**
     * Retornar a experiencia do proximo nivel
     * @return nivel do herói
     */
    public int getExpProximoNivel(){
        return expProximoNivel;
    }
    /**
     * Retornar a sorte do herói
     * @return sorte do herói
     */
    public double getSorte(){
        return sorte;
    }

    /**
     * Método para receber magia
     * @param pontosDeMagia   magia recebida
      */
        public void receberMagia(int pontosDeMagia){
        this.magia += pontosDeMagia;
        if(this.magia > 100){
            this.magia = 100;
        }
    }
}
