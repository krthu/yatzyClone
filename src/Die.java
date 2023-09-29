
import java.util.Random;

public class Die {
    private int currentValue;
    private int sides;
    private boolean isHeld;


    public Die(int sides){
        this.sides = sides;
        this.isHeld = false;
    }

    static Random random = new Random();

    public int getSides(){
        return sides;
    }

    public boolean isHeld() {
        return isHeld;
    }

    public void setHeld(Boolean isHeld){
        this.isHeld = isHeld;
    }

    public int getCurrentValue(){
        return currentValue;
    }

    public void roll(){
        currentValue = random.nextInt(sides) + 1;
    }
    public void toogleHeld() {
        isHeld = !isHeld;
    }

    public String toString(){
        return "CurrentValue: " + currentValue + " Sides: " + sides;
    }


}

