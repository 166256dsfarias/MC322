import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ConstrutorDeCenarioFixo implements GeradorDeFases {

    @Override
    public List<FaseInterface> gerar(int quantidadeDeFases) {
        List<FaseInterface> fases = new ArrayList<>();

        for (int i = 0; i < quantidadeDeFases; i++) {
            // Aqui você cria sua FaseDeCombate ou outra classe que implementa FaseInterface
            FaseDeCombate fase = new FaseDeCombate();
            fases.add(fase);
        }

        return fases;
    }
}
