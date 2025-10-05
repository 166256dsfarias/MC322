package MC322.tarefa4.test.com.rpg.personagens;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import com.rpg.exceptions.HabilidadeEspecialException;
import com.rpg.exceptions.NivelInsuficienteException;
import com.rpg.itens.Arma;
import com.rpg.itens.VarinhaDasVarinhas;
import com.rpg.itens.VarinhaDeSabugueiro;

public class HeroiTest {

    @Test
    public void deveLancarExcecaoAoEquiparArmaComNivelInsuficiente() {
        // Arrange: Herói nível 1 e uma arma que requer nível 5 [cite: 2472]
        Heroi aluno = new Aluno("Neville", 100, 10, 1, 0.2, 0, new VarinhaDeSabugueiro(), "Grifinória", 100);
        Arma varinhaPoderosa = new VarinhaDasVarinhas(); // Requer nível 5 [cite: 2472]

        // Act & Assert: O teste confirma que a exceção NivelInsuficienteException é lançada
        // ao tentar equipar a arma. Cumpre o requisito 3.4. [cite: 1237]
        assertThrows(NivelInsuficienteException.class, () -> {
            aluno.equiparArma(varinhaPoderosa);
        }, "Deveria lançar NivelInsuficienteException");
    }

    @Test
    public void deveLancarExcecaoAoUsarHabilidadeSemMagia() {
        // Arrange: Aluno com 0 de magia
        Aluno alunoSemMagia = new Aluno("Ron", 100, 15, 2, 0.3, 100, new VarinhaDeSabugueiro(), "Grifinória", 0);
        
        // Act & Assert: Testa se a HabilidadeEspecialException é lançada. Cumpre o requisito 3.4. [cite: 1237]
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

        // Assert: A vida do herói deve ser 150. Cumpre o requisito 3.2. [cite: 1228]
        // Usamos um delta (0.01) para comparar valores double com segurança.
        assertEquals(150.0, harry.pontosDeVida, 0.01, "A vida deveria ser 150 após receber 50 de dano.");
    }
}