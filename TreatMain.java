//User chooses costume
//Program asks if they want to go to next house or go home (y/n), 
//as well as tells them how much candy they have
//If next house, randomized next house, with candy


import java.util.*;

public class TreatMain {
	public static void main(String[] args) {
		Scanner mainInput = new Scanner(System.in);
		int candy = 0;
		System.out.println("Welcome to Hallowe'en Night, spooky girls and boys of all ages!");
		
		int choice = costumeBox();
		
		System.out.println("You chose: "+choice);
		Princess costume = new Princess();
		String response = "n";
		
		while(response == "n") {
			System.out.println("Would you like to go to the next house, or go home?\n You have "+candy+" candies.");
			response = mainInput.next();
			if(response == "n") {
				break;
			}
			
			
		}
	}
	
	public static int costumeBox() {
		int choice = 0;
		Scanner userInput = new Scanner(System.in);
		System.out.println("Please choose a costume from our costume box!");
		while(choice<1||choice>3){
			System.out.println("[1] Princess \n[2] Superhero \n[3] Vampire");
			choice = userInput.nextInt();
		}
		userInput.close();
		return choice;
	}
}