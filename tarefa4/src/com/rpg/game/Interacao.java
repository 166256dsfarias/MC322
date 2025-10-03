package com.rpg.game;

import com.rpg.util.InputManager;
import com.rpg.personagens.Monstro;
import com.rpg.itens.Arma;
import com.rpg.itens.Item;
import com.rpg.itens.PocaoDasTrevas;
import com.rpg.itens.PocaoDeChocolate;
import com.rpg.cenario.Dificuldade;
import com.rpg.personagens.Heroi;

/**
 * Representa a classe de interação com o usuário
 * Define os métodos de interação com o usuário
 * 
 * @author Gabriel Casé da Costa, Daniel Farias
 * @version
 * @since 2025-10-03
 */

public class Interacao {
    /**
     * Exibe o menu principal do jogo.
     * 
     * @return true se o jogador escolher iniciar o jogo, false se escolher sair.
     */
    public boolean exibirMenuPrincipal() {
        while (true) {
            System.out.println("     Harry Potter - RPG      ");
            System.out.println("==================================================");
            System.out.println();
            System.out.println("[1] - Iniciar Novo Jogo");
            System.out.println("[2] - Ver Informações das Classes de Heróis");
            System.out.println("[3] - Ver Informações das Classes de Monstros");
            System.out.println("[4] - Ver Informações sobre as Varinhas");
            System.out.println("[5] - Ver Informações sobre as Poções");
            System.out.println("[6] - Sair do Jogo");
            System.out.println("==================================================");
            int opcao = InputManager.lerInteiro("Digite sua opção: ", 1, 6);
            if (opcao == 1) {
                return true; // Sinaliza para iniciar o jogo
            }
            if (opcao == 2) {
                System.out.println("Classe de Heróis");
                System.out.println(
                        "Atributos:   Nome    Vida   Forca    Nivel    Sorte     Experiencia    Arma    Ações");
                System.out.println("Tipos de Heróis:   Aluno   Professor ");
                InputManager.esperarEnter("Pressione Enter para voltar ao Menu Principal... ");
                continue;
            }
            if (opcao == 3) {
                System.out.println("Classe de Monstros");
                System.out.println("Atributos:    Nome    Vida   Forca    Nivel    Sorte     Experiencia    Arma ");
                System.out.println("Tipos de Monstros:   Comensal da Morte   Dementador ");
                InputManager.esperarEnter("Pressione Enter para voltar ao Menu Principal... ");
                continue;
            }
            if (opcao == 4) {
                System.out.println("Varinha das Trevas: \nDano: 35 \n Nível necessário: 2 ");
                System.out.println("Varinha das Varinhas: \nDano: 60 \n Nível necessário: 5 ");
                System.out.println("Varinha de Azevinho: \nDano: 30 \n Nível necessário: 1 ");
                System.out.println("Varinha de Carvalho: \nDano: 40 \n Nível necessário: 1 ");
                System.out.println("Varinha de Sabugueiro: \nDano: 25 \n Nível necessário: 1 ");
                System.out.println();
                InputManager.esperarEnter("Pressione Enter para voltar ao Menu Principal... ");
                continue;
            }
            if (opcao == 5) {
                System.out.println("Poção de Chocolate: ");
                System.out.println("Poção das Trevas: ");
                InputManager.esperarEnter("Pressione Enter para voltar ao Menu Principal... ");
                continue;
            }
            if (opcao == 6) {
                boolean escolha = InputManager.lerSimNao("Você tem certeza que deseja sair do jogo? ");
                if (escolha == true) {
                    return false; // Sinaliza para sair do jogo
                }
            }
        }

    }

    /**
     * Exibe a interação pos turno.
     * 
     * @param heroiAtual   heroi atual
     * @param monstroAtual monstro atual
     * @return true se o jogo deve continuar, false se o jogador desistiu.
     */
    public boolean interacaoPosTurno(Heroi heroiAtual, Monstro monstroAtual) {
        while (true) {
            System.out.println("==================================================");
            System.out.println();
            System.out.println("[1] - Interagir com o Loot de " + monstroAtual.getNome());
            System.out.println("[2] - Ver Informações de " + monstroAtual.getNome());
            System.out.println("[3] - Continuar Jogo");
            System.out.println("[4] - Desistir do Jogo");
            System.out.println("==================================================");
            int opcao = InputManager.lerInteiro("Digite sua opção: ", 1, 4);
            if (opcao == 1) {
                System.out.println("Interagindo com o Loot de  " + monstroAtual.getNome());
                Item loot = monstroAtual.droparLoot();

                if (loot != null) {
                    System.out.println("Loot dropado:  " + loot.getNome());
                    boolean escolha = InputManager.lerSimNao("Deseja pegar o loot?");
                    if (escolha == true && loot instanceof Arma) {
                        try {
                            heroiAtual.equiparArma((Arma) loot);
                        } catch (Exception e) {
                            System.out.println("AVISO: " + e.getMessage());
                        }
                        continue;
                    }
                    if (escolha == true && (loot instanceof PocaoDeChocolate || loot instanceof PocaoDasTrevas)) {
                        System.out.println(heroiAtual.getNome() + " pegou o loot: " + loot.getNome());
                        continue;
                    }
                }
                if (loot == null) {
                    System.out.println("Nenhum loot dropado.  ");
                    continue;
                }

            }
            if (opcao == 2) {
                System.out.println("Informações de " + monstroAtual.getNome());
                monstroAtual.exibirStatus();
                InputManager.esperarEnter("Pressione Enter para voltar... ");
                continue;
            }
            if (opcao == 3) {
                System.out.println("Continuando o jogo... ");
                return true;
            }
            if (opcao == 4) {
                boolean escolha = InputManager.lerSimNao("Você tem certeza que deseja desistir do jogo? ");
                if (escolha == true) {
                    System.out.println("Desistindo do jogo... ");
                    return false;
                }
            }
        }
    }

    /**
     * Escolhe a dificuldade do jogo
     * 
     * @return dificuldade escolhida
     */

    public Dificuldade escolherDificuldade() {
        System.out.println("Escolha a dificuldade: ");
        System.out.println("[1] - Fácil - " + Dificuldade.FACIL.getDescricao());
        System.out.println("[2] - Normal - " + Dificuldade.NORMAL.getDescricao());
        System.out.println("[3] - Difícil - " + Dificuldade.DIFICIL.getDescricao());
        int opcao = InputManager.lerInteiro("Digite sua opção: ", 1, 3);
        return switch (opcao) {
            case 1 -> Dificuldade.FACIL;
            case 2 -> Dificuldade.NORMAL;
            case 3 -> Dificuldade.DIFICIL;
            default -> Dificuldade.NORMAL;
        };
    }
}