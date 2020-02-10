/*
 * 
 * @author amandabcampos
 *
 */


import java.util.Scanner;

public class InputPlayer extends Player{
	
	public InputPlayer(String name) {
		super(name);
	}

	@Override
	public Roshambo generateRoshambo() {
		Scanner scnr = new Scanner(System.in);
		String option = Validator.getString(scnr, "Rock, paper, or scissors? (R/P/S): ");
		if (option.startsWith("r")) {
			return Roshambo.ROCK;
		} else if (option.startsWith("p")) {
			return Roshambo.PAPER;
		} else if (option.startsWith("s")) {
			return Roshambo.SCISSORS;
		} else {
			System.out.println("Invalid option");
		}	
		return null;
	}
	
}
