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
        // Show initial size
        System.out.println("Initial PQ size: " + pq.getSize() + "\n");

        // Use copy constructor
        PQList pq2 = new PQList(pq);
        System.out.println("Size of PQ2 (Copy Constructor): " + pq2.getSize());

        System.out.println("Displaying PQ2 players:");
        PQList tempPQ2 = new PQList(pq2);
        Player highest2 = tempPQ2.getHighestScorePlayer();
        while (highest2 != null) {
            System.out.println("Name: " + highest2.getName() + ", Score: " + highest2.getScore());
            highest2 = tempPQ2.getHighestScorePlayer();
        }
        System.out.println();

        // Use createClone()
        PQList pq3 = pq.createClone();
        System.out.println("Size of PQ3 (createClone): " + pq3.getSize());

        System.out.println("Displaying PQ3 players:");
        PQList tempPQ3 = new PQList(pq3);
        Player highest3 = tempPQ3.getHighestScorePlayer();
        while (highest3 != null) {
            System.out.println("Name: " + highest3.getName() + ", Score: " + highest3.getScore());
            highest3 = tempPQ3.getHighestScorePlayer();
        }
        System.out.println();

        // Show getHighestScorePlayer() and getSize() in action on the original PQ
        System.out.println("Removing players from original PQ in order of highest score:");
        Player highest = pq.getHighestScorePlayer();
        while (highest != null) {
            System.out.println("Removed -> Name: " + highest.getName() + ", Score: " + highest.getScore());
            System.out.println("Size after removal: " + pq.getSize());
            highest = pq.getHighestScorePlayer();
        }

        // Show size after emptying the queue
        System.out.println("\nFinal size of PQ after removals: " + pq.getSize());

        // Show clear() method works
        pq3.clear();
        System.out.println("Size of PQ3 after clear(): " + pq3.getSize());
        System.out.println("Is PQ3 empty? " + pq3.isEmpty());


    }
}