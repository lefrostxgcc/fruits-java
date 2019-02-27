/**
 * Создание начальных данных из массива строк
 * @author Chip
 */
public class FruitReaderStringArray extends FruitReaderString {

    /**
     * Конструктор
     * @param array массив из строк
     */
    public FruitReaderStringArray(String [] array) {
        super(ArrayToString(array));
    }

    /**
     * Конвертация массива в строку
     * @param array Массив из строк
     * @return Строка из элементов массива, разделённых \n
     */
    protected static String ArrayToString(String [] array) {
        String items = "";
        for (String item : array)
            items += item + "\n";
        items += "\n";
        return items;
    }
    
}
