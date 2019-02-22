import java.io.IOException;
import java.util.ArrayList;

public class Program {
    
    public static void main(String[] args) throws IOException {
        FruitReader fr = new FruitReader();
        ArrayList<Fruit> list = fr.read("fruits.txt");
        int count = list.size();
        System.out.println(count);
    }
    
}
