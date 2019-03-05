import java.util.ArrayList;
import java.util.Arrays;

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
        parseArgs(args);
        if (fr == null)
            return;
        Program program = new Program();
        program.Start(fr, co);
    }

    static FruitReader fr = null;
    static Convertable co = new ConvertRAW();

    public static void parseArgs(String[] args) {
        if (args.length == 0) {
            ShowManual();
            return;
        }
        ArrayList<String> params = new ArrayList<String>();
        for (String arg : args) {
            if (arg.startsWith("-")) {
                create(params);
                params = new ArrayList<String>();
            }
            params.add(arg);
        }
        create(params);
    }

    public static void create(ArrayList<String> params) {
        if (params.size() == 0)
            return;
        if (params.size() == 2 && params.get(0).equals("-file")) {
            fr = new FruitReaderFile(params.get(1));
            return;
        }
        if (params.size() == 1 && params.get(0).equals("-scan")) {
            fr = new FruitReaderScan();
            return;
        }
        if (params.size() >= 1 && params.get(0).equals("-data")) {
            fr = new FruitReaderStringArray(params.subList(1, params.size()));
            return;
        }
        if (params.size() == 1 && params.get(0).equals("-help")) {
            ShowManual();
            return;
        }
        if (params.size() == 2 && params.get(0).equals("-format")) {
            if (params.get(1).equals("raw"))
                co = new ConvertRAW();
            else if (params.get(1).equals("xml"))
                co = new ConvertXML();
            else if (params.get(1).equals("json"))
                co = new ConvertJSON();
            return;
        }
    }

    /**
     * Решение основной задачи
     * @param fr - Выбранный класс для считывания начальных данных
     */
    public void Start(FruitReader fr, Convertable co) {
        ArrayList<Fruit> list = fr.read();
        Logic logic = new Logic(list);
        String answer = co.Convert(logic.getTask());
        System.out.println(answer);
    }

    public static void ShowManual() {
        System.out.println("Program: error, no options specified.");
        System.out.println("Usage: java Program [-format json|xml|raw] "
                           + "[-file filename]|[-scan]|[-data data]");
        System.out.println(" -format\t\tUse specified format, default raw");
        System.out.println(" -file filename\tLoad Fruits from text file");
        System.out.println(" -scan \t\t\tLoad Fruits from Standard input");
        System.out.println(" -data FRUIT1..\tLoad list of fruits");
    }
}
