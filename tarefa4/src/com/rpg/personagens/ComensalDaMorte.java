package com.rpg.personagens;

import java.util.Arrays;
import java.util.ArrayList;

import com.rpg.combate.AvadaKedavra;
import com.rpg.itens.Arma;
import com.rpg.itens.PocaoDasTrevas;
import com.rpg.itens.VarinhaDasTrevas;

/**
 * Representa a classe de comensais da morte
 * Define os atributos e métodos que um comensal da morte possui 
 * @author Gabriel Casé da Costa, Daniel Farias
 * @version 
 * @since 2025-10-03
 */

public class ComensalDaMorte extends Monstro {
    private int nivelCrueldade;
    /**
     * Construtor da classe comensal da morte
     * @param nome      nome do comensal da morte
     * @param pontosDeVida      vida inicial do comensal da morte
     * @param forca     força inicial do comensal da morte
     * @param arma      arma inicial do comensal da morte
     * @param nivelCrueldade   nivel de crueldade do comensal da morte
     */
    public ComensalDaMorte(String nome, double pontosDeVida, double forca, Arma arma, int nivelCrueldade) {
        super(nome, pontosDeVida, forca, arma, nivelCrueldade * 50, new ArrayList<>(Arrays.asList(
            new VarinhaDasTrevas(), 
            new PocaoDasTrevas()
        )));
        this.nivelCrueldade = nivelCrueldade;

        /**
         * define as acoes do comensal da morte
         */ 
        this.acoes = Arrays.asList(
            new AvadaKedavra(forca * nivelCrueldade)
        );
    }
}
