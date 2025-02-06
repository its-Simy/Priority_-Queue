import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        try {
            FileReader fileReader = new FileReader("info.txt");
            Scanner infile = new Scanner(fileReader);
            String line;

            while(infile.hasNextLine()) {
                line = infile.nextLine();
                System.out.println(line);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}