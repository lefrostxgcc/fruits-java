import java.util.ArrayList;

/**
 * Фабрика парсинга параметров командной строки.
 * Цель фабрики - создание объектов
 * FruitReader и Convertable.
 * @author Chip
 */
public class ParamFactory {
    
    private FruitReader fruitReader = null;
    private Convertable convertable = new ConvertRaw();
    private boolean isHelp = false;

    public FruitReader fruitReader() { return fruitReader; }
    public Convertable convertable() { return convertable; }
    public boolean isHelp() {return isHelp; }

    /**
     * Инициализация и запуск фабрики.
     * @param args аргументы командной строки.
     */
    public ParamFactory(String[] args) {
        if (args.length == 0) {
            isHelp = true;
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

    /**
     * Создание объектов по подсписку аргументов.
     * @param params нулевой параметр с дефисом - определяет опцию
     *  последующие параметры - настрока выбранной опции
     */
    public void create(ArrayList<String> params) {
        if (params.size() == 0)
            return;
        if (params.size() == 2 && params.get(0).equals("-file")) {
            fruitReader = new FruitReaderFile(params.get(1));
            return;
        }
        if (params.size() == 1 && params.get(0).equals("-scan")) {
            fruitReader = new FruitReaderScan();
            return;
        }
        if (params.size() >= 1 && params.get(0).equals("-data")) {
            fruitReader = new FruitReaderStringArray(params.subList(1, params.size()));
            return;
        }
        if (params.size() == 1 && params.get(0).equals("-help")) {
            isHelp = true;
            return;
        }
        if (params.size() == 2 && params.get(0).equals("-format")) {
            convertable = createConvertable(params.get(1).toString());
            return;
        }
    }

    /**
     * Минифабрика для объекта Convertable.
     * @param format название формата вывода данных
     * @return созданный объект
     */
    public Convertable createConvertable(String format) {
        if (format.equals("raw"))
            return new ConvertRaw();
        else if (format.equals("xml"))
            return new ConvertXml();
        else if (format.equals("json"))
            return new ConvertJson();
        return new ConvertRaw();
    }
}
