import java.util.Arrays;

public class Aluno extends Heroi {
    private String casa;

    public Aluno(String nome, int pontosDeVida, int forca, int nivel, double sorte, int experiencia, Arma arma, String casa) {
        super(nome, pontosDeVida, forca, nivel, sorte, experiencia, arma);
        this.casa = casa;

        // AUMENTE A CURA/DANO
        this.acoes.addAll(Arrays.asList(
            new ExpectoPatronum(40)
        ));
    }

    @Override
    public void usarHabilidadeEspecial(Combatente alvo) {
        System.out.println(this.nome + " da casa " + this.casa + " usa Protego Maxima!");
        this.receberCura(15);
    }
}