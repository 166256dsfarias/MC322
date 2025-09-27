public abstract class Arma implements Item {
    protected int dano;
    protected int minNivel;
    protected String nome;
    
    public Arma(String nome, int dano, int minNivel){
        this.nome = nome;
        this.dano = dano;
        this.minNivel = minNivel;
    }

    @Override
    public String getNome() {
        return nome;
    }
}