import java.util.HashMap;
import java.util.Map;

/**
 * Вывод результата в "сыром" виде,
 * в многострочном формате аля
 * task=answer
 * @author Chip
 */
public class ConvertRaw implements Convertable {
    public String Convert(HashMap<String, String> map) {
        StringBuilder text = new StringBuilder();
        for (Map.Entry<String, String> pair : map.entrySet()) {
            text.append(pair.getKey());
            text.append("=");
            text.append(pair.getValue());
            text.append("\n");
        }
        return text.toString();
    }
}
