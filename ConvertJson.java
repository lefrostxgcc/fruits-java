import java.util.HashMap;
import java.util.Map;

public class ConvertJson implements Convertable
{
    public String Convert(HashMap<String, String> map) {
        if (map.size() == 0)
            return "{}";
        StringBuilder text = new StringBuilder("{\n");
        for (Map.Entry<String, String> pair : map.entrySet()) {
            text.append("    ");
            text.append("\"");
            text.append(pair.getKey());
            text.append("\": \"");
            text.append(pair.getValue());
            text.append("\",\n");
        }
        return text.substring(0, text.length() - 2) + "\n}";
    }
}
