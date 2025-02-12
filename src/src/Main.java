import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        PQList pq = new PQList();

        try {
            FileReader fileReader = new FileReader("info.txt");
            Scanner infile = new Scanner(fileReader);
            int counter = 0;
            String name;
            int score;


            while(infile.hasNextLine()) {
                name = infile.nextLine();
                counter++;
                if(counter % 2 != 0){
                    score = Integer.parseInt(infile.nextLine());
                    counter++;
                    Player p = new Player(name, score);
                    pq.add(p);
                }
            }
            infile.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println(pq.getSize() + "\n");

        Player highest = pq.getHighestScorePlayer();

        System.out.println("The player with the highest score is " + highest.getName() + "\n"
                + "With the score of " + highest.getScore() + "\n");

        System.out.println(pq.getSize());
    }
}