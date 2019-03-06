import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;

/**
 * Основной модуль по решению всех задач.
 * Каждый метод решает одну задачу.
 * @author Chip
 */

public class Logic {

    /** Список всех решаемых задач */
    public enum Task {
        COUNT,
        DIFFCOUNT,
        HASHCOUNT,
        FRUITMAX;
    }
    
    /** Исходные данные */
    ArrayList<Fruit> list;

    /**
     * Инициализация класса с исходными данными
     * @param list Список
     */
    public Logic(ArrayList<Fruit> list) {
        this.list = list;
    }

    /**
     * Вычисление всех задач.
     * Ответ формируется в виде словаря.
     * @return Словарь с результатами расчетов
     */
    public HashMap<String, String> getTask() {
        HashMap<String, String> map = new HashMap<String, String>();
        for (Task task : Task.values())
            map.put("" + task, getTask(task));
        return map;
    }

    /**
     * Задача - вычисление указанной задачи.
     * @param task Название задачи
     * @return Ответ в виде строки
     */
    public String getTask(Task task) {
        StringBuilder answer = new StringBuilder();
        switch (task) {
        case COUNT: answer.append(getCount()); break;
        case DIFFCOUNT: answer.append(getDiffCount()); break;
        case HASHCOUNT: answer.append(getHashCount()); break;
        case FRUITMAX: answer.append(getFruitMax()); break;
        default: answer.append("unknown"); break;
        }
        return answer.toString();
    }

    /**
     * Задача - вычисление количества фруктов.
     * @return Целое число - количество фруктов
     */
    public int getCount() {
        int count = list.size();
        return count;
    }

    /**
     * Задача - вычисление количества различных фруктов.
     * Сложность алгоритма - O(N * N)
     * @return Целое число - количество разных фруктов
     */
    public int getDiffCount() {
        int count = 0;
        for (Fruit fruit : Fruit.values())
            if (getFruitCount(fruit) > 0)
                count++;
        return count;
    }

    /**
     * Задача - вычисление количества различных фруктов.
     * Сложность алгоритма - O(N * log N)
     * @return Целое число - количество разных фруктов
     */
    public int getHashCount() {
        HashSet<Fruit> set = new HashSet<Fruit>();
        for (Fruit fruit : list)
            set.add(fruit);
        return set.size();
    }

    /**
     * Задача - какого фрукты было больше всего.
     * @return константа фрукта, которого было больше всего
     */
    public Fruit getFruitMax() {
        int max = 0;
        Fruit fruitMax = null;
        for (Fruit fruit : Fruit.values()) {
            int count = getFruitCount(fruit);
            if (count > max) {
                max = count;
                fruitMax = fruit;
            }
        }
        return fruitMax;
    }
    
    /**
     * Подзадача - сколько всего указанных фруктов
     * @param find какой фрукт искать
     * @return целое число - сколько этих фруктов
     */
    public int getFruitCount(Fruit find) {
        int count = 0;
        for (Fruit fruit : list)
            if (fruit == find)
                count++;
        return count;
    }
    
}
