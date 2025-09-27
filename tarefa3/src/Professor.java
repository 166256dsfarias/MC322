import java.util.Arrays;

public class Professor extends Heroi {
    private int tempoDeMagisterio;

    // Construtor
    public Professor(String nome, int pontosDeVida, int forca, int nivel, double sorte, int experiencia, int tempoDeMagisterio, Arma arma) {
        super(nome, pontosDeVida, forca, nivel, sorte, experiencia, arma);
        this.tempoDeMagisterio = tempoDeMagisterio;

        // Define as ações do Professor
        this.acoes.addAll(Arrays.asList(
            new Expelliarmus(10)
        ));
    }

    @Override
    public void usarHabilidadeEspecial(Combatente alvo) {
        System.out.println(this.nome + " conjura um feitiço avançado contra " + alvo.getNome() + "!");
        int dano = (this.forca + tempoDeMagisterio) * this.nivel;
        alvo.receberDano(dano);
        System.out.println(alvo.getNome() + " recebeu " + dano + " de dano!");
    }
}
