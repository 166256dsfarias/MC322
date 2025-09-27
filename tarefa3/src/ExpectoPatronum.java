public class ExpectoPatronum implements AcaoDeCombate {
    private int dano;

    public ExpectoPatronum(int dano) {
        this.dano = dano;
    }

    @Override
    public void executar(Combatente usuario, Combatente alvo) {
        System.out.println(usuario.getNome() + " conjura um Patrono brilhante com EXPECTO PATRONUM!");
        alvo.receberDano(dano);
        System.out.println("O Patrono causa " + dano + " de dano em " + alvo.getNome() + "!");
    }

    @Override
    public String getDescricao() {
        return "Expecto Patronum (Dano: " + dano + ")";
    }
}