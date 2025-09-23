public class AtaqueFisico implements AcaoDeCombate {
    @Override
    public void executar(Combatente usuario, Combatente alvo) {
        System.out.println(usuario.getNome() + " ataca " + alvo.getNome());
        alvo.receberDano(10);
    }
}