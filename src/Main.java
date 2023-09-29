import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        Player p1 = new Player("Test", 5);
        p1.setScoreBoard(getScoreBoard());


        for(int j = 0; j < p1.getScoreBoard().size(); j++){ // Loopar hela scorboarden

            for(int i = 0; i < 2; i++){ // Loppar 3 gånger för att antal slag

                p1.rollAllDice();
                menuForHoldingDice(p1.getDice());
            }
            p1.rollAllDice();
            printAllDice(p1.getDice());
            System.out.println(p1.getDiceResult());

            System.out.println(p1.getScoreBoard());
            p1.resetDies();
            addScoreMenu(p1);
        }
        p1.setTotalScore();
        System.out.println(p1.getScore());

    }

    public static void printAllDice(ArrayList<Die> dice){
        String RESET = "\u001B[0m";
        String BLUE = " \u001B[34m";
        int i = 1;
        for (Die die: dice) {
            System.out.println( BLUE + i + RESET + ": "  +die.getCurrentValue() + " " + (die.isHeld() ? "Hold": ""));
            i++;
        }
        System.out.println(BLUE +"r: "+RESET +"To roll.");
    }

    public static void menuForHoldingDice(ArrayList<Die> dice){
        Scanner sc = new Scanner(System.in);
        System.out.println("What dice do you want to hold:");
        while (true){
            printAllDice(dice);

            String selected = sc.nextLine();

            switch (selected) {
                case "1": dice.get(0).toogleHeld();
                    break;
                case "2": dice.get(1).toogleHeld();
                    break;
                case "3": dice.get(2).toogleHeld();
                    break;
                case "4": dice.get(3).toogleHeld();
                    break;
                case "5": dice.get(4).toogleHeld();
                    break;
                case "6": dice.get(5).toogleHeld();
                    break;
                case "r":
                    return;
            }

            System.out.println();
        }
    }

    public static void addScoreMenu(Player player){
        Scanner sc = new Scanner(System.in);
        String GREEN = "\u001B[32m";
        String RESET = "\u001B[0m";
        String BLUE = " \u001B[34m";

        System.out.println(player.getName() + " vart vill du spara poängen");
        int selected = 1;
        for(ScoreItem item: player.getScoreBoard()){
            if(item.score == -1){
                System.out.println(BLUE + selected + RESET +": " + item.name + " "  +GREEN + item.getScore(player.getDiceResult()) + RESET);
            }else{
                System.out.println(item.name + " " + item.score);
            }
            selected++;
        }
        int choice = sc.nextInt();
        sc.nextLine();
        ScoreItem scoreItem = player.getScoreBoard().get(choice -1);
        scoreItem.setScore(scoreItem.getScore(player.getDiceResult()));



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

