import java.io.BufferedReader;
import java.util.ArrayList;

public class FruitReader {

    protected BufferedReader br = null;
    
    public final ArrayList<Fruit> read() {
        ArrayList<Fruit> list = new ArrayList<Fruit>();
        if (br == null)
            return list;
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
        return list;
    }
    
}
