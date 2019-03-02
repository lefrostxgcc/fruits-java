import java.util.HashMap;
import java.util.Map;

public class ConvertRAW implements Convertable
{
    public String Convert(HashMap<String, String> map) {
        String text = "";
        for (Map.Entry<String, String> pair : map.entrySet())
            text += pair.getKey() + "=" + pair.getValue() + "\n";
        return text;
    }
}
