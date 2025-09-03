public class ComensalDaMorte extends Monstro {
    //Atributo exclusivo comensal da morte
    private int nivelCrueldade;

    //Construtor
    public ComensalDaMorte (String nome, int pontosDeVida, int forca, int xpConcedido, int nivelCrueldade){
        super (nome, pontosDeVida, forca, nivelCrueldade * 50); // xp é concedido conforme o nível de crueldade
        this.nivelCrueldade = nivelCrueldade;
    }

    @Override
    public void atacar (Personagem alvo){
        System.out.println(this.nome + "  lança a Maldição Cruciatus em " + alvo.nome);
        alvo.receberDano(forca);
    }

    // habilidade especial extra
    public void avadaKedavra(Personagem alvo) {
        System.out.println(this.nome + " lança Avada Kedavra em " + alvo.nome);
        alvo.receberDano(this.forca * nivelCrueldade);
    }
}
