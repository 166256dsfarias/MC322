public class Dementador extends Monstro {
    // sem atributos diferenciais

    //Construtor
    public Dementador (String nome, int pontosDeVida, int forca, int xpConcedido){
        super (nome, pontosDeVida, forca, xpConcedido);
    }

    @Override
    public void atacar (Personagem alvo){
        System.out.println(this.nome + "  suga a energia vital de " + alvo.nome);
        alvo.receberDano(forca);
    }
}
