import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class FruitReaderFile extends FruitReader {
    
    public FruitReaderFile(String filename) {
        try {
            FileReader fr = new FileReader(filename);
            br = new BufferedReader(fr);
        } catch (IOException e) {
            br = null;
        }
    }

}
