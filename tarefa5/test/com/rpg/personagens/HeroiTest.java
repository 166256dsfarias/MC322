package com.rpg.personagens;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import com.rpg.exceptions.HabilidadeEspecialException;
import com.rpg.exceptions.NivelInsuficienteException;
import com.rpg.itens.Arma;
import com.rpg.itens.VarinhaDasVarinhas;
import com.rpg.itens.VarinhaDeSabugueiro;
import com.rpg.combate.AcaoDeCombate;
import com.rpg.combate.Combatente;

public class HeroiTest {

    @Test
    public void deveLancarExcecaoAoEquiparArmaComNivelInsuficiente() {
        // Arrange: Herói nível 1 e uma arma que requer nível 5
        Heroi aluno = new Aluno("Neville", 100, 10, 1, 0.2, 0, new VarinhaDeSabugueiro(), "Grifinória", 100);
        Arma varinhaPoderosa = new VarinhaDasVarinhas(); // Requer nível 5

        // Act & Assert: O teste confirma que a exceção NivelInsuficienteException é lançada
        // ao tentar equipar a arma
        assertThrows(NivelInsuficienteException.class, () -> {
            aluno.equiparArma(varinhaPoderosa);
        }, "Deveria lançar NivelInsuficienteException");
    }

    @Test
    public void deveLancarExcecaoAoUsarHabilidadeSemMagia() {
        // Arrange: Aluno com 0 de magia
        Aluno alunoSemMagia = new Aluno("Ron", 100, 15, 2, 0.3, 100, new VarinhaDeSabugueiro(), "Grifinória", 0);
        
        // Act & Assert: Testa se a HabilidadeEspecialException é lançada
        assertThrows(HabilidadeEspecialException.class, () -> {
            // O alvo não importa para este teste, pode ser null
            alunoSemMagia.usarHabilidadeEspecial(null); 
        }, "Deveria lançar HabilidadeEspecialException por falta de magia");
    }

    @Test
    public void deveReceberDanoCorretamente() {
        // Arrange: Herói com 200 de vida
        Heroi harry = new Aluno("Harry Potter", 200, 30, 1, 0.5, 0, new VarinhaDeSabugueiro(), "Grifinória", 100);

        // Act: Herói recebe 50 de dano
        harry.receberDano(50);

        // Assert: A vida do herói deve ser 150
        // Usamos um delta (0.01) para comparar valores double com segurança
        assertEquals(150.0, harry.pontosDeVida, 0.01, "A vida deveria ser 150 após receber 50 de dano.");
    }

    @Test
    public void heroiDeveSerUmCombatente() {
        // Cenário: Cria um herói
        Heroi heroi = new Aluno("Teste", 100, 10, 1, 0.5, 0, null, "Casa", 100);

        // Assert: Verifica se a instância do herói é do tipo Combatente
        assertTrue(heroi instanceof Combatente, "Todo Herói deve ser um Combatente.");
    }

    @Test
    public void deveAtacarUmAlvo() {
        // Cenário: Um herói e um monstro com 100 de vida
        Heroi heroi = new Professor("Dumbledore", 200, 50, 10, 0.8, 1000, 30, new VarinhaDasVarinhas(), 200);
        Monstro alvo = new Dementador(); // Dementador começa com 100 de vida

        double vidaInicialDoAlvo = alvo.pontosDeVida;

        // Act: Herói escolhe uma ação e a executa no alvo
        AcaoDeCombate acao = heroi.escolherAcao(alvo);
        if (acao != null) {
            acao.executar(heroi, alvo);
        }

        // Assert: Verifica se a vida do alvo diminuiu
        assertTrue(alvo.pontosDeVida < vidaInicialDoAlvo, "O ataque deveria ter reduzido a vida do alvo.");
    }
}