import java.util.Arrays;

public class Aluno extends Heroi {
    private String casa;

    // Construtor
    public Aluno(String nome, int pontosDeVida, int forca, int nivel, double sorte, int experiencia, Arma arma, String casa) {
        super(nome, pontosDeVida, forca, nivel, sorte, experiencia, arma);
        this.casa = casa;

        // Define as ações do Aluno (herói)
        this.acoes.addAll(Arrays.asList(
            new ExpectoPatronum(20)
        ));
    }

    @Override
    public void usarHabilidadeEspecial(Combatente alvo) {
        System.out.println(this.nome + " da casa " + this.casa + " usa Protego Maxima!");
        // Exemplo: habilidade defensiva → recupera um pouco de vida
        this.receberCura(10);
    }
}
