import java.util.ArrayList;
import java.util.HashMap;

public class Player {
    private String name;
    private ArrayList<Die> dice;

    private int score;

    private ArrayList<ScoreItem> scoreBoard;

    public Player(String name, int numberOfDice){
        this.name = name;
        this.dice = new ArrayList<>();
        for (int i = 0; i <  5; i ++){
            dice.add(new Die(6));
        }
    }

    public ArrayList<ScoreItem> getScoreBoard() {
        return scoreBoard;
    }

    public void setScoreBoard(ArrayList<ScoreItem> scoreBoard) {
        this.scoreBoard = scoreBoard;
    }

    public ArrayList<Die> getDice() {
        return dice;
    }

    public void rollAllDice(){
        for (Die die: dice) {
            if(!die.isHeld()){
                die.roll();
            }
        }
    }

    public HashMap<Integer,Integer> getDiceResult(){
        HashMap<Integer, Integer> diceResult = new HashMap<>();
        for (Die die: dice) {
            if(diceResult.containsKey(die.getCurrentValue())){
                int value = diceResult.get(die.getCurrentValue());
                diceResult.put(die.getCurrentValue(), value+1);
            }else{
                diceResult.put(die.getCurrentValue(), 1);
            }
        }

        return diceResult;
    }

    public void getListOfPossibleScores(){
        for (ScoreItem item: scoreBoard) {
            if(item.score == 0) {
                System.out.println(item.name + " " + item.getScore(getDiceResult()));
            }
        }
    }


}
