import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;

public class Logic {
 
    public enum Task {
        COUNT,
        DIFFCOUNT,
        HASHCOUNT,
        FRUITMAX;
    }

    ArrayList<Fruit> list;
    
    public Logic(ArrayList<Fruit> list) {
        this.list = list;
    }

    public HashMap<String, String> getTask() {
        HashMap<String, String> map = new HashMap<String, String>();
        for (Task task : Task.values())
            map.put("" + task, getTask(task));
        return map;
    }

    public String getTask(Task task) {
        String answer = "";
        switch (task) {
        case COUNT: answer += getCount(); break;
        case DIFFCOUNT: answer += getDiffCount(); break;
        case HASHCOUNT: answer += getHashCount(); break;
        case FRUITMAX: answer += getFruitMax(); break;
        default: answer += "unknown"; break;
        }
        return answer;
    }

    public int getCount() {
        int count = list.size();
        return count;
    }

    public int getDiffCount() {
        int count = 0;
        for (Fruit fruit : Fruit.values())
            if (getFruitCount(fruit) > 0)
                count++;
        return count;
    }

    public int getHashCount() {
        HashSet<Fruit> set = new HashSet<Fruit>();
        for (Fruit fruit : list)
            set.add(fruit);
        return set.size();
    }

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

    public int getFruitCount(Fruit find) {
        int count = 0;
        for (Fruit fruit : list)
            if (fruit == find)
                count++;
        return count;
    }
    
}
