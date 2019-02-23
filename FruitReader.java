import java.io.BufferedReader;
import java.util.ArrayList;

/**
 * Базовый класс для считывания списка фруктов.
 * Содержит основной метод для получения списка из BufferedReader потока.
 * @author Chip
 */

public class FruitReader {

    /** Поток источника данных */
    protected BufferedReader br = null;

    /**
     * Считывает данные из потока
     * @return сформированный список фруктов
     */
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
