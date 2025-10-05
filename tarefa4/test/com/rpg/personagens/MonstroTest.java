package com.rpg.personagens;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import com.rpg.combate.AcaoDeCombate;
import com.rpg.combate.Combatente;
import com.rpg.itens.VarinhaDasTrevas;
import com.rpg.itens.VarinhaDeSabugueiro;

public class MonstroTest {

    @Test
    public void monstroDeveSerUmCombatente() {
        // Arrange: Cria uma instância de um monstro concreto
        Monstro monstro = new Dementador();

        // Assert: Verifica se a instância do monstro é do tipo Combatente
        assertTrue(monstro instanceof Combatente, "Todo Monstro deve ser um Combatente.");
    }

    @Test
    public void monstroDeveSerLootavel() {
        // Arrange: Cria uma instância de um monstro concreto.
        Monstro monstro = new ComensalDaMorte("Draco", 80, 20, new VarinhaDasTrevas(), 3);

        // Assert: Verifica se a instância do monstro é do tipo Lootavel
        assertTrue(monstro instanceof Lootavel, "Todo Monstro deve implementar a interface Lootavel.");
    }

    @Test
    public void deveReceberDanoCorretamente() {
        // Arrange: Cria um Monstro com 100 de vida
        Monstro monstro = new Dementador(); // Dementador começa com 100 de vida

        // Act: Monstro recebe 30 de dano.
        monstro.receberDano(30);

        // Assert: A vida do monstro deve ser 70
        assertEquals(70.0, monstro.pontosDeVida, 0.01, "A vida deveria ser 70 após receber 30 de dano.");
    }

    @Test
    public void deveAtacarUmAlvo() {
        // Arrange: Um monstro (atacante) e um herói (alvo)
        Monstro monstro = new ComensalDaMorte("Bellatrix", 120, 35, new VarinhaDasTrevas(), 5);
        Heroi alvo = new Aluno("Harry", 200, 30, 5, 0.5, 0, new VarinhaDeSabugueiro(), "Grifinória", 100);

        double vidaInicialDoAlvo = alvo.pontosDeVida;

        // Act: Monstro escolhe uma ação e a executa no alvo
        AcaoDeCombate acao = monstro.escolherAcao(alvo);
        if (acao != null) {
            acao.executar(monstro, alvo);
        }

        // Assert: Verifica se a vida do alvo diminuiu após o ataque
        assertTrue(alvo.pontosDeVida < vidaInicialDoAlvo, "O ataque do monstro deveria ter reduzido a vida do herói.");
    }
}