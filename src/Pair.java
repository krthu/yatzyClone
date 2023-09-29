import java.util.HashMap;
import java.util.Map;

public class Pair extends ScoreItem{
    int numberOfPairs;


    public Pair(String name, int numberOfPairs ){
        super(name);
        this.numberOfPairs = numberOfPairs;
    }



    @Override
    public int getScore(HashMap<Integer, Integer> diceResult){
        switch (numberOfPairs){
            case 1 -> {
                int highestScore = 0;
                for(Map.Entry<Integer, Integer> entry: diceResult.entrySet()) {
                    if(entry.getValue() >= 2){
                        int valueOfPair = entry.getKey() * 2;
                        if(valueOfPair > highestScore);
                        highestScore = valueOfPair;
                    }
                }
                return highestScore;
            }
            case 2 ->{ // Tried to make 3 pars work easily if i ever want to add a die. Perhaps refactor this.
                int scorePairOne = 0;
                int scorePairTwo = 0;
                for(Map.Entry<Integer, Integer> entry: diceResult.entrySet()) {
                    if (entry.getValue() >= 2) {
                        int valueOfPair = entry.getKey()*2;
                        if (scorePairOne == 0){
                            scorePairOne = valueOfPair;
                        } else if (scorePairTwo == 0) {
                            scorePairTwo = valueOfPair;
                        }
                    }
                }
                if(scorePairOne != 0 && scorePairTwo !=0){
                    return scorePairOne+scorePairTwo;
                }
            }
        }


        return 0;
    }
}
