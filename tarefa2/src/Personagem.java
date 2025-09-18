public abstract class Personagem {
    // Inspirado no universo de Harry Potter, todos os personagens serão MAGOS
    protected String nome;
    protected int pontosDeVida;
    protected int forca;
    protected Arma arma;

    //Construtor
    public Personagem (String nome, int pontosDeVida, int forca, Arma arma){
        this.nome = nome;
        this.pontosDeVida = pontosDeVida;
        this.forca = forca;
        this.arma = arma;
    }

    public void receberDano (int dano){
        this.pontosDeVida -= dano;
        this.pontosDeVida = this.pontosDeVida < 0 ? 0 : pontosDeVida; //evitar que alguem fique com vida negativa
    }

    public void exibirStatus (){
        System.out.println("Nome: "+ nome);
        System.out.println("Vida: "+ pontosDeVida);
    }

    // Contrato que as subclasses devem implementar, onde cada persongem possui uma forma distinta para atacar
    public abstract void atacar(Personagem alvo);

}