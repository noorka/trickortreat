public class Superhero {
	private Integer speed;
	private Integer cute;
	private Integer scary;
	
	public Superhero() {
		this.setSpeed(6); 
		this.setCute(1);
		this.setScary(1);
	}
	
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
	public String toString(){
		String costumeType = "Superhero";
		return costumeType;
	}
}