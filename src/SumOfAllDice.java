import java.util.HashMap;
import java.util.Map;

public class SumOfAllDice extends ScoreItem{



    public SumOfAllDice(String name){
        super(name);

    }

    @Override
    public int getScore(HashMap<Integer, Integer> diceResult){
        switch (name.toLowerCase()){
            case "small straight" -> {
                if(diceResult.size() != 5 || !diceResult.containsKey(6)){
                    return 0;
                }
            }
            case "large straight" ->{
                if(diceResult.size() != 5 || !diceResult.containsKey(1)){
                    return 0;
                }
            }
            case "full house" -> {
                if(diceResult.size() != 2){
                    return 0;
                }
            }
            default -> {

            }
        }
        int sumOfDice = 0;
        for(Map.Entry<Integer, Integer> entry: diceResult.entrySet()){
            sumOfDice +=  entry.getKey()* entry.getValue();
        }
        return sumOfDice;
    }



}
