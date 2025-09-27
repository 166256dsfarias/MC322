import java.util.List;           
import java.util.ArrayList;     

public class ConstrutorDeCenarioFixo implements GeradorDeFases {
    @Override
    public List<Fase> gerar(int quantidadeDeFases) {
        List<Fase> fases = new ArrayList<>();

        for (int i = 0; i < quantidadeDeFases; i++) {
            List<Monstro> monstros = new ArrayList<>();
            monstros.add(new Dementador());

            TipoCenario tipo = switch (i) {
                case 0 -> TipoCenario.FLORESTA_PROIBIDA;
                case 1 -> TipoCenario.SALAO_PRINCIPAL;
                default -> TipoCenario.CABANA_DO_HAGRID;
            };

            fases.add(new FaseDeCombate(tipo, monstros));
        }
        return fases;
    }
}