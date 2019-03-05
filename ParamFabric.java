import java.util.ArrayList;
import java.util.Arrays;

public class ParamFabric {
    
    public FruitReader fruitReader = null;
    public Convertable convertable = new ConvertRAW();
    public boolean showHelp = false;

    public ParamFabric(String[] args) {
        if (args.length == 0) {
            showHelp = true;
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
            showHelp = true;
            return;
        }
        if (params.size() == 2 && params.get(0).equals("-format")) {
            convertable = createConvertable(params.get(1).toString());
            return;
        }
    }

    public Convertable createConvertable(String format) {
        if (format.equals("raw"))
            return new ConvertRAW();
        else if (format.equals("xml"))
            return new ConvertXML();
        else if (format.equals("json"))
            return new ConvertJSON();
        return new ConvertRAW();
    }
}
