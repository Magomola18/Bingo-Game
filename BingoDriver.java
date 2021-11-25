import java.util.Scanner;

public class BingoDriver {

    private Announcer announcer;
    private Player[] players = new Player[2];
    private Scanner scanner = new Scanner(System.in);

    private void start() {
        selectAnnouncer();
        System.out.println("Set the players for this round...");
        selectPlayer(1);
        players[0].chooseNumbers();

        selectPlayer(2);
        players[1].chooseNumbers();

        announcer.addNewPlayer(players[0]);
        announcer.addNewPlayer(players[1]);
        System.out.println("Round begins");

        startRound();
    }

    private void startRound() {
        printRemainingNumbers();
        announcer.chooseNextNumber();

        if(players[0].checkIfWon()) {
            System.out.println("Player 1 wins!");
            startNewGame();
        }
        else if(players[1].checkIfWon()) {
            System.out.println("Player 2 wins!");
            startNewGame();
        }
        else {
            startRound();
        }
    }

    private void startNewGame() {
        System.out.print("Start new round? y/n: ");
        String response = scanner.next();
        if(response.equalsIgnoreCase("y") || response.equalsIgnoreCase("yes")) {
            start();
        }
        else {
            System.out.println("Goodbye!");
            System.exit(0);
        }
    }

    private void printRemainingNumbers() {
        System.out.print("Player 1: " + players[0].printRemaining() + "\n");
        System.out.print("Player 2: " + players[1].printRemaining() + "\n");
    }

    private void selectAnnouncer() {
        System.out.println("Which type of Announcer do you want?");
        System.out.println("1. Random Announcer \n2. Manually-Controlled Announcer");
        int selectedOption = getUserSelection(1, 2);

        if(selectedOption == 1) {
            announcer = new RandomAnnouncer();
        }
        else if(selectedOption == 2) {
            announcer = new ManualAnnouncer();
        }
        else {
            System.out.println("Invalid selection");
            selectAnnouncer();
        }

    }

    private void selectPlayer(int position) {
        System.out.println("Which type of player do you want as Player " + position + "?");
        System.out.println("1. Random Player \n2. User-Controlled Player");
        int selectedOption = getUserSelection(1, 2);

        if (selectedOption == 1) {
            players[position - 1] = new RandomPlayer();
        }
        else if(selectedOption == 2) {
            players[position - 1] = new HumanPlayer();
        }
        else {
            System.out.println("Invalid selection");
            selectPlayer(position);
        }

    }

    private int getUserSelection(int min, int max) {
        System.out.print("Enter a selection (" + min + " - " + max + "): ");
        String response = scanner.next();
        try {
            int selection = Integer.parseInt(response);
            if(min > max) {
                return 0;
            }
            else if(selection < min || selection > max) {
                return 0;
            }

            return selection;
        }
        catch(NumberFormatException e) {
            System.out.println("Input type mismatch");
            return getUserSelection(min, max);
        }
        catch(Exception e) {
            System.out.println("Unknown exception");
            e.printStackTrace();
            return getUserSelection(min, max);
        }
    }

    public static void main(String[] args) {
        BingoDriver d = new BingoDriver();
        d.start();
    }
}
