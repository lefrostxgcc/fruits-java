import java.util.ArrayList;
import java.util.HashSet;

public class Logic {

    public enum Task {
        COUNT,
        DIFFCOUNT,
        SETCOUNT,
        FRUITMAX;
    }

    ArrayList<Fruit> list;
    
    public Logic(ArrayList<Fruit> list) {
        this.list = list;
    }

    public String getTaskXML() {
        String xml = "<?xml version=\"1.0\">\n<TASKS>\n";
        for (Task task : Task.values())
            xml += "    <" + task + ">" + getTask(task) + "</" + task + ">\n" ;
        xml += "</TASKS>";
        return xml;
    }

    public String getTaskJSON() {
        String json = "{\n";
        for (Task task : Task.values())
            json += "    \"" + task + "\": \"" + getTask(task) + "\",\n";
        json = json.substring(0, json.length() - 2);
        json += "\n}";
        return json;
    }
    
    public String getTaskRAW() {
        String answer = "";
        for (Task task : Task.values())
            answer += task + "=" + getTask(task) + "\n";
        return answer;
    }

    public String getTask(Task task) {
        String answer = "";
        switch (task) {
        case COUNT: answer += getCount(); break;
        case DIFFCOUNT: answer += getDiffCount(); break;
        case SETCOUNT: answer += getSetCount(); break;
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

    public int getSetCount() {
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
