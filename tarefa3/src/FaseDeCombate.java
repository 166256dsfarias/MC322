import java.util.List;

public class FaseDeCombate implements FaseInterface {
    private List<Monstro> monstros;
    private TipoCenario tipoCenario;

    public FaseDeCombate(List<Monstro> monstros, TipoCenario tipoCenario){
        this.monstros = monstros;
        this.tipoCenario = tipoCenario;
    }

    public List<Monstro> getMonstros() {
        return monstros;
    }

    @Override
    public void iniciar(Heroi heroi) {
        System.out.println("Iniciando fase em: " + tipoCenario.getDescricao());
        tipoCenario.aplicarEfeitos(heroi);
    }

    @Override
    public boolean isConcluida() {
        return monstros.stream().allMatch(monstro -> !monstro.estaVivo());
    }

    @Override
    public TipoCenario getTipoDeCenario() {
        return tipoCenario;
    }
}
