import java.util.Scanner;

public class HumanPlayer implements Player {
    private BingoCard card;
    private int[] numbers = new int[4];
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void chooseNumbers() {
        System.out.println("Chosen numbers for Human player:");

        System.out.print("First number: ");
        numbers[0] = scanner.nextInt();

        System.out.print("Second number: ");
        numbers[1] = scanner.nextInt();

        System.out.print("Third number: ");
        numbers[2] = scanner.nextInt();

        System.out.print("Fourth number: ");
        numbers[3] = scanner.nextInt();

        card = new BingoCard(numbers[0], numbers[1], numbers[2], numbers[3]);
    }

    @Override
    public void checkForNumber(int number) {
        card.markOff(number);
    }

    @Override
    public String printRemaining() {
        return card.getRemaining();
    }

    @Override
    public boolean checkIfWon() {
        return card.areAllMarkedOff();
    }
}
