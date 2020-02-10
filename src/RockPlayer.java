/*
 * 
 * @author amandabcampos
 *
 */


public class RockPlayer extends Player {
	
	public RockPlayer() {
		super("TheJets");
	}
	
	@Override
	public Roshambo generateRoshambo() {
		return Roshambo.ROCK;
	}

}
