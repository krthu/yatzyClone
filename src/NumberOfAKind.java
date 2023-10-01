
import java.util.HashMap;
import java.util.Map;

public class NumberOfAKind extends ScoreItem{
    int numberItHasToBe;  // If number just have to be a 1 or 2....
    int timesNrAppears;           // Looking for 3 of a kind, 4 of a kind.....
    public NumberOfAKind(String name, int numberItHasToBe, int timesNrAppears){
        super(name);
        this.numberItHasToBe = numberItHasToBe;
        this.timesNrAppears = timesNrAppears;

    }

    @Override
    public int getPossibleScore(HashMap<Integer, Integer> diceResult){
        int numberOfDiceForYatzy = 5;
        if(timesNrAppears == 0){
            if(diceResult.containsKey(numberItHasToBe)){
                return (diceResult.get(numberItHasToBe) * numberItHasToBe);
            }
        }else{
            for(Map.Entry<Integer, Integer> entry: diceResult.entrySet()){
                if(entry.getValue() == numberOfDiceForYatzy && timesNrAppears == numberOfDiceForYatzy){
                    return 50;
                } else if (entry.getValue() >= timesNrAppears){
                    return entry.getKey()*timesNrAppears;

                }
            }
        }

        return 0;
    }



    public String toString(){
        return "Name:" + name + " Score: " + score + " Has to be: " + numberItHasToBe + " TimesHasToAppear: " + timesNrAppears;
    }

}
