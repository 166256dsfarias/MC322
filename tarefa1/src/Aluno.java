public class Aluno extends Heroi{
    //atributo exclusivo dos alunos de Hogwarts
    private String casa;

    //Construtor
    public Aluno (String nome, int pontosDeVida, int forca, int nivel, int experiencia, String casa){
        super (nome, pontosDeVida, forca, nivel, experiencia);
        this.casa = casa;
    }

    @Override
    public void atacar (Personagem alvo){
        System.out.println(this.nome + " da casa " + this.casa + " lança Expelliarmus em " + alvo.nome);
        alvo.receberDano(this.forca);
    }

    @Override
    public void usarHabilidadeEspecial(Personagem alvo){
        System.out.println(this.nome + " da casa " + this.casa + " usa Petrificus Totalus em " + alvo.nome);
        alvo.receberDano(this.forca * this.nivel);
    }
}
