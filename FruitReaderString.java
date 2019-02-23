import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class FruitReaderString extends FruitReader {

    public FruitReaderString(String input) {
        byte[] byteArray = input.getBytes();
        ByteArrayInputStream bis = new ByteArrayInputStream(byteArray);
        InputStream is = bis;
        InputStreamReader isr = new InputStreamReader(is);
        br = new BufferedReader(isr);
    }
    
}
