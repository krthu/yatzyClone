import javax.xml.namespace.QName;
import java.util.ArrayList;
import java.util.HashMap;

public class NumberOfAKind extends ScoreItem{
    int numberItHasToBe;  // If number just have to be a 1 or 2....
    int timesNrAppears;           // Lokking for 3 of a kind 4 of a kind.....
    public NumberOfAKind(String name, int numberItHasToBe, int timesNrAppears){
        super(name);
        this.numberItHasToBe = numberItHasToBe;
        this.timesNrAppears = timesNrAppears;
    }

    @Override
    public int getScore(HashMap<Integer, Integer> diceResult){
        if(timesNrAppears == 0){
            if(diceResult.containsKey(numberItHasToBe)){
                return (diceResult.get(numberItHasToBe) * numberItHasToBe);
            }
        }
        return 0;
    }

    public String toString(){
        return "Name:" + name + " Score: " + score + " Has to be: " + numberItHasToBe + " TimesHasToAppear: " + timesNrAppears;
    }

}
