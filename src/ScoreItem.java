import java.util.ArrayList;
import java.util.HashMap;

public abstract class ScoreItem {
    protected int score;
    protected String name;

    public ScoreItem(String name){
        this.name = name;
        score = -1;
    }

    public int getScore(HashMap<Integer, Integer> diceResult) { // Have to be overwritten. Interface???
        return 0;
    }

    public void setScore(int score){
        this.score = score;
    }


}
