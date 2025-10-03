package com.rpg.util;

import java.util.Scanner;
import java.util.NoSuchElementException;

/**
 * Representa a classe abstrata de herois
 * Define os atributos e métodos que um herói possui
 * 
 * @author Gabriel Casé da Costa, Daniel Farias
 * @version
 * @since 2025-10-03
 */

public class InputManager {
    private static final Scanner scanner = new Scanner(System.in); // declaracao de scanner

    /**
     * Função para ler um inteiro
     * 
     * @param mensagem mensagem exibida para o usuario
     * @param min      numero minimo do intervalo
     * @param max      numero maximo do intervalo
     * @return numero lido
     */
    public static int lerInteiro(String mensagem, int min, int max) {
        while (true) {
            System.out.print(mensagem + " (" + min + " - " + max + "): ");
            String input = null;
            try {
                input = scanner.nextLine().trim();
                if (input.isEmpty()) {
                    System.out.println("Entrada vazia. Digite um numero entre " + min + " e " + max + ".");
                    continue;
                }

                int valor = Integer.parseInt(input);
                if (valor < min || valor > max) {
                    System.out.println("Fora do intervalo. Digite um numero entre " + min + " e " + max + ".");
                    continue;
                }

                return valor;
            } catch (NumberFormatException e) {
                System.out.println("Valor invalido. Digite um numero inteiro.");
            } catch (NoSuchElementException e) {
                throw new RuntimeException("Entrada nao disponivel.", e);
            }
        }
    }

    /**
     * Função para ler uma string
     * 
     * @param mensagem mensagem exibida para o usuario
     * @return string lida
     */
    public static String lerString(String mensagem) {
        while (true) {
            // exibe mensagem
            System.out.print(mensagem);
            // le entrada e verifica se ha texto
            String input = null;
            try {
                input = scanner.nextLine().trim();
                if (input.isEmpty()) {
                    System.out.println("Entrada vazia. Digite um texto valido");
                    continue;
                }
                return input;
            } catch (NoSuchElementException e) {
                throw new RuntimeException("Entrada nao disponivel.", e);
            }
        }

    }

    /**
     * Função para ler sim ou não
     * 
     * @param mensagem mensagem exibida para o usuario
     * @return resposta lida
     */
    public static boolean lerSimNao(String mensagem) {
        while (true) {
            System.out.print(mensagem + " (S/N): ");
            String input = null;
            try {
                input = scanner.nextLine().trim().toLowerCase();
                if (input.isEmpty()) {
                    System.out.println("Entrada vazia. Digite S ou N.");
                    continue;
                }
                if (input.charAt(0) == 's') {
                    return true;
                }
                if (input.charAt(0) == 'n') {
                    return false;
                }
                System.out.println("Entrada invalida. Digite S ou N.");
            } catch (NoSuchElementException e) {
                throw new RuntimeException("Entrada nao disponivel.", e);
            }
        }

    }

    /**
     * Função para esperar enter
     * 
     * @param mensagem mensagem exibida para o usuario
     */
    public static void esperarEnter(String mensagem) {
        System.out.println(mensagem);
        scanner.nextLine();

    }

    /**
     * Fecha o scanner estático. Deve ser chamado apenas uma vez no final da
     * aplicação.
     * Fechar o scanner também fecha o System.in, impedindo leituras futuras.
     */
    public static void fecharScanner() {
        scanner.close();
        System.out.println("Recursos de entrada liberados.");
    }
}
