import java.util.HashMap;
import java.util.Map;

public class ConvertJSON implements Convertable
{
    public String Convert(HashMap<String, String> map) {
        if (map.size() == 0)
            return "{}";
        String text = "{\n";
        for (Map.Entry<String, String> pair : map.entrySet())
            text +=
                "    \"" + pair.getKey() + "\": \""
                + pair.getValue() + "\",\n";
        text = text.substring(0, text.length() - 2) + "\n}";
        return text;
    }
}
