import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Criar o herói
        Heroi harry = new Aluno("Harry Potter", 200, 20, 1, 0.5, 0, new VarinhaDeSabugueiro(), "Grifinória");

        // Criar as fases usando o construtor de cenário fixo
        GeradorDeFases gerador = new ConstrutorDeCenarioFixo();
        List<Fase> fases = gerador.gerar(3);

        // Loop principal para cada fase
        for (Fase fase : fases) {
            System.out.println("\n=== INÍCIO DA FASE: " + fase.getTipoDeCenario().getDescricao() + " ===");
            fase.iniciar(harry); // aplica efeitos do cenário
            System.out.println("O herói entra na fase para enfrentar " + fase.getMonstros().size() + " monstros!");
            harry.exibirStatus();

            // Loop para cada monstro da fase
            for (Monstro monstro : fase.getMonstros()) {
                System.out.println("\nO monstro " + monstro.getNome() + " aparece!");

                // Loop de combate
                while (harry.estaVivo() && monstro.estaVivo()) {
                    // Herói escolhe ação e executa
                    AcaoDeCombate acaoHeroi = harry.escolherAcao(monstro);
                    acaoHeroi.executar(harry, monstro);

                    // Verifica se monstro morreu
                    if (!monstro.estaVivo()) {
                        System.out.println(monstro.getNome() + " foi derrotado!");
                        harry.ganharExperiencia(monstro.getXpConcedido());

                        // Teste de sorte e loot
                        double chance = Math.random();
                        if (harry.sorte > chance && monstro instanceof Lootavel) {
                            Item loot = ((Lootavel) monstro).droparLoot();
                            System.out.println("O monstro deixou: " + loot.getNome());
                            if (harry.nivel >= loot.getMinNivel() && loot instanceof Arma) {
                                harry.equiparArma((Arma) loot);
                            }
                        }
                        break;
                    }

                    // Monstro escolhe ação e executa
                    AcaoDeCombate acaoMonstro = monstro.escolherAcao(harry);
                    acaoMonstro.executar(monstro, harry);

                    // Verifica se herói morreu
                    if (!harry.estaVivo()) {
                        System.out.println("Game Over! O herói foi derrotado.");
                        break;
                    }
                }

                if (!harry.estaVivo()) break;
            }

            if (!harry.estaVivo()) break;
        }

        // Conclusão do desafio
        if (harry.estaVivo()) {
            System.out.println("\nParabéns! O herói sobreviveu a todos os desafios!");
        } else {
            System.out.println("\nO herói não conseguiu sobreviver às fases.");
        }
    }
}
