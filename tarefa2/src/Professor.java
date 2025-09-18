public class Professor extends Heroi{
    //atributo exclusivo dos professores de Hogwarts: Snape, Dumbledore
    private int tempoDeMagisterio;

    //Construtor
    public Professor (String nome, int pontosDeVida, int forca, int nivel, double sorte, int experiencia, int tempoDeMagisterio, Arma arma){
        super (nome, pontosDeVida, forca, nivel, sorte, experiencia, arma);
        this.tempoDeMagisterio = tempoDeMagisterio;
    }

    @Override
    public void atacar (Personagem alvo){
        System.out.println(this.nome + " lança Stupefy em " + alvo.nome);
        alvo.receberDano(this.forca + tempoDeMagisterio);
    }

    @Override
    public void usarHabilidadeEspecial(Personagem alvo){
        System.out.println(this.nome + " conjura um feitiço avançado de " + alvo.nome);
        alvo.receberDano((this.forca + tempoDeMagisterio)* this.nivel);
    }
} 