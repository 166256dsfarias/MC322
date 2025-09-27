import java.util.ArrayList;

public class FaseDeCombate implements Fase {
    private int nivel;
    private TipoCenario tipoCenario;
    private ArrayList<Monstro> monstros;
    private boolean concluida;

    public FaseDeCombate(int nivel, TipoCenario tipoCenario, ArrayList<Monstro> monstros) {
        this.nivel = nivel;
        this.tipoCenario = tipoCenario;
        this.monstros = monstros;
        this.concluida = false;
    }

    @Override
    public void iniciar(Heroi heroi) {
        System.out.println("\n⚔️ Iniciando a fase no cenário: " + tipoCenario.getDescricao());
        tipoCenario.aplicarEfeitos(heroi); // efeito do ambiente

        for (Monstro m : monstros) {
            System.out.println("\n→ Um " + m.getNome() + " aparece!");

            // loop de combate até alguém morrer
            while (heroi.estaVivo() && m.estaVivo()) {
                // turno do herói
                AcaoDeCombate acaoHeroi = heroi.escolherAcao(m);
                acaoHeroi.executar(heroi, m);

                if (!m.estaVivo()) break;

                // turno do monstro
                AcaoDeCombate acaoMonstro = m.escolherAcao(heroi);
                acaoMonstro.executar(m, heroi);
            }

            if (!heroi.estaVivo()) {
                System.out.println("☠️ " + heroi.getNome() + " foi derrotado!");
                concluida = false;
                return;
            }
        }

        // se chegou até aqui, todos monstros morreram
        concluida = true;
        System.out.println("\n✅ Fase concluída!");
    }

    @Override
    public boolean isConcluida() {
        return concluida;
    }

    @Override
    public TipoCenario getTipoDeCenario() {
        return tipoCenario;
    }
}
