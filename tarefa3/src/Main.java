import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Criar o herói e adicionar ações
        Heroi harry = new Aluno("Harry Potter", 200, 20, 1, 0.5, 0, new VarinhaDeSabugueiro(), "Grifinória");
        harry.getAcoes().add(new AtaqueFisico());
        harry.getAcoes().add(new HabilidadeDeMagia());

        // Criar o gerador de fases
        GeradorDeFases gerador = new ConstrutorDeCenarioFixo(); 
        List<FaseInterface> fases = gerador.gerar(3); // gera 3 fases

        // Loop para cada fase
        for (FaseInterface fase : fases) {
            fase.iniciar(harry);
            System.out.println("O herói entrou no cenário: " + fase.getTipoDeCenario().getDescricao());

            // Pega os monstros da fase
            List<Monstro> monstros = ((FaseDeCombate) fase).getMonstros();

            for (Monstro monstro : monstros) {
                System.out.println("\nApareceu: " + monstro.getNome());

                while (harry.estaVivo() && monstro.estaVivo()) {
                    // Herói escolhe e executa ação
                    AcaoDeCombate acaoHeroi = harry.escolherAcao(monstro);
                    acaoHeroi.executar(harry, monstro);

                    if (!monstro.estaVivo()) {
                        System.out.println(monstro.getNome() + " foi derrotado!");
                        harry.ganharExperiencia(monstro.getXpConcedido());

                        // Loot
                        if (monstro instanceof Lootavel lootavel) {
                            Item loot = lootavel.droparLoot();
                            if (loot instanceof Arma arma) {
                                harry.equiparArma(arma);
                            }
                        }
                        break;
                    }

                    // Monstro escolhe e executa ação
                    AcaoDeCombate acaoMonstro = monstro.escolherAcao(harry);
                    acaoMonstro.executar(monstro, harry);

                    if (!harry.estaVivo()) {
                        System.out.println("Game Over! O herói foi derrotado.");
                        break;
                    }
                }

                if (!harry.estaVivo()) {
                    break; // sai da fase
                }
            }

            // Conclusão da fase
            if (harry.estaVivo()) {
                System.out.println("\nParabéns! O herói sobreviveu a esta fase!");
            } else {
                System.out.println("\nO herói não conseguiu sobreviver à fase.");
                break;
            }
        }
    }
}
