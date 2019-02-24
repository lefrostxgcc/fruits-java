/**
 * Список всех допустимых наименований
 * фруктов в мешке Деда Мороза.
 * @author Chip
 */

public enum Fruit {
    LEMON,
    ORANGE,
    MANDARIN,
    FERRARI,
    TESLA,
    RENAULT,
    MERCEDES,
    BMW;

    /**
     * Получить экземпляр фрукта по заданной строке
     * @param line Полученная на вход строка
     * @return Если получилось распознать фрукт - экземпляр Fruit
     * Иначе - значение null.
     */
    public static Fruit getFruit(String line) {
        try {
            return Fruit.valueOf(line);
        } catch (Exception e) {
            return null;
        }
    }
}
