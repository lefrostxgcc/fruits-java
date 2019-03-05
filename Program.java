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
        ParamFabric pf = new ParamFabric(args);
        Program program = new Program();
        program.Start(pf);
    }

    /**
     * Решение основной задачи
     * @param fr - Выбранный класс для считывания начальных данных
     */
    public void Start(ParamFabric pf) {
        if (pf.showHelp || pf.fruitReader == null || pf.convertable == null) {
            showManual();
            return;
        }
        ArrayList<Fruit> list = pf.fruitReader.read();
        Logic logic = new Logic(list);
        String answer = pf.convertable.Convert(logic.getTask());
        System.out.println(answer);
    }

    public static void showManual() {
        System.out.println("Program: error, no options specified.");
        System.out.println("Usage: java Program [-format json|xml|raw] "
                           + "[-file filename]|[-scan]|[-data data]");
        System.out.println(" -format\t\tUse specified format, default raw");
        System.out.println(" -file filename\tLoad Fruits from text file");
        System.out.println(" -scan \t\t\tLoad Fruits from Standard input");
        System.out.println(" -data FRUIT1..\tLoad list of fruits");
    }
}
