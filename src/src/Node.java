public class Node {
    Player player;
    Node next; // will point at the following element in the linked list

    /**
     * Instantiates the node with the player data
     */
    public Node(Player player) {
        this.player = player;
    }

    /**
     * This is a getter that returns the player information
     */
    public Player getPlayer() {
        return player;
    }

}