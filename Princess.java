
public class Princess {
	private Integer speed;
	private Integer cute;
	private Integer scary;
// constructor for a basic princess, usually you would input these values, but since we don't want that we won't
	public Princess() {
		this.setSpeed(3); //I can't remember what this does, but I know it is an ehh way to do things
		this.setCute(8);
		this.setScary(1);
	}
// with private variables you have to have get/set methods to be able to see what is int the variable/ change it
	// it isn't really good form to change variables outside of the class with the set, but you can
	
// SCARY
	private void setScary(Integer scary) {
		this.scary = scary;
		
	}
	public Integer getScary() {
		return scary;
		
	}
// CUTE
	private void setCute(Integer cute) {
		this.cute = cute;
		
	}
	public Integer getCute() {
		return cute;
		
	}

// SPEED
	private void setSpeed(Integer speed) {
		this.speed = speed;
		
	}
	public Integer getSpeed() {
		return speed;
		
	}
	

}

