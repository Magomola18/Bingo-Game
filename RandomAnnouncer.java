public class RandomAnnouncer extends Announcer {

    public int generateRandomNumber() {
        return (int) (Math.random() * 90) + 10;
    }

    @Override
    public void chooseNextNumber() {
        int number = generateRandomNumber();
        super.announceNextNumber(number);
        System.out.println("Announced number: " + number);
    }
}
