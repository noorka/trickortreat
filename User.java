import java.util.Scanner;

public class User {
	private Integer speed;
	private Integer cute;
	private Integer scary;
	private Integer costume;
// CONSTRUCTOR
	public User() {
		this.setSpeed(8);
		this.setCute(1);
		this.setScary(1);
		this.setCostume(0);
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
	
// COSTUME
	private void setCostume(Integer costume) {
		this.costume = costume;
		
		// ARRAY things
		
	}
	public Integer getCostume() {
		return costume;
		
	}
	/*public String toString(){
		String costumeType = "Princess";
		return costumeType;
	}
	*/
	
	// Get Costume Method
		public void costumeBox() {
			int choice = 0;
			Scanner userInput = new Scanner(System.in);
			System.out.println("Please choose a costume from our costume box!");
			while(choice<1||choice>3){
				System.out.println("[1] Princess \n[2] Superhero \n[3] Vampire");
				choice = userInput.nextInt();
			}
			
			this.setCostume(choice);
		}
}

