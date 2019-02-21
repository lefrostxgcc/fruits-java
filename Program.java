import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.ArrayList;

public class Program {
    
    public static void main(String[] args) {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        ArrayList<String> list = new ArrayList<String>();
        while (true) {
            String line;
            try {
                line = br.readLine();
            } catch (Exception e) {
                line = "";
            }
            if (line.equals(""))
                break;
            list.add(line);
        }
        int count = list.size();
        System.out.println(count);
    }
    
}
