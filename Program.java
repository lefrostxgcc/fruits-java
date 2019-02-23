import java.util.ArrayList;

public class Program {
    
    public static void main(String[] args) {
        FruitReader fr = new FruitReaderFile("fruits.txt");
        Program program = new Program();
        program.Start(fr);
    }

    public void Start(FruitReader fr) {
        ArrayList<Fruit> list = fr.read();
        int count = list.size();
        System.out.println(count);
    }
    
}
