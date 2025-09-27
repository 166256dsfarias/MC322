import java.util.Arrays;
import java.util.ArrayList;

public class Dementador extends Monstro {
    
    public Dementador() {
        super("Dementador", 100, 15, new VarinhaDasTrevas(), 50, new ArrayList<>());
        
        this.acoes = Arrays.asList(new Expelliarmus(35));
    }
    
    @Override
    public Item droparLoot() {
        return new PocaoDeChocolate();
    }
}