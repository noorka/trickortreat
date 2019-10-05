public class Vampire {
	private Integer speed;
	private Integer cute;
	private Integer scary;
	
	public Vampire() {
		this.setSpeed(2); 
		this.setCute(1);
		this.setScary(7);
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

}

