//User chooses costume
//Program asks if they want to go to next house or go home (y/n), 
//as well as tells them how much candy they have
//If next house, randomized next house, with candy


import java.util.*;

public class TreatMain {
	public static void main(String[] args) {
		Scanner mainInput = new Scanner(System.in);
		int candy = 0, cuteness =0 , scariness=0, response = 0;

	
		printAdjust();
		printTitle();

		System.out.println("Welcome to Hallowe'en Night, spooky girls and boys of all ages!");
		int choice = costumeBox();

		//There should be a way to make this a method but I kept getting problems
		if(choice==1){
			Princess costume = new Princess();
			scariness = costume.getScary();
			cuteness = costume.getCute();
			System.out.println("Here is your gown, your majesty.");
		}
		else if(choice==2){
			Superhero costume = new Superhero();
			scariness = costume.getScary();
			cuteness = costume.getCute();
			System.out.println("Here is your cape, this town needs your help!");
		}
		else if(choice ==3){
			Vampire costume = new Vampire();
			scariness = costume.getScary();
			cuteness = costume.getCute();
			System.out.println("Go forth, you creature of the night.");
		}
		
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
	public static void printAdjust(){
		Scanner mainInput = new Scanner(System.in);
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

			int s1 = mainInput.nextInt();

			if(s1==1){
				break;
			}
		}
	}
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
	public static void printNormalHouse(){
		System.out.println("***************************************************************************************************************************");
		System.out.println("*              /\\                                                                                                         *");
		System.out.println("*  =====      /  \\                                                                                                        *");
		System.out.println("* _|___|_____/ __ \\____________                                                                                           *");
		System.out.println("*|::::::::::/ |  | \\:::::::::::|                                                                                          *");
		System.out.println("*|:::::::::/  ====  \\::::::::::|                                                                                          *");
		System.out.println("*|::::::::/__________\\:::::::::|                                                                                          *");
		System.out.println("*|_________|  ____  |__________|                                                                                          *");
		System.out.println("*  | ______ | / || \\ | _______ |                                                                                          *");
		System.out.println("*  ||  |   || ====== ||   |   ||                                                                                          *");
		System.out.println("*  ||--+---|| |    | ||---+---||                                                                                          *");
		System.out.println("*  ||__|___|| |   o| ||___|___||                                                                                          *");
		System.out.println("*  |========| |____| |=========|                                                                                          *");
		System.out.println("* (^^-^^^^^-|________|-^^^--^^^)                                                                                          *");
		System.out.println("* (,, , ,, ,/________\\,,,, ,, ,)                                                                                          *");
		System.out.println("*','',,,,' /__________\\,,,',',;;                                                                                          *");
		System.out.println("*                                                                                                                         *");
		System.out.println("*                                                                                                                         *");
		System.out.println("*                                                                                                                         *");
		System.out.println("*                                                                                                                         *");
		System.out.println("*                                                                                                                         *");
		System.out.println("*                                                                                                                         *");
		System.out.println("***************************************************************************************************************************");
	}
}