import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Player p1 = new Player("Test", 5);
        for(int i = 0; i < 2; i++){
            p1.rollAllDice();
            menuForHoldingDice(p1.getDice());
        }
        p1.rollAllDice();
        printAllDice(p1.getDice());
        System.out.println(p1.getDiceResult());
        NumberOfAKind num = new NumberOfAKind("6:", 6, 0);
        p1.setScoreBoard(getScoreBoard());
        System.out.println(p1.getScoreBoard());
        p1.getListOfPossibleScores();
    }

    public static void printAllDice(ArrayList<Die> dice){
        int i = 1;
        for (Die die: dice) {
            System.out.println(i + ": "  +die.getCurrentValue() + " " + (die.isHeld() ? "Hold": ""));
            i++;
        }
    }

    public static void menuForHoldingDice(ArrayList<Die> dice){
        Scanner sc = new Scanner(System.in);
        System.out.println("What dice do you want to hold:");
        while (true){
            printAllDice(dice);
            System.out.println("0: To roll.");
            int selected = sc.nextInt();
            switch (selected) {
                case 1: dice.get(0).toogleHeld();
                    break;
                case 2: dice.get(1).toogleHeld();
                    break;
                case 3: dice.get(2).toogleHeld();
                    break;
                case 4: dice.get(3).toogleHeld();
                    break;
                case 5: dice.get(4).toogleHeld();
                    break;
                case 6: dice.get(5).toogleHeld();
                    break;
                case 0:
                    return;
            }

            System.out.println();
        }

    }

    public static ArrayList<ScoreItem> getScoreBoard(){
        ArrayList<ScoreItem> scoreBoard = new ArrayList<>();
        scoreBoard.add(new NumberOfAKind("1:s", 1, 0));
        scoreBoard.add(new NumberOfAKind("2:s", 2, 0));
        scoreBoard.add(new NumberOfAKind("3:s", 3, 0));
        scoreBoard.add(new NumberOfAKind("4:s", 4, 0));
        scoreBoard.add(new NumberOfAKind("5:s", 5, 0));
        scoreBoard.add(new NumberOfAKind("6:s", 6, 0));


        return scoreBoard;

    }

}

