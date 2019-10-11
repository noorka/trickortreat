import java.util.*;

public class User {
	private Integer speed;
	private Integer cute;
	private Integer scary;
	private Integer costume;
	private Integer movement;
// CONSTRUCTOR
	public User() {
		this.setSpeed(8);
		this.setCute(1);
		this.setScary(1);
		this.setCostume(0);
		this.setMovement(5);
	}
	
// SCARY
	private void setScary(Integer scary) {
		this.scary = scary;
		
	}
	public Integer getScary() {
		return scary;
		
	}
	public Integer addScary(int modifyer){
		return scary+=modifyer;
	}
// CUTE
	private void setCute(Integer cute) {
		this.cute = cute;
		
	}
	public Integer getCute() {
		return cute;
		
	}
	public Integer addCute(int modifyer){
		return cute+=modifyer;
	}

// SPEED
	private void setSpeed(Integer speed) {
		this.speed = speed;
		
	}
	public Integer getSpeed() {
		return speed;
		
	}
	public Integer addSpeed(int modifyer){
		return speed+=modifyer;
	}

	// MOVEOMENT
	private void setMovement(Integer movement) {
		this.movement = movement;
		
	}
	public Integer getMovement() {
		return movement;
		
	}
	public Integer addMovement(int modifyer){
		return movement+=modifyer;
	}
	
// COSTUME
	private void setCostume(Integer costume) {
		this.costume = costume;
		
		// ARRAY things
		
	}
	public Integer getCostume() {
		return costume;
		
	}
	
	// Get Costume Method
		public void costumeBox() {
			int choice = -1;
			Scanner userInput = new Scanner(System.in);
			System.out.println("Please choose a costume from our costume box!");
			while(choice<0||choice>3){
				System.out.println("[0] None\n[1] Princess \n[2] Vampire \n[3] Superhero");
				choice = userInput.nextInt();
			}
			
			this.setCostume(choice);
			int[][] myCostumes = getCostumeValues();
			this.setSpeed(myCostumes[choice][0]);
			this.setCute(myCostumes[choice][1]);
			this.setScary(myCostumes[choice][2]);
			if(choice==1){
				System.out.println("Here is your gown, your majesty.");
			}
			else if(choice==2){
				System.out.println("Go forth, you creature of the night.");
			}
			else if(choice ==3){
				System.out.println("Here is your cape, this town needs your help!");
			}
			else if(choice == 0){
				System.out.println("Going as yourself I see.");
			}
		}
		public static int[][] getCostumeValues(){
			int defaultAttributes []= new int[4];
			defaultAttributes[0]=8;
			defaultAttributes[1]=1;
			defaultAttributes[2]=1;
			defaultAttributes[3]=5;

			int princessAttributes []= new int[4];
			princessAttributes[0]=3;
			princessAttributes[1]=8;
			princessAttributes[2]=1;
			princessAttributes[3]=3;


			int vampireAttributes []= new int[4];
			vampireAttributes[0]=2;
			vampireAttributes[1]=1;
			vampireAttributes[2]=7;
			vampireAttributes[3]=4;

			int superheroAttributes []= new int[4];
			superheroAttributes[0]=6;
			superheroAttributes[1]=1;
			superheroAttributes[2]=1;
			superheroAttributes[3]=6;

			int[][] twoD_arr = {defaultAttributes, princessAttributes, vampireAttributes, superheroAttributes};
			return twoD_arr;
		}
}