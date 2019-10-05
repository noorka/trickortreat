import java.util.*;

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
			while(choice<0||choice>3){
				System.out.println("[0] None\n[1] Princess \n[2] Superhero \n[3] Vampire");
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
				System.out.println("Here is your cape, this town needs your help!");
			}
			else if(choice ==3){
				System.out.println("Go forth, you creature of the night.");
			}
			else if(choice == 0){
				System.out.println("Going as yourself I see.");
			}
		}
		public static int[][] getCostumeValues(){
			int defaultAttributes []= new int[3];
			defaultAttributes[0]=8;
			defaultAttributes[1]=1;
			defaultAttributes[2]=1;

			int princessAttributes []= new int[3];
			princessAttributes[0]=3;
			princessAttributes[1]=8;
			princessAttributes[2]=1;

			int vampireAttributes []= new int[3];
			vampireAttributes[0]=2;
			vampireAttributes[1]=1;
			vampireAttributes[2]=7;

			int superheroAttributes []= new int[3];
			superheroAttributes[0]=6;
			superheroAttributes[1]=1;
			superheroAttributes[2]=1;

			int[][] twoD_arr = {defaultAttributes, princessAttributes, vampireAttributes, superheroAttributes};
			return twoD_arr;
		}
}