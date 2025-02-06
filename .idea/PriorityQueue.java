public interface PriorityQueue {

    //adds player to the priority queue
    public void add(Player a);

    //returns the player with the highest score
    public Player getHighestScorePlayer();

    //This shoudl clear all of the players from teh priority queue
    public void clear();


    //returns the number of players stored in the priority
    public int getSize();


    //Returns true if the priority queue is empty
    public boolean isEmpty();

}