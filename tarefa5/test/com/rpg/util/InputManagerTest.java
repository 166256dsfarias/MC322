package com.rpg.util;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.NoSuchElementException;

public class InputManagerTest {
    // Guarda o System.in original para restaurá-lo depois
    private final InputStream systemInOriginal = System.in;
    private ByteArrayInputStream testIn;

    // Este método é executado DEPOIS de cada teste
    @AfterEach
    public void restoreSystemInStream() {
        System.setIn(systemInOriginal);
    }

    // Função auxiliar para simular a digitação do usuário
    private void provideInput(String data) {
        testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    @Test
    public void testLerSimNao_DeveRetornarTrueParaEntradaS() {
        // Arrange: Simula o usuário digitando "s" e apertando Enter
        provideInput("s\n");
        
        // Act & Assert
        assertTrue(InputManager.lerSimNao("Teste Sim"), "Deveria retornar true para 's'");
    }

    @Test
    public void testLerSimNao_DeveRetornarFalseParaEntradaN() {
        // Arrange: Simula o usuário digitando "n" e apertando Enter
        provideInput("n\n");
        
        // Act & Assert
        assertFalse(InputManager.lerSimNao("Teste Não"), "Deveria retornar false para 'n'");
    }

    @Test
    public void testLerString_DeveRetornarOTextoDigitado() {
        // Arrange: Simula o usuário digitando "Harry Potter"
        String textoEsperado = "Harry Potter";
        provideInput(textoEsperado + "\n");
        
        // Act
        String resultado = InputManager.lerString("Digite seu nome: ");
        
        // Assert
        assertEquals(textoEsperado, resultado, "A string lida deveria ser 'Harry Potter'");
    }
}
