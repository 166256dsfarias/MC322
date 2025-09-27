public class ExpectoPatronum implements AcaoDeCombate {
    private int cura;

    public ExpectoPatronum(int cura) {
        this.cura = cura;
    }

    @Override
    public void executar(Combatente usuario, Combatente alvo) {
        System.out.println(usuario.getNome() + " conjura um Patrono brilhante com EXPECTO PATRONUM!");
        usuario.receberCura(cura);
        System.out.println(usuario.getNome() + " sente a energia voltar graças ao Patrono!");
    }

    @Override
    public String getDescricao() {
        return "Expecto Patronum";
    }
}
