import java.util.Random;

// House Objects
public class House {
	private Integer cute;
	private Integer scary;

	// We don't need a constructor with parameters any more,
	// Since the random house is made inside the method here
	
//	public House(Integer cuteFactor, Integer scaryFactor) {
//		this.setCute(cuteFactor);
//		this.setScary(scaryFactor);
//	}
	
	//Cute Value of House
	private void setCute(int i) {
		this.cute = cute;
	}
	public Integer getCute() {
		return cute;	
	}
	
	//Scary Value of House
	private void setScary(int i) {
		this.scary = scary;
	}
	public Integer getScary() {
		return scary;	
	}

	//need to use the get for the costume to include it's scary and cute
	public Integer outputCandy(Integer userScary, Integer userCute ){
		int candy = 0;
		
		Random rand1 = new Random();
		Random rand2 = new Random();
		cute = rand1.nextInt(11);
		scary = rand2.nextInt(11);
		
		if(scary > cute){ // scary house
			if(userScary <= 3){
				System.out.println("You look ... cute.");
				candy = 1;
				System.out.println("+1 candy");
			}
			else if((userScary > 3) && (userScary <= 6)){
				System.out.println("Nice costume.");
				candy = 2;
				System.out.println("+2 candy");
			}
			else{
				System.out.println("Spooktacular costume!");
				candy = 3;
				System.out.println("+3 candy");
			}
		
		}
		else if (cute > scary){ // cute house
			if(userCute <= 3){
				System.out.println("Goodness, you're scary.");
				candy = 1;
				System.out.println("+1 candy");
			}
			else if((userCute > 3) && (userCute <= 6)){
				System.out.println("Nice costume.");
				candy = 2;
				System.out.println("+2 candy");
			}
			else{
				System.out.println("You look boo-tiful!");
				candy = 3;
				System.out.println("+3 candy");
			}
		}
		else{ //neutral house
			candy = 2; 
			System.out.println("Happy Halloween!");
			System.out.println("+2 candy");
		}
		return candy;
	}
}
