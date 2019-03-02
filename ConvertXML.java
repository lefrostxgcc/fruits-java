import java.util.HashMap;
import java.util.Map;

public class ConvertXML implements Convertable
{
    public String Convert(HashMap<String, String> map) {
        String text = "<?xml version=\"1.0\">\n<XML>\n";
        for (Map.Entry<String, String> pair : map.entrySet())
            text +=
                "    <" + pair.getKey() + ">"
                + pair.getValue()
                + "</" + pair.getKey() + ">\n";
        text += "</XML>";
        return text;
    }
}
