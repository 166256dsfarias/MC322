package com.rpg.cenario;

import com.rpg.personagens.Monstro;
import com.rpg.itens.VarinhaDeAzevinho;
import com.rpg.itens.VarinhaDeCarvalho;
import com.rpg.itens.VarinhaDeSabugueiro;
import com.rpg.personagens.ComensalDaMorte;
import com.rpg.personagens.Dementador;
import com.rpg.itens.VarinhaDasVarinhas;
import java.util.List;
import java.util.ArrayList;

/**
 * Representa a classe responsavel por gerar cada cenario
 * Adiciona monstros em cada cenario, alterando atributos de cada monstro para cada dificuldade
 *  
 * @author Gabriel Casé da Costa, Daniel Farias
 * @version 
 * @since 2025-10-03
 */

public class ConstrutorDeCenarioFixo implements GeradorDeFases {
    @Override
    public List<Fase> gerar(int quantidadeDeFases, Dificuldade dificuldade) {
        List<Fase> fases = new ArrayList<>();
        double multiplicador = dificuldade.getMultiplicador();

        for (int i = 0; i < quantidadeDeFases; i++) {
            ArrayList<Monstro> monstros = new ArrayList<>(); //cria lista de monstro diferente para cada fase
            if(i == 0){
                monstros.add(new ComensalDaMorte("Belatrix Lestrange", 100*multiplicador, 30*multiplicador, new VarinhaDeAzevinho(), 5));
                monstros.add(new ComensalDaMorte("Lucio Malfoy", 70*multiplicador, 15*multiplicador, new VarinhaDeCarvalho(), 2));
            }
            else if(i == 1){
                monstros.add(new ComensalDaMorte("Draco Malfoy", 80*multiplicador, 20*multiplicador, new VarinhaDeSabugueiro(), 5));
                monstros.add(new Dementador());
            }
            if(i == 2){
                monstros.add(new ComensalDaMorte("Lord Voldemort", 150*multiplicador, 50*multiplicador, new VarinhaDasVarinhas(), 10));
            }

            TipoCenario tipo = switch (i) {
                case 0 -> TipoCenario.FLORESTA_PROIBIDA;
                case 1 -> TipoCenario.SALAO_PRINCIPAL;
                default -> TipoCenario.CABANA_DO_HAGRID;
            };

            fases.add(new FaseDeCombate(tipo, monstros));
        }
        return fases;
    }
}