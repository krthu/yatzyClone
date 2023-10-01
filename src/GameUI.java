import java.util.ArrayList;
import java.util.Scanner;

public class GameUI {

    public GameUI(){

    }


    public void printAllDice(ArrayList<Die> dice){
        String RESET = "\u001B[0m";
        String BLUE = " \u001B[34m";
        int i = 1;
        for (Die die: dice) {
            System.out.println( BLUE + i + RESET + ": "  +die.getCurrentValue() + " " + (die.isHeld() ? "Hold": ""));
            i++;
        }
        System.out.println(BLUE +"r: "+RESET +"To roll.");
    }

    public void menuForHoldingDice(ArrayList<Die> dice){
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
                default:
                    System.out.println("Invalid input");
            }

            System.out.println();
        }
    }

    public void addScoreMenu(Player player){
        String GREEN = "\u001B[32m";
        String RESET = "\u001B[0m";
        String BLUE = " \u001B[34m";

        System.out.println(player.getName() + " vart vill du spara poängen");
        int alternativ = 1;
        for(ScoreItem item: player.getScoreBoard()){
            if(item.score == -1){
                System.out.println(BLUE + alternativ + RESET +": " + item.name + " "  +GREEN + item.getPossibleScore(player.getDiceResult()) + RESET);
            }else{
                System.out.println(item.name + " " + item.score);
            }
            alternativ++;
        }


    }



//    public static void addScore(Player player){
//        Scanner sc = new Scanner(System.in);
//
//        boolean validInput = false;
//        while (!validInput) {
//            int choice = sc.nextInt();
//
//            sc.nextLine();
//            ScoreItem scoreItem = player.getScoreBoard().get(choice - 1);
//            if (scoreItem.score == -1) {
//                scoreItem.setScore(scoreItem.getPossibleScore(player.getDiceResult()));
//                validInput = true;
//            } else {
//                System.out.println("Invalid input.");
//            }
//        }
//    }

}
