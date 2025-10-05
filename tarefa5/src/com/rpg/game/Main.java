package com.rpg.game;

import java.util.List;

import com.rpg.cenario.ConstrutorDeCenarioFixo;
import com.rpg.cenario.Dificuldade;
import com.rpg.cenario.Fase;
import com.rpg.cenario.GeradorDeFases;
import com.rpg.combate.AcaoDeCombate;
import com.rpg.personagens.Aluno;
import com.rpg.personagens.Heroi;
import com.rpg.personagens.Monstro;
import com.rpg.util.InputManager;
import com.rpg.itens.VarinhaDeSabugueiro;

/**
 * Representa a classe principal do RPG
 * Apresenta a jogabilidade principal do RPG, com a interação com o usuário,
 * turnos
 * 
 * @author Gabriel Casé da Costa, Daniel Farias
 * @version
 * @since 2025-10-03
 */

public class Main {
    public static void main(String[] args) {
        // Chamar o Menu Principal
        Interacao interacao = new Interacao();
        boolean iniciar = interacao.exibirMenuPrincipal();

        if (!iniciar) {
            System.out.println("Saindo do jogo...");
            InputManager.fecharScanner();
            return; // Encerra o programa se o jogador escolheu sair
        }

        // Escolher dificuldade
        Dificuldade dificuldade_Escolhida = interacao.escolherDificuldade();
        // Criar herói
        Heroi harry = new Aluno("Harry Potter", 200, 30, 1, 0.5, 0, new VarinhaDeSabugueiro(), "Grifinória", 0);

        // Criar gerador de fases
        GeradorDeFases gerador = new ConstrutorDeCenarioFixo();
        List<Fase> fases = gerador.gerar(3, dificuldade_Escolhida);

        // Loop por cada fase
        for (Fase fase : fases) {
            fase.iniciar(harry);

            for (Monstro monstroAtual : fase.getMonstros()) {
                System.out.println("\n=== " + monstroAtual.getNome() + " aparece! ===");

                int turno = 1;
                while (harry.estaVivo() && monstroAtual.estaVivo()) {
                    System.out.println("\n--- Turno " + turno + " ---");

                    // Turno do herói
                    AcaoDeCombate acaoHeroi = harry.escolherAcao(monstroAtual);
                    if (acaoHeroi != null) {
                        acaoHeroi.executar(harry, monstroAtual);
                    }

                    // Verifica se monstro morreu
                    if (!monstroAtual.estaVivo()) {
                        System.out.println(monstroAtual.getNome() + " foi derrotado!");
                        break;
                    }

                    // Turno do monstro
                    AcaoDeCombate acaoMonstro = monstroAtual.escolherAcao(harry);
                    if (acaoMonstro != null) {
                        acaoMonstro.executar(monstroAtual, harry);
                    }

                    // Verifica se herói morreu
                    if (!harry.estaVivo()) {
                        System.out.println("O herói foi derrotado!");
                        break;
                    }

                    turno++;

                    // PROTEÇÃO CONTRA LOOP INFINITO - máximo 50 turnos
                    if (turno > 50) {
                        System.out.println("Combate muito longo! Interrompendo...");
                        break;
                    }

                    // Pequena pausa para visualização
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                if (harry.estaVivo()) {
                    System.out.println("\n" + monstroAtual.getNome() + " derrotado!");
                    boolean continuar = interacao.interacaoPosTurno(harry, monstroAtual);
                    if (!continuar) {
                        InputManager.fecharScanner();
                        return; // Encerra se o jogador desistiu
                    }
                    harry.ganharExperiencia(monstroAtual.getXpConcedido());
                    if (harry instanceof Aluno) {
                        ((Aluno) harry).receberMagia(10);
                    }

                } else {
                    System.out.println("Game Over! O herói foi derrotado.");
                    return;
                }
            }
        }

        System.out.println("\nParabéns! O herói sobreviveu a todas as fases!");
        InputManager.fecharScanner();
    }
}