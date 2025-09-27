import java.util.Arrays;

public class Dementador extends Monstro {

    public Dementador(String nome, int pontosDeVida, int forca, Arma arma, int xpConcedido) {
        super(nome, pontosDeVida, forca, arma, xpConcedido, Arrays.asList(
            new PocaoDeChocolate() // loot temático (cura contra dementador)
        ));

        // Define as ações disponíveis do Dementador
        this.acoes = Arrays.asList(
            new Expelliarmus(forca / 2)
        );
    }
}
