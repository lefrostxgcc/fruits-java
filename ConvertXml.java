import java.util.HashMap;
import java.util.Map;

public class ConvertXml implements Convertable
{
    public String Convert(HashMap<String, String> map) {
        StringBuilder text = new StringBuilder("<?xml version=\"1.0\">\n");
        text.append("<XML>\n");
        for (Map.Entry<String, String> pair : map.entrySet()) {
            text.append("    <");
            text.append(pair.getKey());
            text.append(">");
            text.append(pair.getValue());
            text.append("<");
            text.append(pair.getKey());
            text.append(">\n");
        }
        text.append("</XML>");
        return text.toString();
    }
}
