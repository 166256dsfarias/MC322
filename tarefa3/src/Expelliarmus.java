public class Expelliarmus implements AcaoDeCombate {
    private int dano;

    public Expelliarmus(int dano) {
        this.dano = dano;
    }

    @Override
    public void executar(Combatente usuario, Combatente alvo) {
        System.out.println(usuario.getNome() + " lança Expelliarmus contra " + alvo.getNome() + "!");
        alvo.receberDano(dano); // ← DEVE causar dano
        System.out.println(alvo.getNome() + " recebeu " + dano + " de dano!");
    }

    @Override
    public String getDescricao() {
        return "Expelliarmus (Dano: " + dano + ")";
    }
}