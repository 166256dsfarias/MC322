import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Criar herói
        Heroi harry = new Aluno("Harry Potter", 200, 20, 1, 0.5, 0, new VarinhaDeSabugueiro(), "Grifinória");

        // Criar gerador de fases
        GeradorDeFases gerador = new ConstrutorDeCenarioFixo();
        List<Fase> fases = gerador.gerar(3);

        // Loop por cada fase
        for (Fase fase : fases) {
            fase.iniciar(harry);

            for (Monstro monstroAtual : fase.getMonstros()) {
                System.out.println("\n=== " + monstroAtual.getNome() + " aparece! ===");

                int turno = 1;
                while (harry.estaVivo() && monstroAtual.estaVivo()) {
                    System.out.println("\n--- Turno " + turno + " ---");
                    
                    // Turno do herói
                    AcaoDeCombate acaoHeroi = harry.escolherAcao(monstroAtual);
                    if (acaoHeroi != null) {
                        acaoHeroi.executar(harry, monstroAtual);
                    }
                    
                    // Verifica se monstro morreu
                    if (!monstroAtual.estaVivo()) {
                        System.out.println(monstroAtual.getNome() + " foi derrotado!");
                        break;
                    }

                    // Turno do monstro
                    AcaoDeCombate acaoMonstro = monstroAtual.escolherAcao(harry);
                    if (acaoMonstro != null) {
                        acaoMonstro.executar(monstroAtual, harry);
                    }
                    
                    // Verifica se herói morreu
                    if (!harry.estaVivo()) {
                        System.out.println("O herói foi derrotado!");
                        break;
                    }
                    
                    turno++;
                    
                    // PROTEÇÃO CONTRA LOOP INFINITO - máximo 50 turnos
                    if (turno > 50) {
                        System.out.println("Combate muito longo! Interrompendo...");
                        break;
                    }
                    
                    // Pequena pausa para visualização
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                if (harry.estaVivo()) {
                    System.out.println("\n" + monstroAtual.getNome() + " derrotado!");
                    harry.ganharExperiencia(50);

                    if (monstroAtual instanceof Lootavel) {
                        Item loot = ((Lootavel) monstroAtual).droparLoot();
                        if (loot != null) {
                            System.out.println(harry.getNome() + " conseguiu loot: " + loot.getNome());
                        }
                    }
                } else {
                    System.out.println("Game Over! O herói foi derrotado.");
                    return;
                }
            }
        }

        System.out.println("\nParabéns! O herói sobreviveu a todas as fases!");
    }
}