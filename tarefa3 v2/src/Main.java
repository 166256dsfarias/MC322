import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Criar o herói
        Heroi harry = new Aluno("Harry Potter", 200, 20, 1, 0.5, 0, new VarinhaDeSabugueiro(), "Grifinória");

        //metodo contrutor de cenario
        int nFases = 3;
        ArrayList<Fase> fases = ConstrutorDeCenario.gerarFases(nFases);

        // Mensagem inicial/loop para cada fase
        for(Fase fase : fases){
            System.out.println("O herói entra na " + fase.ambiente + " para enfrentar " + fase.lista_monstros.size() + " monstros perigosos!");
            harry.exibirStatus();
        
        // Simulaçao dos Turnos em Loop
        for (int i = 0; i < fase.lista_monstros.size(); i++) {
            Monstro monstroAtual = fase.lista_monstros.get(i);
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
            //teste sorte
            double numero = Math.random();
            if (harry.pontosDeVida > 0 && harry.sorte > numero) {
                monstroAtual.largaArma();
            }
            if(harry.arma.dano < monstroAtual.arma.dano && harry.nivel >= monstroAtual.arma.minNivel){
                harry.equiparArma(monstroAtual.arma);
            }
            // Status após o turno
            System.out.println("\nStatus após o turno " + (i + 1) + ":");
            harry.exibirStatus();
            monstroAtual.exibirStatus();
        }
    }


        // Conclusão do Desafio
        if (harry.pontosDeVida > 0) {
            System.out.println("\nParabéns! O herói sobreviveu a todos os desafios!");
        } else {
            System.out.println("\nO herói não conseguiu sobreviver à fase.");
        }
    }
}
