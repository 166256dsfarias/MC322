import java.util.List;

public interface Fase {
    void iniciar(Heroi heroi);
    boolean isConcluida();
    TipoCenario getTipoDeCenario();

    List<Monstro> getMonstros();
}
