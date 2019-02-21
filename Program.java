import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.ArrayList;

public class Program {
    
    public static void main(String[] args) {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        ArrayList<Fruit> list = new ArrayList<Fruit>();
        while (true) {
            String line;
            try {
                line = br.readLine();
            } catch (Exception e) {
                line = "";
            }
            if (line.equals(""))
                break;
            Fruit fruit = Fruit.getFruit(line);
            if (fruit == null)
                continue;
            list.add(fruit);
        }
        int count = list.size();
        System.out.println(count);
    }
    
}
