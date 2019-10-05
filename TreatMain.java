//User chooses costume
//Program asks if they want to go to next house or go home (y/n), 
//as well as tells them how much candy they have
//If next house, randomized next house, with candy


import java.util.*;

public class TreatMain {
	public static void main(String[] args) {
		Scanner mainInput = new Scanner(System.in);
		int candy = 0, cuteness =0 , scariness=0, response = 0;
		
		System.out.println("Welcome to Hallowe'en Night, spooky girls and boys of all ages!");
		int choice = costumeBox();
		System.out.println("You chose: "+choice);
		
		//This will be inside a method once we have more costumes
		//So we can make it less specific
		Princess costume = new Princess();
		scariness = costume.getScary();
		cuteness = costume.getCute();
		
		while(true) {
			System.out.println("\nWhat would you like to do next?");
			System.out.println("[1] Go to next house\n[2] Check candy levels\n[3] Go home.");
			response = mainInput.nextInt();
			
			if(response == 1) {
				House newHouse = new House();
				candy += newHouse.outputCandy(scariness,cuteness);
			}
			else if(response == 2) {
				if(candy<2) {
					System.out.println("You have no candy.");
				}
				else {
					System.out.println("You have "+candy+" candies");
				}
			}
			else if(response == 3) {
				break;
			}
		}
		System.out.println("You end your night with "+candy+" candies.");
	}
	
	
	
	// Get Costume Method
	public static int costumeBox() {
		int choice = 0;
		Scanner userInput = new Scanner(System.in);
		System.out.println("Please choose a costume from our costume box!");
		while(choice<1||choice>3){
			System.out.println("[1] Princess \n[2] Superhero \n[3] Vampire");
			choice = userInput.nextInt();
		}
		return choice;
	}
}