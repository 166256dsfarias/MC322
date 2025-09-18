public abstract class Heroi extends Personagem {
    //Atributos extras dos personagens herois: Aluno e professor
    protected int nivel;
    protected int experiencia;
    protected int expProximoNivel;
    protected double sorte;

    //Construtor
    public Heroi (String nome, int pontosDeVida, int forca, int nivel, double sorte, int experiencia, Arma arma){
        super (nome, pontosDeVida, forca, arma); //chamada de construtor da classe Personagem
        this.nivel = nivel;
        this.experiencia = experiencia;
        this.sorte = sorte;
    }

    public void ganharExperiencia(int pontos) {
        this.experiencia += pontos;

        int limite = 100 + 100 * (this.nivel * this.nivel);

        if (this.experiencia >= limite) {
            this.experiencia -= limite;
            subirDeNivel();
        }
    }

    // sobrescreve exibirStatus para mostrar também nivel e xp
    @Override
    public void exibirStatus(){
        super.exibirStatus();
        System.out.println("Nivel: " + this.nivel);
        System.out.println("Experiencia: " + this.experiencia);

    }

    public abstract void usarHabilidadeEspecial(Personagem alvo);
    public void equiparArma(Arma novaArma){
        this.arma = novaArma;
        System.out.println("Nova Arma equipada: " + novaArma.getClass().getSimpleName());
    }
    private void subirDeNivel(){
        this.nivel++;
        this.expProximoNivel = 100 + 100 * (this.nivel * this.nivel); // atualiza limite para próximo nível
        this.pontosDeVida += 20; // aumenta vida
        this.forca += 5;         // aumenta força
        System.out.println(this.nome + " subiu para o nível " + this.nivel + "!");
        System.out.println("Pontos de vida aumentados para: " + this.pontosDeVida);
        System.out.println("Força aumentada para: " + this.forca);
    }
}