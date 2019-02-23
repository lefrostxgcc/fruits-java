import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;

/**
 * Считывание данных из строки символов
 * @author Chip
 */
public class FruitReaderString extends FruitReader {

    /**
     * Формирование потока на основе строки данных
     * @param input строка символов с исходными данными
     */
    public FruitReaderString(String input) {
        byte[] byteArray = input.getBytes();
        ByteArrayInputStream bis = new ByteArrayInputStream(byteArray);
        InputStream is = bis;
        InputStreamReader isr = new InputStreamReader(is);
        br = new BufferedReader(isr);
    }
    
}
