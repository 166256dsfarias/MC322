package MC322.tarefa4.test.com.rpg.cenario;

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

        // Assert: Verifica se os atributos do monstro difícil são maiores.
        // Cumpre o requisito 3.3. [cite: 1233]
        assertTrue(monstroDificil.pontosDeVida > monstroFacil.pontosDeVida, "Vida do monstro no Difícil deveria ser maior.");
        assertTrue(monstroDificil.forca > monstroFacil.forca, "Força do monstro no Difícil deveria ser maior.");
    }
}