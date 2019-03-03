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
        Convertable co = parseArgsConvert(args);
        FruitReader fr = parseArgsFReader(args);
        if (fr == null)
            return;
        Program program = new Program();
        program.Start(fr, co);
    }

    public static void parseArgs(String[] args) {
        ArrayList<String> params = new ArrayList<String>();
        for (String arg : args) {
            if (arg.startsWith("-")) {
                create(params);
                params = new ArrayList<String>();
            }
            params.add(arg);
        }
    }

    public static void create(ArrayList<String> params) {
    }

    public static Convertable parseArgsConvert(String[] args) {
        return new ConvertRAW();
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

    public static FruitReader parseArgsFReader(String[] args) {
        FruitReader fr = null;
        if (args.length == 2 && args[0].equals("-file"))
            fr = new FruitReaderFile(args[1]);
        else if (args.length == 1 && args[0].equals("-scan"))
            fr = new FruitReaderScan();
        else if (args.length >= 2 && args[0].equals("-data")) {
            String[] arr = Arrays.copyOfRange(args, 1, args.length);
            fr = new FruitReaderStringArray(arr);
        } else
            ShowManual();
        return fr;
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
