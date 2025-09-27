import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Monstro extends Personagem implements Lootavel {
    protected int xpConcedido;
    protected List<Arma> listaDeArmasParaLargar;
    protected List<AcaoDeCombate> acoes;

    // Construtor
    public Monstro(String nome, int pontosDeVida, int forca, Arma arma, int xpConcedido, List<Arma> listaDeArmasParaLargar) {
        super(nome, pontosDeVida, forca, arma);
        this.xpConcedido = xpConcedido;
        this.listaDeArmasParaLargar = listaDeArmasParaLargar;
        this.acoes = new ArrayList<>();
    }

    // sobrescreve exibirStatus para mostrar também xp concedido
    @Override
    public void exibirStatus() {
        super.exibirStatus();
        System.out.println("Experiência concedida: " + this.xpConcedido);
    }

    // Implementação de Lootavel
    @Override
    public Item droparLoot() {
        if (listaDeArmasParaLargar == null || listaDeArmasParaLargar.isEmpty()) {
            return null;
        }
        Random random = new Random();
        int indice = random.nextInt(listaDeArmasParaLargar.size());
        return listaDeArmasParaLargar.get(indice); // Arma agora é um Item
    }

    // IA do monstro
    @Override
    public AcaoDeCombate escolherAcao(Combatente alvo) {
        if (acoes.isEmpty()) {
            System.out.println(nome + " não possui ações disponíveis!");
            return null;
        }
        Random rand = new Random();
        AcaoDeCombate escolhida = acoes.get(rand.nextInt(acoes.size()));
        System.out.println(nome + " escolheu a ação: " + escolhida.getDescricao());
        return escolhida;
    }
}
