import java.io.InputStreamReader;
import java.io.BufferedReader;

public class FruitReaderScan extends FruitReader {
    public FruitReaderScan() {
        InputStreamReader isr = new InputStreamReader(System.in);
        br = new BufferedReader(isr);
    }
}
