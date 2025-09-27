public class AvadaKedavra implements AcaoDeCombate {
    private int poder;

    public AvadaKedavra(int poder) {
        this.poder = poder;
    }

    @Override
    public void executar(Combatente usuario, Combatente alvo) {
        System.out.println(usuario.getNome() + " grita: AVADA KEDAVRA!");
        alvo.receberDano(poder);
    }

    @Override
    public String getDescricao() {
        return "Avada Kedavra";
    }
}
