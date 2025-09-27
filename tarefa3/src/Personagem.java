import java.util.List;

public abstract class Personagem implements Combatente {
    protected String nome;
    protected int pontosDeVida;
    protected int forca;
    protected Arma arma;

    //Construtor
    public Personagem(String nome, int pontosDeVida, int forca, Arma arma) {
        this.nome = nome;
        this.pontosDeVida = pontosDeVida;
        this.forca = forca;
        this.arma = arma;
    }

    // Métodos da interface Combatente
    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public boolean estaVivo() {
        return pontosDeVida > 0;
    }

    @Override
    public void receberDano(int dano) {
        this.pontosDeVida -= dano;
        if (this.pontosDeVida < 0) this.pontosDeVida = 0;
    }

    @Override
    public void receberCura(int cura) {
        this.pontosDeVida += cura;
    }

    // Status
    public void exibirStatus() {
        System.out.println(nome + " | Vida: " + pontosDeVida + " | Força: " + forca);
        if (arma != null) {
            System.out.println("Arma equipada: " + arma.getNome());
        }
    }

    // Agora o contrato é via Combatente
    @Override
    public abstract AcaoDeCombate escolherAcao(Combatente alvo);
}
