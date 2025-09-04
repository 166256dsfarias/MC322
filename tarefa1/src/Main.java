public class Main {
    public static void main(String[] args) {
        // Criar o herói
        Heroi harry = new Aluno("Harry Potter", 100, 20, 1, 0, "Grifinória");

        // Criar os monstros
        Monstro[] monstros = {
            new ComensalDaMorte("Bellatrix", 80, 15, 200, 5),
            new Dementador("Dementador", 100, 20, 150),
            new ComensalDaMorte("Voldemort", 200, 30, 500, 10)
        };

        // Mensagem inicial
        System.out.println("O herói entra na masmorra para enfrentar 3 monstros perigosos!");
        harry.exibirStatus();

        // Simulaçao dos Turnos em Loop
        for (int i = 0; i < monstros.length; i++) {
            Monstro monstroAtual = monstros[i];
            System.out.println("\nTurno " + (i + 1) + ": " + monstroAtual.nome + " aparece!");

            // Herói ataca o monstro
            harry.atacar(monstroAtual);

            // verifica se o monstro morreu
            if (monstroAtual.pontosDeVida <= 0) {
                System.out.println(monstroAtual.nome + " foi derrotado!");
                harry.ganharExperiencia(monstroAtual.xpConcedido);
                continue; // vai para o próximo turno
            }

            // Monstro ataca o heroi
            monstroAtual.atacar(harry);

            // verifica se o herói morreu
            if (harry.pontosDeVida <= 0) {
                System.out.println("Game Over! O herói foi derrotado.");
                break; // encerra o loop
            }

            // Status após o turno
            System.out.println("\nStatus após o turno " + (i + 1) + ":");
            harry.exibirStatus();
            monstroAtual.exibirStatus();
        }

        // Conclusão do Desafio
        if (harry.pontosDeVida > 0) {
            System.out.println("\nParabéns! O herói sobreviveu a todos os desafios!");
        } else {
            System.out.println("\nO herói não conseguiu sobreviver à masmorra.");
        }
    }
}
