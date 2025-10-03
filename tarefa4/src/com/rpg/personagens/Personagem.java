package com.rpg.personagens;
import com.rpg.combate.AcaoDeCombate;
import com.rpg.combate.Combatente;
import com.rpg.itens.Arma;

/**
 * Representa a classe abstrata de personagens
 * Define os atributos e métodos que um personagem possui 
 * @author Gabriel Casé da Costa, Daniel Farias
 * @version 
 * @since 2025-10-03
 */

public abstract class Personagem implements Combatente {
    protected String nome;
    protected double pontosDeVida;
    protected double forca;
    protected Arma arma;

    /**
     * Construtor da classe personagem
     * @param nome      nome do personagem
     * @param pontosDeVida      vida inicial do personagem
     * @param forca     força inicial do personagem
     * @param arma      arma inicial do personagem
     */
    public Personagem(String nome, double pontosDeVida, double forca, Arma arma) {
        this.nome = nome;
        this.pontosDeVida = pontosDeVida;
        this.forca = forca;
        this.arma = arma;
    }

    // Métodos da interface Combatente
    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public boolean estaVivo() {
        return pontosDeVida > 0;
    }

    @Override
    public void receberDano(double dano) {
        this.pontosDeVida -= dano;
        if (this.pontosDeVida < 0) this.pontosDeVida = 0;
    }

    @Override
    public void receberCura(int cura) {
        this.pontosDeVida += cura;
    }

    // Status
    public void exibirStatus() {
        System.out.println(nome + " | Vida: " + pontosDeVida + " | Força: " + forca);
        if (arma != null) {
            System.out.println("Arma equipada: " + arma.getNome());
        }
    }

    // Agora o contrato é via Combatente
    @Override
    public abstract AcaoDeCombate escolherAcao(Combatente alvo);
}
