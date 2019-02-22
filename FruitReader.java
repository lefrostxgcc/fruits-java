import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.io.FileReader;

public class FruitReader {

    public ArrayList<Fruit> read() {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        return read(br);
    }

    public ArrayList<Fruit> read(String filename) throws IOException {
        FileReader fr = new FileReader(filename);
        BufferedReader br = new BufferedReader(fr);
        return read(br);
    }
    
    public ArrayList<Fruit> read(BufferedReader br) {
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
        return list;
    }
    
}
