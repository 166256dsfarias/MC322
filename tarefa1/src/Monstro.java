public abstract class Monstro extends Personagem{  
    //Atributos extras dos personagens monstros: comensal da morte, dementador
    protected int xpConcedido;

    //Construtor
    public Monstro (String nome, int pontosDeVida, int forca, int xpConcedido){
        super (nome, pontosDeVida, forca);
        this.xpConcedido = xpConcedido;
    }

    // sobrescreve exibirStatus para mostrar também nivel e xp
    @Override
    public void exibirStatus(){
        super.exibirStatus();
        System.out.println("Expriencia Concedida: " + this.xpConcedido);

    }

}
