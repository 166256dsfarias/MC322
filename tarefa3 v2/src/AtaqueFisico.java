public class AtaqueFisico implements AcaoDeCombate {
    private String descricao;
    private int dano;

    public AtaqueFisico(String descricao, int dano) {
        this.descricao = descricao;
        this.dano = dano;
    }

    @Override
    public void executar(Combatente usuario, Combatente alvo) {
        System.out.println(usuario.getNome() + " usa " + descricao + " em " + alvo.getNome());
        alvo.receberDano(dano);
    }

    @Override
    public String getDescricao() {
        return descricao;
    }
}
