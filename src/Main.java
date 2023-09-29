import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String GREEN = "\u001B[32m";
        String RESET = "\u001B[0m";

        Player p1 = new Player("Test", 5);
        for(int i = 0; i < 2; i++){

            p1.rollAllDice();
            menuForHoldingDice(p1.getDice());
        }
        p1.rollAllDice();
        printAllDice(p1.getDice());
        System.out.println(p1.getDiceResult());
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
        scoreBoard.add(new NumberOfAKind("3 of a kind:", 0, 3));
        scoreBoard.add(new NumberOfAKind("4 of a kind:", 0, 4));
        scoreBoard.add(new Pair("1 Pair", 1));
        scoreBoard.add(new Pair("2 Pairs", 2));
        scoreBoard.add(new SumOfAllDice("Full house"));
        scoreBoard.add(new SumOfAllDice("Small straight"));
        scoreBoard.add(new SumOfAllDice("Large straight"));
        scoreBoard.add(new SumOfAllDice("Chance"));

        scoreBoard.add(new NumberOfAKind("Yahtzee:", 0, 5));

        return scoreBoard;

    }

    public static void clearConsole(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}

