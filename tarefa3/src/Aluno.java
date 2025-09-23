public class Aluno extends Heroi{
    //atributo exclusivo dos alunos de Hogwarts: Harry Hermione
    private String casa;

    //Construtor
    public Aluno (String nome, int pontosDeVida, int forca, int nivel, double sorte, int experiencia, Arma arma, String casa){
        super (nome, pontosDeVida, forca, nivel, sorte, experiencia, arma);
        this.casa = casa;
    }

    @Override
    public void atacar (Personagem alvo){
        System.out.println(this.nome + " da casa " + this.casa + " lança Expelliarmus em " + alvo.nome);
        alvo.receberDano(this.forca);
    }

    @Override
    public void usarHabilidadeEspecial(Personagem alvo){}
}
