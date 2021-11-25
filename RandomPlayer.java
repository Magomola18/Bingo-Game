public class RandomPlayer implements Player {
	private BingoCard card;

	public int generateRandomNumber() {
		return (int) (Math.random() * 90) + 10;
	}

	@Override
	public void chooseNumbers() {
		card = new BingoCard(generateRandomNumber(), generateRandomNumber(), generateRandomNumber(), generateRandomNumber());
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