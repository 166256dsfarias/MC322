public abstract class Heroi extends Personagem {
    //Atributos extras dos personagens herois: Aluno e professor
    protected int nivel;
    protected int experiencia;

    //Construtor
    public Heroi (String nome, int pontosDeVida, int forca, int nivel, int experiencia){
        super (nome, pontosDeVida, forca); //chamada de construtor da classe Personagem
        this.nivel = nivel;
        this.experiencia = experiencia;
    }

    public void ganharExperiencia(int pontos) {
        this.experiencia += pontos;

        int limite = 100 + 100 * (this.nivel * this.nivel);

        if (this.experiencia >= limite) {
            this.experiencia -= limite;
            this.nivel++;
            System.out.println(this.nome + " subiu para o nível " + this.nivel + "!");
        }
    }

    // sobrescreve exibirStatus para mostrar também nivel e xp
    @Override
    public void exibirStatus(){
        super.exibirStatus();
        System.out.println("Nivel: " + this.nivel);
        System.out.println("Expriencia: " + this.experiencia);

    }

    // contrato de habilidade especial (cada herói terá a sua)
    public abstract void usarHabilidadeEspecial(Personagem alvo);
}