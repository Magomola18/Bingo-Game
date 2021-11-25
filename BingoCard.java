public class BingoCard {
	private static final int MAX_NUMBERS = 4;
 
	private int[] numbers = new int[MAX_NUMBERS];
	private boolean[] markedOff = new boolean[MAX_NUMBERS];

	public BingoCard(int first, int second, int third, int fourth) {
		numbers[0] = first;
		numbers[1] = second;
		numbers[2] = third;
		numbers[3] = fourth;

		for(int i = 0; i < markedOff.length; i++) {
			markedOff[i] = false;
		}
	}

	public void markOff(int number) {
		for(int i = 0; i < numbers.length; i++) {
			if(numbers[i] == number) {
				markedOff[i] = true;
			}
		}
	}

	public boolean areAllMarkedOff() {
		boolean allMarkedOff = true;

		for(int i = 0; i < numbers.length; i++) {
			if(!markedOff[i]) {
				allMarkedOff = false;
			}
		}

		return allMarkedOff;

	}

	public String getRemaining() {
		String remaining = "Remaining numbers: ";

		for(int i = 0; i < numbers.length; i++) {
			if(!markedOff[i]) {
				remaining += numbers[i] + ", ";
			}
		}

		return remaining.substring(0, remaining.length() - 2);
	}

}