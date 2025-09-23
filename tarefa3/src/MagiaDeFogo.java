public class MagiaDeFogo implements AcaoDeCombate {
    @Override
    public void executar(Combatente usuario, Combatente alvo) {
        System.out.println(usuario.getNome() + " lança uma bola de fogo em " + alvo.getNome());
        alvo.receberDano(20);
    }
}
