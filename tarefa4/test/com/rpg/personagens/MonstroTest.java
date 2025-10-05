package MC322.tarefa4.test.com.rpg.personagens;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import com.rpg.itens.VarinhaDasTrevas;

public class MonstroTest {

    @Test
    public void deveReceberDanoCorretamente() {
        // Arrange: Monstro com 100 de vida
        Monstro dementador = new Dementador(); // Dementador começa com 100 de vida

        // Act: Recebe 40 de dano
        dementador.receberDano(40);

        // Assert: A vida deve ser 60. Cumpre o requisito 3.2. [cite: 1229]
        assertEquals(60.0, dementador.pontosDeVida, 0.01, "A vida deveria ser 60 após receber 40 de dano.");
    }

    @Test
    public void monstroDeveSerLootavel() {
        // Arrange: Cria uma instância de um monstro
        Monstro comensal = new ComensalDaMorte("Bellatrix", 100, 30, new VarinhaDasTrevas(), 5);

        // Act & Assert: Verifica se a instância do monstro é do tipo Lootavel.
        // Cumpre o requisito 3.2. [cite: 1230]
        assertTrue(comensal instanceof Lootavel, "Todo Monstro deve implementar a interface Lootavel.");
    }
}