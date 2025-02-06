public class PQList implements PriorityQueue {

    //data members needed
    private Node head;
    private Node temp;
    private Node tail;
    private int counter;


    public PQList() {
        head = null;
        temp = null;
        tail = null;
    }

    public boolean enqueue(Node node) {
        if (head == null) {
            head = node;
        }
        else {
            tail.next = node;
            tail = node;
        }
        return true;
    }

    //will make a new node and add it to the end of the linked list
    @Override
    public void add(Player a) {
        Node new_node = new Node(a);

        // If queue is empty, the new node is both the head and tail
        if (isEmpty()) {
            head = new_node;
            tail = new_node;
            counter++;
            return;
        }
        // Add the new node at the end of the queue and changes the rear to the new node
        counter++;
        tail.next = new_node;
        tail = new_node;
    }

    //returns person with the highest score and removes them from the queue
    @Override
    public Player getHighestScorePlayer() {
        if (isEmpty()) {
            return null;
        }
        else{
            Player highest = head.getPlayer();
            head = head.next;
            counter--;
            return highest;
        }
    }

    //changing the head and tail to null would cause all the elements from the list to get garbage collected
    @Override
    public void clear() {
        head = null;
        tail = null;
        counter = 0;
    }

    //returns the number of elements in the linked list
    @Override
    public int getSize() {
        return counter;
    }

    //if there is no items in the head or the tail, then the function should return true
    @Override
    public boolean isEmpty() {
        return head == null && tail == null;
    }


}
