import java.util.Arrays;

public class ComensalDaMorte extends Monstro {
    private int nivelCrueldade;

    public ComensalDaMorte(String nome, int pontosDeVida, int forca, Arma arma, int nivelCrueldade) {
        super(nome, pontosDeVida, forca, arma, nivelCrueldade * 50, Arrays.asList(
            new VarinhaDasTrevas(), 
            new PocaoDasTrevas()
        ));
        this.nivelCrueldade = nivelCrueldade;

        // Define as ações que ele pode usar
        this.acoes = Arrays.asList(
            new AvadaKedavra(forca * nivelCrueldade),
        );
    }
}
