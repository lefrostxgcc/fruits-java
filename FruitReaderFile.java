import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * Считывание данных из текстового файла
 * @author Chip
 */
public class FruitReaderFile extends FruitReader {

    /**
     * Подготовка к считыванию из файла.
     * @param filename Имя файла
     */
    public FruitReaderFile(String filename) {
        try {
            FileReader fr = new FileReader(filename);
            br = new BufferedReader(fr);
        } catch (IOException e) {
            br = null;
        }
    }

}
