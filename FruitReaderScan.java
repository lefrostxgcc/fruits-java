import java.io.InputStreamReader;
import java.io.BufferedReader;

/**
 * Считывание с клавиатуры
 * @author Chip
 */

/**
 * Инициализация потока для считывания со стандартного ввода.
 */
public class FruitReaderScan extends FruitReader {
    public FruitReaderScan() {
        InputStreamReader isr = new InputStreamReader(System.in);
        br = new BufferedReader(isr);
    }
}
