public class HabilidadeDeMagia implements AcaoDeCombate {

    @Override
    public void executar(Combatente usuario, Combatente alvo) {
        System.out.println(usuario.getNome() + " usa magia contra " + alvo.getNome());
        int danoMagico = (int)(((Personagem) usuario).forca * 1.5); // exemplo de dano mágico
        alvo.receberDano(danoMagico);
    }
}