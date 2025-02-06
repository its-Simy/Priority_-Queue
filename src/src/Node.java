public class Node {
    Player player;
    Node next; // will point at the following element in the linked list

    public Node(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

}