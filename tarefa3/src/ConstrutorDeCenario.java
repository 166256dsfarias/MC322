import java.util.ArrayList;
import java.util.Random;

public class ConstrutorDeCenario {
    private static ArrayList<Arma> listaArmas(Arma arma) {
        ArrayList<Arma> armas = new ArrayList<>();
        armas.add(arma);
        return armas;
    }
    public static ArrayList<Fase> gerarFases(int nFases){
        ArrayList<Fase> fases = new ArrayList<Fase>(nFases); //lista de fases
        ArrayList<String> ambientes = new ArrayList<>(); //lista de ambientes
        //adicionar ambientes na lista
        ambientes.add("Floresta Proibida");
        ambientes.add("Salão Principal");
        ambientes.add("Cabana do Hagrid"); 
        ambientes.add("Campo de Quadribol");
        ambientes.add("Sala Precisa");
        Random random = new Random(); //geracao de numero aleatorio

        for(int i = 0; i <= nFases; i++){
            String ambiente = ambientes.get(random.nextInt(ambientes.size())); //seleciona um abiente aleatorio da lista
            ArrayList<Monstro> lista_monstros = new ArrayList<>(); //cria lista de monstro diferente para cada fase
            if(i == 0){
                lista_monstros.add(new ComensalDaMorte("Belatrix Lestrange", 100, 30, new VarinhaDeAzevinho(), 100, listaArmas(new VarinhaDeAzevinho()), 5));
                lista_monstros.add(new ComensalDaMorte("Lucio Malfoy", 70, 15, new VarinhaDeCarvalho(), 50, listaArmas(new VarinhaDeCarvalho()), 2));
            }
            else if(i == 1){
                lista_monstros.add(new ComensalDaMorte("Draco Malfoy", 80, 20, new VarinhaDeSabugueiro(), 100, listaArmas(new VarinhaDeSabugueiro()), 5));
                lista_monstros.add(new Dementador("Dementador", 50, 10, new VarinhaDeAzevinho(), 80, listaArmas(new VarinhaDeAzevinho())));
            }
            if(i == 2){
                lista_monstros.add(new ComensalDaMorte("Lord Voldemort", 150, 50, new VarinhaDasVarinhas(), 200, listaArmas(new VarinhaDasVarinhas()), 10));
            }

            Fase fase = new Fase(i+1, ambiente, lista_monstros);
            fases.add(fase);
        }
        return fases;
    }
}
