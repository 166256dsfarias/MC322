import java.util.List;

public class FaseDeCombate implements Fase {
    private TipoCenario tipo;
    private List<Monstro> monstros;

    public FaseDeCombate(TipoCenario tipo, List<Monstro> monstros) {
        this.tipo = tipo;
        this.monstros = monstros;
    }

    @Override
    public void iniciar(Heroi heroi) {
        System.out.println("Entrando na fase: " + tipo.getDescricao());
        tipo.aplicarEfeitos(heroi);
    }

    @Override
    public boolean isConcluida() {
        return monstros.stream().allMatch(m -> m.pontosDeVida <= 0);
    }

    @Override
    public TipoCenario getTipoDeCenario() {
        return tipo;
    }

    @Override
    public List<Monstro> getMonstros() {
        return monstros;
    }
}
