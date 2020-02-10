/*
 * 
 * @author amandabcampos
 *
 */


public class RandomPlayer extends Player {
	
	public RandomPlayer() {
		super("TheSharks");
	}
	

	@Override
	public Roshambo generateRoshambo() {
		int value = (int) (Math.random() * 3 + 1);
		switch (value) {
		case 1:
			return Roshambo.ROCK;
		case 2:
			return Roshambo.PAPER;
		case 3:
			return Roshambo.SCISSORS;
		}
		return null;
	}

}
