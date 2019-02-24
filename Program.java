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
        if (args.length == 0) {
            ShowManual();
            return;
        }
        FruitReader fr = null;
        if (args[0].equals("-file"))
            fr = new FruitReaderFile(args[1]);
        else if (args[0].equals("-scan"))
            fr = new FruitReaderScan();
        else if (args[0].equals("-data"))
            fr = new FruitReaderString(args[1] + "\n\n");
        if (fr == null) {
            ShowManual();
            return;
        }
        Program program = new Program();
        program.Start(fr);
    }

    public static void ShowManual() {
        System.out.println("Program: error, no options specified.");
        System.out.println("Usage: java Program, [options] [data]");
        System.out.println(" -file filename\tLoad Fruits from text file");
        System.out.println(" -scan \t\t\tLoad Fruits from Standard input");
        System.out.println(" -data FRUIT1\tLoad one fruit");
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
