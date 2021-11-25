import java.util.ArrayList;

public abstract class Announcer {
    private ArrayList<Player> players;

    public Announcer() {
        players = new ArrayList<>();
    }

    public abstract void chooseNextNumber();

    public void addNewPlayer(Player player) {
        players.add(player);
    }

    public void announceNextNumber(int number) {
        for (Player player : players) {
            player.checkForNumber(number);
        }
    }
}
