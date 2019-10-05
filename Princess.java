
public class Princess {
	private Integer speed;
	private Integer cute;
	private Integer scary;
	// private Integer bag;
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
	
// BAG
	// private void setBag(Integer bag) {
	// 	this.bag = bag;
		
	// }
	// private Integer getBag() {
	// 	return bag;
		
	// }
	
	// public void equipItem(String item){
		/* not sure what logic we want to use here, I think a switch with cases for each type of item 
		 * then you just have to get the value into a temp variable and set it again with the temp 
		 * Integer temp = this.getSpeed();
		 * this.setSpeed(temp);
		 */
	// }
	
	// public void chooseBag(){
		/*
		 * So this one would have an output asking you to pick a bag then once it picks the bag we can
		 * have ifs or switch for setting the bag type as a number 1,2,3 and re-setting whatever parameters that 
		 * the bag choice changes. 
		 * The thing about having this here is that we can't really affect time because it is outside the class
		 */
		
	// }
	

}

