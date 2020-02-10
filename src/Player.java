/*
 * 
 * @author amandabcampos
 *
 */


public abstract class Player {
	
	protected String name;
	
	public Player(String name) {
		this.name = name;
	}    

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public abstract Roshambo generateRoshambo();

}
