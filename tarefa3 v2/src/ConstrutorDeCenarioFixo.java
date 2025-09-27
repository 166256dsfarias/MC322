import java.util.ArrayList;
import java.util.List;

public class ConstrutorDeCenarioFixo implements GeradorDeFases {

    @Override
    public List<Fase> gerar(int quantidadeDeFases) {
        List<Fase> fases = new ArrayList<>();

        for (int i = 0; i < quantidadeDeFases; i++) {
            List<Monstro> monstros = new ArrayList<>();

            // Alterna entre Dementador e ComensalDaMorte
            if (i % 2 == 0) {
                monstros.add(new Dementador(
                    "Dementador " + (i + 1),
                    30 + i * 5,      // pontos de vida crescentes
                    8 + i * 2,       // força crescente
                    new VarinhaDeCarvalho(),  // arma
                    20 + i * 5       // XP concedido
                ));
            } else {
                monstros.add(new ComensalDaMorte(
                    "Comensal " + (i + 1),
                    40 + i * 5,
                    10 + i * 2,
                    new VarinhaDeSabugueiro(), // arma
                    1 + i                     // nível de crueldade
                ));
            }

            // Escolhendo o tipo de cenário da fase
            TipoCenario tipo = TipoCenario.values()[i % TipoCenario.values().length];

            // Criando a fase e adicionando na lista
            Fase fase = new FaseDeCombate(i + 1, tipo, monstros);
            fases.add(fase);
        }

        return fases;
    }
}
