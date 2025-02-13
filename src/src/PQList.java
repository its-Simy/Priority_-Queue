public class PQList implements PriorityQueue {

    /**
     *All the data members needed
     */
    private Node head;
    private Node temp;
    private Node tail;
    private int counter;

    /**
     *Default Constructor that instantiates an empty linked list
     */
    public PQList() {
        head = null;
        temp = null;
        tail = null;
        counter = 0;
    }

    /**
     *Copy constructor
     */
    public PQList(PQList copy) {
        this.head = null;
        this.tail = null;
        this.counter = 0;
        //if its empty it will just return nothing
        if (copy.head == null) {
            return;
        }
        //sets to the beginning of the linked list
        Node tracker = copy.head;
        while (tracker.next != null) {

            Player copyied_player = tracker.player.createClone();

            this.add(copyied_player);
            tracker = tracker.next;
        }

    }

    /**
     *Will make a new node and add it to the end of the linked list
     */
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

    /**
     *Searches and returns person with the highest score and removes them from the queue
    */
    @Override
    public Player getHighestScorePlayer() {
        //First checks if the Queue is empty
        if (isEmpty()) {
            return null;
        }
        //next it begins to iterate through the linked list to find the highest score
        else{
            Player highest = head.getPlayer();
            temp = head.next;
            while(temp != null) {
                if(highest.getScore() < temp.getPlayer().getScore()) {
                    highest = temp.getPlayer();
                }
                temp = temp.next;
            }
            //Makes a deep copy of the highest found node
            Player deep_copy = highest.createClone();


            //if the first person in the list has the highest score, it sets the head to the next node
            if(deep_copy.equals(head.getPlayer())) {
                head = head.next;
            }

            //if the last person in the list has the highest score it will iterate through the list again and keep track of the node before it in order to set it as the new tail
            if(deep_copy.equals(tail.getPlayer())) {
                Node previous = null;
                temp = head;

                while(temp.next != null) {
                    previous = temp;
                    temp = temp.next;
                }

                if(previous != null) {
                    previous.next = null;
                    tail = previous;
                }
            }
            //Will go to the highest node in the linked list, then will keep track as the previous. It will then move the pointer to the node after the highest
            else{
                Node previous = head;
                Node temp = head.next;
                while(temp != null) {
                    if(deep_copy.equals(temp.getPlayer())) {
                        previous.next = temp.next;
                        break;
                    }
                    previous = temp;
                    temp = temp.next;
                }
            }

            counter--;
            return highest;
        }
    }

    /**
     *Changing the head and tail to null would cause all the elements from the list to get garbage collected
     */
    @Override
    public void clear() {
        head = null;
        tail = null;
        counter = 0;
    }

    /**
     *Returns the number of elements in the linked list
     */
    @Override
    public int getSize() {
        return counter;
    }

    /**
     *If there is no items in the head or the tail, then the function should return true
     */
    @Override
    public boolean isEmpty() {
        return (head == null && tail == null);
    }


}

