import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Monstro extends Personagem implements Combatente, Lootavel {
    protected int xpConcedido;
    protected ArrayList<Arma> listaDeArmasParaLargar;
    protected List<AcaoDeCombate> acoes;

    public Monstro(String nome, int pontosDeVida, int forca, Arma arma, int xpConcedido, ArrayList<Arma> listaDeArmasParaLargar){
        super(nome, pontosDeVida, forca, arma);
        this.xpConcedido = xpConcedido;
        this.listaDeArmasParaLargar = listaDeArmasParaLargar;
        this.acoes = new ArrayList<>();
    }

    public int getXpConcedido() {
        return xpConcedido;
    }

    public List<AcaoDeCombate> getAcoes() {
        return acoes;
    }

    @Override
    public AcaoDeCombate escolherAcao(Combatente alvo) {
        Random random = new Random();
        return acoes.get(random.nextInt(acoes.size()));
    }

    @Override
    public boolean estaVivo() {
        return pontosDeVida > 0;
    }

    @Override
    public void receberDano(int dano) {
        pontosDeVida -= dano;
        if(pontosDeVida < 0) pontosDeVida = 0;
    }

    @Override
    public void receberCura(int cura) {
        pontosDeVida += cura;
    }

    @Override
    public Item droparLoot() {
        if(listaDeArmasParaLargar.isEmpty()) return null;
        Random random = new Random();
        return listaDeArmasParaLargar.get(random.nextInt(listaDeArmasParaLargar.size()));
    }
}
