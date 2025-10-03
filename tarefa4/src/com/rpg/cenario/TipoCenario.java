package com.rpg.cenario;
import com.rpg.personagens.Heroi;

/**
 * Representa o enum Tipo de Cenario
 * Define os cenarios que existem no RPG
 * @author Gabriel Casé da Costa, Daniel Farias
 * @version 
 * @since 2025-10-03
 */

public enum TipoCenario {
    FLORESTA_PROIBIDA("Floresta Proibida") {
        @Override
        public void aplicarEfeitos(Heroi heroi) {
            System.out.println("A escuridão da Floresta Proibida assusta o herói... Ele perde 5 pontos de vida.");
            heroi.receberDano(5);
        }
    },
    SALAO_PRINCIPAL("Salão Principal de Hogwarts") {
        @Override
        public void aplicarEfeitos(Heroi heroi) {
            System.out.println("O Salão Principal inspira confiança. O herói recupera 5 pontos de vida.");
            heroi.receberCura(5);
        }
    },
    CABANA_DO_HAGRID("Cabana do Hagrid") {
        @Override
        public void aplicarEfeitos(Heroi heroi) {
            System.out.println("Na Cabana do Hagrid, o herói recebe ajuda de Canino! Ele ganha 2 pontos de vida.");
            heroi.receberCura(2);
        }
    },
    CAMPO_DE_QUADRIBOL("Campo de Quadribol") {
        @Override
        public void aplicarEfeitos(Heroi heroi) {
            System.out.println("O herói se lembra das vitórias no Quadribol e luta com mais força! Força +2.");
        }
    },
    SALA_PRECISA("Sala Precisa") {
        @Override
        public void aplicarEfeitos(Heroi heroi) {
            System.out.println("A Sala Precisa fornece o que é necessário... O herói recupera 10 pontos de vida!");
            heroi.receberCura(10);
        }
    };

    private final String descricao;

    TipoCenario(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public abstract void aplicarEfeitos(Heroi heroi);
}
