
public class House {
	private Integer cute;
	private Integer scary;


public House(Integer cuteFactor, Integer scaryFactor) {
	this.setCute(cuteFactor);
	this.setScary(scaryFactor);
}
private void setCute(int i) {
	this.cute = cute;
	
}
public Integer getCute() {
	return cute;
	
}

private void setScary(int i) {
	this.scary = scary;
	
}
public Integer getScary() {
	return scary;
	
}

//need to use the get for the costume to include it's scary and cute
public Integer outputCandy(Integer userScary, Integer userCute ){
	int candy = 0;
	
	if(scary > cute){ // scary house
		if(userScary <= 3){
			System.out.println("You look ... cute.");
			candy = 1;
		}
		else if((userScary > 3) && (userScary <= 6)){
			System.out.println("Nice costume.");
			candy = 2;
		}
		else{
			System.out.println("Spooktacular costume!");
			candy = 3;
		}
	
	}
	else if (cute > scary){ // cute house
		if(userCute <= 3){
			System.out.println("Goodness, you're scary.");
			candy = 1;
		}
		else if((userCute > 3) && (userCute <= 6)){
			System.out.println("Nice costume.");
			candy = 2;
		}
		else{
			System.out.println("You look boo-tiful!");
			candy = 3;
		}
	}
	else{ //neutral house
		candy = 2; 
		System.out.println("Happy Halloween!");
	}
	
	
	return candy;
}
}
