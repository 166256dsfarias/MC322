import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Heroi extends Personagem {
    protected int nivel;
    protected int experiencia;
    protected int expProximoNivel;
    protected double sorte;
    protected List<AcaoDeCombate> acoes;

    // Construtor
    public Heroi(String nome, int pontosDeVida, int forca, int nivel, double sorte, int experiencia, Arma arma) {
        super(nome, pontosDeVida, forca, arma);
        this.nivel = nivel;
        this.experiencia = experiencia;
        this.sorte = sorte;
        this.expProximoNivel = 100; // valor inicial
        this.acoes = new ArrayList<>();
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
    public void exibirStatus() {
        super.exibirStatus();
        System.out.println("Nível: " + this.nivel);
        System.out.println("Experiência: " + this.experiencia + "/" + expProximoNivel);
    }

    //tratando habilidade especial como uma ação especial
    public abstract void usarHabilidadeEspecial(Combatente alvo);

    public void equiparArma(Arma novaArma) {
        this.arma = novaArma;
        System.out.println("Nova arma equipada: " + novaArma.getClass().getSimpleName());
    }

    private void subirDeNivel() {
        this.nivel++;
        this.expProximoNivel = 100 + 100 * (this.nivel * this.nivel); // atualiza limite para próximo nível
        this.pontosDeVida += 20; // aumenta vida
        this.forca += 5;         // aumenta força
        System.out.println(this.nome + " subiu para o nível " + this.nivel + "!");
        System.out.println("Pontos de vida aumentados para: " + this.pontosDeVida);
        System.out.println("Força aumentada para: " + this.forca);
    }

    @Override
    public AcaoDeCombate escolherAcao(Combatente alvo) {
        if (acoes.isEmpty()) {
            System.out.println(nome + " não tem nenhuma ação definida!");
            return null;
        }
        Random rand = new Random();
        AcaoDeCombate escolhida = acoes.get(rand.nextInt(acoes.size()));
        System.out.println(nome + " escolheu a ação: " + escolhida.getDescricao());
        return escolhida;
    }
}
