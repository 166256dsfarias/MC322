package com.rpg.personagens;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.rpg.combate.AcaoDeCombate;
import com.rpg.combate.Combatente;
import com.rpg.itens.Arma;
import com.rpg.itens.Item;

/**
 * Representa a classe abstrata de monstros
 * Define os atributos e métodos que um monstro possui
 * 
 * @author Gabriel Casé da Costa, Daniel Farias
 * @version
 * @since 2025-10-03
 */

public abstract class Monstro extends Personagem implements Lootavel {
    protected int xpConcedido;
    protected List<Item> listaDeItensParaLargar;
    protected List<AcaoDeCombate> acoes;

    /**
     * Construtor da classe monstro
     * 
     * @param nome                   nome do monstro
     * @param pontosDeVida           vida inicial do monstro
     * @param forca                  força inicial do monstro
     * @param arma                   arma inicial do monstro
     * @param xpConcedido            experiencia concedida pelo monstro
     * @param listaDeItensParaLargar lista de itens para largar
     */

    public Monstro(String nome, double pontosDeVida, double forca, Arma arma, int xpConcedido,
            List<Item> listaDeItensParaLargar) {
        super(nome, pontosDeVida, forca, arma);
        this.xpConcedido = xpConcedido;
        this.listaDeItensParaLargar = listaDeItensParaLargar;
        this.acoes = new ArrayList<>();
    }

    // sobrescreve exibirStatus para mostrar também xp concedido
    @Override
    public void exibirStatus() {
        super.exibirStatus();
        System.out.println("Experiência concedida: " + this.xpConcedido);
    }

    // Implementação de Lootavel
    @Override
    public Item droparLoot() {
        if (listaDeItensParaLargar == null || listaDeItensParaLargar.isEmpty()) {
            return null;
        }
        Random random = new Random();
        int indice = random.nextInt(listaDeItensParaLargar.size());
        return listaDeItensParaLargar.remove(indice); // Arma agora é um Item
    }

    // IA do monstro
    @Override
    public AcaoDeCombate escolherAcao(Combatente alvo) {
        if (acoes.isEmpty()) {
            System.out.println(nome + " não possui ações disponíveis!");
            return null;
        }
        Random rand = new Random();
        AcaoDeCombate escolhida = acoes.get(rand.nextInt(acoes.size()));
        System.out.println(nome + " escolheu a ação: " + escolhida.getDescricao());
        return escolhida;
    }

    /**
     * Retorna a experiência concedida pelo monstro.
     * 
     * @return A quantidade de experiência.
     */
    public int getXpConcedido() {
        return xpConcedido;
    }
}
