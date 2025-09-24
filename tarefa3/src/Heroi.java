import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Heroi extends Personagem implements Combatente {

    protected int nivel;
    protected int experiencia;
    protected int expProximoNivel;
    protected double sorte;

    protected List<AcaoDeCombate> acoes;

    public Heroi(String nome, int pontosDeVida, int forca, int nivel, double sorte, int experiencia, Arma arma) {
        super(nome, pontosDeVida, forca, arma);
        this.nivel = nivel;
        this.experiencia = experiencia;
        this.sorte = sorte;
        this.acoes = new ArrayList<>();
        this.expProximoNivel = 100 + 100 * (nivel * nivel);
    }

    public List<AcaoDeCombate> getAcoes() {
        return acoes;
    }

    @Override
    public AcaoDeCombate escolherAcao(Combatente alvo) {
        if (acoes.isEmpty()) {
            throw new IllegalStateException("Nenhuma ação disponível para o herói!");
        }
        Random random = new Random();
        return acoes.get(random.nextInt(acoes.size()));
    }

    public void ganharExperiencia(int pontos) {
        this.experiencia += pontos;
        if (this.experiencia >= expProximoNivel) {
            this.experiencia -= expProximoNivel;
            subirDeNivel();
        }
    }

    private void subirDeNivel() {
        this.nivel++;
        this.expProximoNivel = 100 + 100 * (nivel * nivel);
        this.pontosDeVida += 20;
        this.forca += 5;
        System.out.println(nome + " subiu para o nível " + nivel + "!");
        System.out.println("Vida: " + pontosDeVida + ", Força: " + forca);
    }

    public void equiparArma(Arma novaArma) {
        this.arma = novaArma;
        System.out.println("Nova arma equipada: " + novaArma.getClass().getSimpleName());
    }

    @Override
    public boolean estaVivo() {
        return pontosDeVida > 0;
    }

    @Override
    public void receberDano(int dano) {
        pontosDeVida -= dano;
        if (pontosDeVida < 0) pontosDeVida = 0;
    }

    @Override
    public void receberCura(int cura) {
        pontosDeVida += cura;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public void exibirStatus() {
        System.out.println("Nome: " + nome);
        System.out.println("Vida: " + pontosDeVida);
        System.out.println("Nivel: " + nivel + ", XP: " + experiencia);
        System.out.println("Força: " + forca);
    }
}
