import java.util.ArrayList;

public class Fase {
    protected int nivel;
    protected String ambiente;
    protected ArrayList<Monstro> lista_monstros;
    //construtor
    public Fase(int nivel, String ambiente, ArrayList<Monstro> lista_monstros){
        this.nivel = nivel;
        this.ambiente = ambiente;
        this.lista_monstros = lista_monstros;
    }


}
