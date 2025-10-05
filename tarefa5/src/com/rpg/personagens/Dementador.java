package com.rpg.personagens;

import java.util.Arrays;

import com.rpg.itens.Item;
import com.rpg.itens.PocaoDeChocolate;
import com.rpg.itens.VarinhaDasTrevas;
import com.rpg.combate.Expelliarmus;
import java.util.ArrayList;

/**
 * Representa a classe de dementador
 * Define os atributos e métodos que um dementador possui 
 * @author Gabriel Casé da Costa, Daniel Farias
 * @version 
 * @since 2025-10-03
 */

public class Dementador extends Monstro {
    /** 
     * Construtor da classe dementador
     * @param nome      nome do dementador
     * @param pontosDeVida      vida inicial do dementador
     * @param forca     força inicial do dementador
     * @param arma      arma inicial do dementador
     * @param xpConcedido       experiencia concedida pelo dementador
     * @param listaDeItensParaLargar    lista de itens para largar
     */

    public Dementador() {
        super("Dementador", 100, 15, new VarinhaDasTrevas(), 50, new ArrayList<>());
        
        this.acoes = Arrays.asList(new Expelliarmus(35));
    }
    
    @Override
    public Item droparLoot() {
        return new PocaoDeChocolate();
    }
}