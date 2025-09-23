import java.util.ArrayList;
import java.util.Random;

public abstract class Monstro extends Personagem{  
    //Atributos extras dos personagens monstros: comensal da morte, dementador
    protected int xpConcedido;
    protected ArrayList<Arma> listaDeArmasParaLargar;

    //Construtor
    public Monstro (String nome, int pontosDeVida, int forca, Arma arma, int xpConcedido, ArrayList<Arma> listaDeArmasParaLargar){
        super (nome, pontosDeVida, forca, arma);
        this.xpConcedido = xpConcedido;
        this.listaDeArmasParaLargar = listaDeArmasParaLargar;
    }

    // sobrescreve exibirStatus para mostrar também nivel e xp
    @Override
    public void exibirStatus(){
        super.exibirStatus();
        System.out.println("Experiencia Concedida: " + this.xpConcedido);

    }
    //funcao de largar arma
    public Arma largaArma(){
        Random random = new Random();
        int indice = random.nextInt(listaDeArmasParaLargar.size()); // gera um indice aleatorio dentro da lista
        return listaDeArmasParaLargar.get(indice); //retorna uma arma aleatoria
    }

}
