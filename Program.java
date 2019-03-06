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
        ParamFactory pf = new ParamFactory(args);
        Program program = new Program();
        program.Start(pf);
    }

    /**
     * Решение основной задачи
     * @param pf - Выбранный класс для считывания начальных данных
     */
    public void Start(ParamFactory pf) {
        if (pf.isHelp() || pf.fruitReader() == null || pf.convertable() == null) {
            showManual();
            return;
        }
        ArrayList<Fruit> list = pf.fruitReader().read();
        Logic logic = new Logic(list);
        String answer = pf.convertable().Convert(logic.getTask());
        System.out.println(answer);
    }

    /**
     * Вывести на экран встроенную инструкцию пользователя
     */
    public static void showManual() {
        System.out.println("Usage: java Program [options]");
        System.out.println(" -help \t\t\tShow this help");
        System.out.println(" -scan \t\t\tLoad Fruits from Standard input");
        System.out.println(" -file filename\tLoad Fruits from text file");
        System.out.println(" -data [list]\tLoad inline list of fruits");
        System.out.println(" -format\t\tUse specified output format: raw, xml, json."
                           + " Default raw");
    }
}
