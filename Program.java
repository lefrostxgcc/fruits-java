import java.util.ArrayList;

/**
 * Проект - Дед Мороз.
 * Демонстрация ОО возможностей
 * на примере решения конкретной задачи
 * @author Chip
 */
public class Program {

    /**
     * Точка входа - запуск программы.
     * @param args - Начальные данные могут быть
     * переданы параметрами командной строки.
     */
    public static void main(String[] args) {
        FruitReader fr = new FruitReaderFile("fruits.txt");
        Program program = new Program();
        program.Start(fr);
    }

    /**
     * Решение основной задачи
     * @param fr - Выбранный класс для считывания начальных данных
     */
    public void Start(FruitReader fr) {
        ArrayList<Fruit> list = fr.read();
        int count = list.size();
        System.out.println(count);
    }
    
}
