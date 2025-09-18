import java.util.ArrayList;

public class ComensalDaMorte extends Monstro {
    //Atributo exclusivo comensal da morte
    private int nivelCrueldade;

    //Construtor
    public ComensalDaMorte (String nome, int pontosDeVida, int forca, Arma arma, int xpConcedido, ArrayList<Arma> listaDeArmasParaLargar, int nivelCrueldade){
        super (nome, pontosDeVida, forca, arma, nivelCrueldade * 50, listaDeArmasParaLargar); // xp é concedido conforme o nível de crueldade
        this.nivelCrueldade = nivelCrueldade;
    }

    @Override
    public void atacar (Personagem alvo){
        System.out.println(this.nome + "  lança a Maldição Cruciatus em " + alvo.nome);
        alvo.receberDano(forca);
    }

    // habilidade especial extra
    public void avadaKedavra(Personagem alvo) {
        System.out.println(this.nome + " lança Avada Kedavra em " + alvo.nome);
        alvo.receberDano(this.forca * nivelCrueldade);
    }
}
