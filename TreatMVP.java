//Introduction to Object Oriented Programming
//Fall 2019
//Dr. Chan-Tin

//Assignment: P1 - A Program I Wrote
//Title: Trick or Treating Console Game v.1
//Collaborators: Eliora Horst and Anna Kroon
//QA Testers: Bill Horst and Tom Kroon

//Pseudo Code
//Greeting screen asks users to adjust screen to view game
//User chooses costume
//Program gives user options
//	Go to next house
//	Check candy level
//	Check time left
// 	Go home
//
// Each costume class has the attributes of cuteness, and scariness, which increase/decrease candy amounts at certain houses
// Speed of costume effects how many homes they can visit throughout the night
// Homes also have cuteness/scariness which effects how much candy they give out to certain costumes
// How long it takes to trick or treat at each home is randomized
// The attributes of each house is randomized

// For future versions:
//	Add a user to which costumes are added
//	Add the chance of picking up random items, which increase costume stats
//	Add a candy bag
//	Add the option of tricking/pranks at each house
//  Add the increased odds of getting more/less candy as the night progresses

import java.util.Random;
import java.util.*;

public class TreatMVP {
	public static void main(String[] args) {
		Scanner mainInput = new Scanner(System.in);
		int candy = 0, cuteness =0 , scariness=0, response = 0, speed = 0, adjustResponse=0;
		int time = 150;
		Random randTime = new Random ();
		System.out.println("Welcome to our game! Please get ready widen your viewing screen so that you can see our spooky graphics.");
		System.out.println("When adjusted properly, you should have a rectangular window of asterisks around your console screen.");
		System.out.println("Please press 1 when you are ready to view the graphics adjustment screen.");


		while(adjustResponse !=1){
			Scanner adjustInput = new Scanner(System.in);
			try{
				adjustResponse = adjustInput.nextInt();
			}
			catch(Exception e){
				System.out.println("Incorrect input.  Please enter 1 when you are ready.");
			}
		}
		printAdjust();
		printTitle();

		System.out.println("Welcome to Hallowe'en Night, spooky girls and boys of all ages!");
		//Choose a costume
		int choice = costumeBox();

		//Princess Costume
		if(choice==1){
			Princess costume = new Princess();
			scariness = costume.getScary();
			cuteness = costume.getCute();
			speed = costume.getSpeed();
			System.out.println("Here is your gown, your majesty.\n***************************************************************************************************************************");
		}
		//Superhero Costume
		else if(choice==2){
			Superhero costume = new Superhero();
			scariness = costume.getScary();
			cuteness = costume.getCute();
			speed = costume.getSpeed();
			System.out.println("Here is your cape, this town needs your help!\n***************************************************************************************************************************");
		}
		//Vampire Costume
		else if(choice ==3){
			Vampire costume = new Vampire();
			scariness = costume.getScary();
			cuteness = costume.getCute();
			speed = costume.getSpeed();
			System.out.println("Go forth, you creature of the night.\n***************************************************************************************************************************");
		}
		
		while(time != 0) {
			System.out.println("\nWhat would you like to do next?");
			System.out.println("[1] Go to next house\n[2] Check candy levels\n[3] Check time\n[4] Go home.");
			
			Scanner eveningInput = new Scanner(System.in);
			//Catches non-int input
			try{
				response = eveningInput.nextInt();
			}
			catch(Exception e){
				System.out.println("Incorrect input.  Please enter a number between 1 and 4.");
				continue;
			}

			//Generate random trick or treat time
			int houseTime = randTime.nextInt(9) + 1;
			//Check if user has enough time left for trick or treating at next house
			time = timeCheckAction(houseTime,time);
			
			// If user wants to go to next house
			if(response == 1) {
				if(time <= 0){
					break;
				}
				else{
				
				//Generate new house
				House newHouse = new House();
				candy += newHouse.outputCandy(scariness,cuteness);
				time -= treatSpeed(houseTime, speed);
				// System.out.println(time);  *Debugging
				}
			}
			// If user wants to check how much candy they have
			else if(response == 2) {
				if(time <= 0){
					break;
				}
				else{
				
				if(candy<2) {
					System.out.println("You have no candy.");
				}
				else {
					System.out.println("You have "+candy+" candies");
				}
				time--;
				}
			}

			// If user wants to check how much time is left
			else if(response == 3) {
				if(time <= 0){
					break;
				}
				else{
				time--;
				timeCheck(time);
				}
			}

			// If user wants to go home
			else if(response == 4) {
				break;
			}
		}
		System.out.println("You end your night with "+candy+" candies.");
	}// End of main
	
	
	
	// Get Costume Method
	public static int costumeBox() {
		int choice = 0;
		
		System.out.println("Please choose a costume from our costume box!");
		while(choice<1||choice>3){
			System.out.println("[1] Princess \n[2] Superhero \n[3] Vampire");
			Scanner userInput = new Scanner(System.in);
			//Catches non-int input
			try{
				choice = userInput.nextInt();
			}
			catch(Exception e){
				System.out.println("Incorrect input.  Please enter a number between 1 and 3 for one of the costumes.");
			}
		}
		return choice;
	}
	
	// Check to see if there is enough time left for user
	public static int timeCheckAction(int actionTime, int timeLeft){
		if(actionTime > timeLeft){
			System.out.println("You don't have enough time! Go home!");
			int doneTime = 0;
			return doneTime;
		}
		return timeLeft;
	}

	//Display for when user asks for time
	public static void timeCheck(int timeLeft){
		int minLeft = 0;

		if(timeLeft > 120){
			minLeft = timeLeft - 120;
			System.out.println("You have 2 hrs and "+ minLeft+" min left to trick or treat!");
		}
		else if(timeLeft > 60){
			minLeft = timeLeft - 60;
			System.out.println("You have 1 hr and "+ minLeft+" min left to trick or treat!");
		}
		else{
			System.out.println("You have "+ timeLeft+" min left to trick or treat!");
		}
	}
	//Adjusts trick or treat spped time depending on costume
	public static int treatSpeed(int houseTime, int costumeSpeed){
		int treatTime = 0;
		
		if(costumeSpeed <= 3){
			treatTime = houseTime;
		}
		else if((costumeSpeed > 3) && (costumeSpeed <= 6)){
			if(houseTime >= 2){
			treatTime = houseTime - 1;
			}
			else{
				treatTime = houseTime;
			}
		}
		else{
			if(houseTime >= 3){
				treatTime = houseTime - 2;
				}
				else{
					treatTime = houseTime;
				}
		}
		return treatTime;
	}

	//Print Screen for ajustment
	public static void printAdjust(){
		while(true){
			System.out.println("***************************************************************************************************************************");
			System.out.println("*                                                                                                                         *");
			System.out.println("*                                                                                                                         *");
			System.out.println("*                                                                                                                         *");
			System.out.println("*                                                                                                                         *");
			System.out.println("*                                                                                                                         *");
			System.out.println("*                                                                                                                         *");
			System.out.println("*                                                                                                                         *");
			System.out.println("*                                                                                                                         *");
			System.out.println("*                                                                                                                         *");
			System.out.println("*                                                                                                                         *");
			System.out.println("*                                                 Welcome to our game!                                                    *");
			System.out.println("*                Please adjust the width and height of your window so all the stars make an even box.                     *");
			System.out.println("*                                                When satisfied, press 1                                                  *");
			System.out.println("*                                                                                                                         *");
			System.out.println("*                                                                                                                         *");
			System.out.println("*                                                                                                                         *");
			System.out.println("*                                                                                                                         *");
			System.out.println("*                                                                                                                         *");
			System.out.println("*                                                                                                                         *");
			System.out.println("*                                                                                                                         *");
			System.out.println("*                                                                                                                         *");
			System.out.println("*                                                                                                                         *");
			System.out.println("*                                                                                                                         *");
			System.out.println("*                                                                                                                         *");
			System.out.println("*                                                                                                                         *");
			System.out.println("*                                                                                                                         *");
			System.out.println("*                                                                                                                         *");
			System.out.println("*                                                                                                                         *");
			System.out.println("***************************************************************************************************************************");

			Scanner mainInput = new Scanner(System.in);
			try{
				int s1 = mainInput.nextInt();
				break;
			}
			catch(Exception e){
				System.out.println("Incorrect input.  Please enter 1 when you have finished adjusting.");
			}

		}
	}
	//Print screen for title
	public static void printTitle(){
		System.out.println("***************************************************************************************************************************");
		System.out.println("*                                                                                                                         *");
		System.out.println("*                                                                                                                         *");
		System.out.println("*                                                                                                                         *");
		System.out.println("*                                                                                                                         *");
		System.out.println("*                                                                                                                         *");
		System.out.println("*                                                                                                                         *");
		System.out.println("*                                                                                                                         *");
		System.out.println("*                         ___________ _____ _____  _   __  ___________   ___________ _____  ___ _____                     *");
		System.out.println("*                        |_   _| ___ \\_   _/  __ \\| | / / |  _  | ___ \\ |_   _| ___ \\  ___|/ _ \\_   _|                    *");
		System.out.println("*                          | | | |_/ / | | | /  \\/| |/ /  | | | | |_/ /   | | | |_/ / |__ / /_\\ \\| |                      *");
		System.out.println("*                          | | |    /  | | | |    |    \\  | | | |    /    | | |    /|  __||  _  || |                      *");
		System.out.println("*                          | | | |\\ \\ _| |_| \\__/\\| |\\  \\ \\ \\_/ / |\\ \\    | | | |\\ \\| |___| | | || |                      *");
		System.out.println("*                          \\_/ \\_| \\_|\\___/ \\____/\\_| \\_/  \\___/\\_| \\_|   \\_/ \\_| \\_\\____/\\_| |_/\\_/                      *");
		System.out.println("*                                                                                                                         *");
		System.out.println("*                                                         CONSOLE GAME                                                    *");
		System.out.println("*                                                                                                                         *");
		System.out.println("*                                                                                                                         *");
		System.out.println("*                                                                                                                         *");
		System.out.println("*                                                                                                                         *");
		System.out.println("*                                                                                                                         *");
		System.out.println("*                                                                                                                         *");
		System.out.println("***************************************************************************************************************************");
	}
}