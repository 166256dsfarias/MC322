import java.util.ArrayList;

public class Dementador extends Monstro {
    // sem atributos diferenciais

    //Construtor
    public Dementador (String nome, int pontosDeVida, int forca, Arma arma, int xpConcedido, ArrayList<Arma> listaDeArmasParaLargar){
        super (nome, pontosDeVida, forca, arma, xpConcedido, listaDeArmasParaLargar);
    }

    @Override
    public void atacar (Personagem alvo){
        System.out.println(this.nome + "  suga a energia vital de " + alvo.nome);
        alvo.receberDano(forca);
    }
}
