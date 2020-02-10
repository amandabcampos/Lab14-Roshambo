import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * 
 * @author amandabcampos
 *
 */

public class RoshamboApp {
	
	private static List<Integer> myPoints = new ArrayList<>();
	private static List<Integer> opponentsPoints = new ArrayList<>();

	public static void main(String[] args) {

		Scanner scnr = new Scanner(System.in);
		
		greeting();
		
		InputPlayer me = new InputPlayer(Validator.getString(scnr, "Enter your name: "));

		Player opponent = Validator.jetsOrSharks(scnr);
		
		boolean looping = true;
		while (looping) {
			
			playMatch(me, opponent);
			
			looping = Validator.yesOrNo(scnr, "Play again? (y/n): "); 

		}
		
		tableOfPoints(me, opponent);
		
		scnr.close();
	}

	public static void greeting() {
		System.out.println("Welcome to Rock Paper Scissors!\n");
	}

	public static void playMatch(Player me, Player opponent) {
		
		Roshambo myOption = null;
		while (myOption == null) {
			myOption = me.generateRoshambo();
		}
		Roshambo opponentsOption = opponent.generateRoshambo();
		
		System.out.println(me.name + ": " + myOption);
		System.out.println(opponent.name + ": " + opponentsOption);
		
		results(me, opponent, myOption, opponentsOption);
		
	}
	
	
	
	private static void results(Player me, Player opponent, Roshambo myOption, Roshambo opponentsOption) {
		
		// Use compareTo?
		
		if (myOption.equals(opponentsOption)) {
			System.out.println("Draw!");
			myPoints.add(0);
			opponentsPoints.add(0);
		}
		
		if (myOption.toString().equals("Paper")) { 
			if (opponentsOption.toString().equals("Rock")) {
				System.out.println(me.name + " wins!");
				myPoints.add(1);
				opponentsPoints.add(0);
			} else if (opponentsOption.toString().equals("Scissors")) {
				System.out.println(opponent.name + " wins!");
				myPoints.add(0);
				opponentsPoints.add(1);
			}
		} else if (myOption.toString().equals("Rock")) { 
			if (opponentsOption.toString().equals("Paper")) {
				System.out.println(opponent.name + " wins!");
				myPoints.add(0);
				opponentsPoints.add(1);
			} else if (opponentsOption.toString().equals("Scissors")) {
				System.out.println(me.name + " wins!");
				myPoints.add(1);
				opponentsPoints.add(0);
			}
		} else if (myOption.toString().equals("Scissors")) { 
			if (opponentsOption.toString().equals("Paper")) {
				System.out.println(me.name + " wins!");
				myPoints.add(1);
				opponentsPoints.add(0);
			} else if (opponentsOption.toString().equals("Rock")) {
				System.out.println(opponent.name + " wins!");
				myPoints.add(0);
				opponentsPoints.add(1);
			}		
		}
		
	}
	
	public static void tableOfPoints(Player me, Player opponent) {
		System.out.printf("\n%18s %10s\n", me.name, opponent.name);
		int sum1 = 0;
		int sum2 = 0;
		for (int i =0; i< myPoints.size(); i++) {
			System.out.printf("%18d %10d\n", myPoints.get(i), opponentsPoints.get(i));
			sum1 += myPoints.get(i);
			sum2 += opponentsPoints.get(i);
		}
		System.out.printf("Result: %10d %10d\n", sum1, sum2);
		
		
		if (sum1 > sum2) {
			System.out.print(me.name + " wins!");
		} else if (sum2 > sum1){
			System.out.print(opponent.name + " wins!");
		} else {
			System.out.println("Tied round");
		}
		
		
	}

}
