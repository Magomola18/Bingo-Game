import java.util.Scanner;

public class ManualAnnouncer extends Announcer {
    private Scanner scanner = new Scanner(System.in);

    public void chooseNextNumber() {
        System.out.print("Number to announce: ");
        int number = scanner.nextInt();
        super.announceNextNumber(number);
    }
}
