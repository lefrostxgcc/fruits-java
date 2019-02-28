import java.util.ArrayList;
import java.util.HashSet;

public class Logic {

    ArrayList<Fruit> list;
    
    public Logic(ArrayList<Fruit> list) {
        this.list = list;
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
