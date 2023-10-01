import java.util.ArrayList;
import java.util.HashMap;

public class Player {
    private String name;
    private ArrayList<Die> dice;

    private int score;

    private ArrayList<ScoreItem> scoreBoard;

    public Player(String name, int numberOfDice, ArrayList<ScoreItem> scoreBoard){
        this.name = name;
        this.dice = new ArrayList<>();
        for (int i = 0; i <  numberOfDice; i ++){
            dice.add(new Die(6));
        }
        this.scoreBoard = scoreBoard;
    }

    public int getScore() {
        return score;
    }

    public ArrayList<ScoreItem> getScoreBoard() {
        return scoreBoard;
    }

    public String getName() {
        return name;
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

    public void setTotalScore() {
        int scoreForBonus = 63;
        int bonus = 50;
        int sum = 0;
        for (ScoreItem item: scoreBoard) {
            if(item.score != -1){
                sum += item.score;
                if (item.name.equalsIgnoreCase("6:s")){
                    if (sum > scoreForBonus){
                        sum += bonus;
                    }
                }
            }
        }
        score = sum;
    }

    public void removeHeldFromAllDice(){
        for (Die die:dice) {
            die.setHeld(false);
        }
    }

    public boolean addScoreToScoreBoard(int indexOfScoreItem){
        ScoreItem item = scoreBoard.get(indexOfScoreItem);
        if (item.score == -1){
            item.setScore(item.getPossibleScore(getDiceResult()));
            return true;
        }
        return false;
    }

    public void printCurrentScoreBoard(){
        for (ScoreItem item: scoreBoard) {
            System.out.println(item.name + " " + (item.score == -1 ? "": item.score));
        }
    }





//    public void getListOfPossibleScores(){
//
//        for (ScoreItem item: scoreBoard) {
//            if(item.score == 0) {
//                System.out.println(item.name + " "  + item.getScore(getDiceResult()));
//            }
//        }
 //   }


}
