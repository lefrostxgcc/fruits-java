import java.util.List;

/**
 * Создание начальных данных из массива строк
 * @author Chip
 */
public class FruitReaderStringArray extends FruitReaderString {

    /**
     * Инициализация по массиву
     * @param array Массив из строк
     */
    public FruitReaderStringArray(String [] array) {
        super(ArrayToString(array));
    }

    /**
     * Инициализация по списку
     * @param list Список строк
     */
    public FruitReaderStringArray(List<String> list) {
        super(ArrayToString(list.toArray(new String[list.size()])));
    }

    /**
     * Конвертация массива в строку
     * @param array Массив из строк
     * @return Строка из элементов массива, разделённых \n
     */
    protected static String ArrayToString(String [] array) {
        StringBuilder items = new StringBuilder();
        for (String item : array) {
            items.append(item);
            items.append("\n");
        }
        items.append("\n");
        return items.toString();
    }
    
}
