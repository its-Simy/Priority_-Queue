public class Player{

    private int score;
    private String name;

    //Default Contstructor
    public Player(){
        name = "Simon";
        score = 10;
    }

    //Constructor that takes all the proper parameters
    public Player(String _name, int _score){
        this.name = _name;
        this.score = _score;
    }

    //Copy Constructor
    public Player(Player copy){
        this.name = copy.name;
        this.score = copy.score;
    }

    public int getScore() {
        return score;
    }
    public void setScore(int _score) {
        score = _score;
    }
    public String getName() {
        return name;
    }
    public void setName(String _name) {
        this.name = _name;
    }

    public Player createClone(){
        Player clone = new Player(this);
        return clone;
    }

    /**
     *create the overrride method
     * BUT, is not working to do it properly
     */

}