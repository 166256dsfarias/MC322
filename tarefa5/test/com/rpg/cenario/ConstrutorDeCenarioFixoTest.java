package com.rpg.cenario;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.List;
import com.rpg.personagens.Monstro;

public class ConstrutorDeCenarioFixoTest {

    @Test
    public void monstrosDevemSerMaisFortesNaDificuldadeDificil() {
        // Arrange
        ConstrutorDeCenarioFixo gerador = new ConstrutorDeCenarioFixo();

        // Act
        // Gera o mesmo cenário (1 fase) em duas dificuldades diferentes
        List<Fase> fasesFaceis = gerador.gerar(1, Dificuldade.FACIL);
        List<Fase> fasesDificeis = gerador.gerar(1, Dificuldade.DIFICIL);

        // Pega o primeiro monstro ("Belatrix") de cada cenário gerado
        Monstro monstroFacil = fasesFaceis.get(0).getMonstros().get(0);
        Monstro monstroDificil = fasesDificeis.get(0).getMonstros().get(0);

        // Assert: Verifica se os atributos do monstro difícil são maiores
        // Faz um acesso indevido, gerando um erro no test como esperado
        assertTrue(monstroDificil.pontosDeVida > monstroFacil.pontosDeVida, "Vida do monstro no Difícil deveria ser maior.");
        assertTrue(monstroDificil.forca > monstroFacil.forca, "Força do monstro no Difícil deveria ser maior.");
    }
}