import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GameUI gameUI = new GameUI();
        ArrayList<Player> players = new ArrayList<>();
        int NUMBER_OF_DICE = 5;

        System.out.println("Hello and welcome to the Yatzy");
        System.out.println("How many players: ");
        int numberOfPlayers = sc.nextInt();
        sc.nextLine();

        // Create Players
        for(int i = 0; i < numberOfPlayers; i++){
            System.out.println("Name for player "+ (i+1) +":");
            String name = sc.nextLine();
            players.add(new Player(name, NUMBER_OF_DICE, newScoreBoard()));

        }

     //   Player p1 = new Player("Test", 5, newScoreBoard());

        for(int j = 0; j < players.get(0).getScoreBoard().size(); j++){ // Loopar hela scoreboarden
            for (Player currentPlayer:players) {
                System.out.println(currentPlayer.getName() + " its you turn");
                currentPlayer.printCurrentScoreBoard();
                sc.nextLine();
                for (int i = 0; i < 2; i++) { // Loopar 2 gånger för att antal möjligheter att spara

                    currentPlayer.rollAllDice();
                    System.out.println("Throw number: " + (i + 1));
                    gameUI.menuForHoldingDice(currentPlayer.getDice());
                }
                currentPlayer.rollAllDice();
                gameUI.printAllDice(currentPlayer.getDice());
                System.out.println(currentPlayer.getDiceResult());

                //  System.out.println(p1.getScoreBoard());

                gameUI.addScoreMenu(currentPlayer); // Listar möjliga poäng
                boolean validInput = false;
                int choice = 0;
                while (!validInput) { // Sätter poängen och fel hantering.
                    try {
                        choice = sc.nextInt();
                        choice -= 1; // Sätt till 0 indexering
                        sc.nextLine();
                        if (choice >= 0 && choice < currentPlayer.getScoreBoard().size()) {
                            validInput = currentPlayer.addScoreToScoreBoard(choice);
                            if (!validInput) {
                                System.out.println("Already set");
                            }
                        } else {
                            System.out.println("Number out of bounds");
                        }

                    } catch (InputMismatchException e) {
                        sc.nextLine();
                        System.out.println("Invalid input");
                    }
                }
            currentPlayer.removeHeldFromAllDice();
            }

        }
        Player winner = null;
        for (Player player: players) {
            player.setTotalScore();
            System.out.println(player.getName() + " got " + player.getScore());
            if (winner == null || player.getScore() > winner.getScore()){ // Dont handle a tie game.
                winner = player;
            }
        }
        System.out.println("Congratulations the winner is " + winner.getName() + " with " + winner.getScore() + " points");

    }

    public static ArrayList<ScoreItem> newScoreBoard(){
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

        scoreBoard.add(new NumberOfAKind("Yatzy:", 0, 5));

        return scoreBoard;

    }

    public static void clearConsole(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}

