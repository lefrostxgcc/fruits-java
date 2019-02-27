import java.util.ArrayList;

public class Logic {

    ArrayList<Fruit> list;
    
    public Logic(ArrayList<Fruit> list) {
        this.list = list;
    }

    public int getCount() {
        int count = list.size();
        return count;
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
