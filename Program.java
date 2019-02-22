import java.io.IOException;
import java.util.ArrayList;

public class Program {
    
    public static void main(String[] args) throws IOException {
        FruitReader fr = new FruitReader();
        String s = "LEMON\nORANGE\nMANDARIN\n\n";
        ArrayList<Fruit> list = fr.readFromString(s);
        int count = list.size();
        System.out.println(count);
    }
    
}
