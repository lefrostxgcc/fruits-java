import java.util.HashMap;

/**
 * Интерфейс для конвертации результата
 * в любой подходящий формат
 * @author Chip
 */
public interface Convertable
{
    /**
     * Конвертация результатов из словаря в строку
     * по определённому в реализации формату.
     * @param map словарь с результатами
     * @return строка в определённом формате.
     */
    String Convert(HashMap<String, String> map);
}
