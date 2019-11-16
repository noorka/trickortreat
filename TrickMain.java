//User chooses costume
//Program asks if they want to go to next house or go home (y/n), 
//as well as tells them how much candy they have
//If next house, randomized next house, with candy

import java.util.*;

public class TrickMain {
	public static void main(String[] args) {
		Scanner mainInput = new Scanner(System.in);
		User player = new User();
			
		int candy = 0, response = 0, trickScore = 0;
		int time = 150;

		//Maybe dulplicate code in House
		Random randTime = new Random ();
		printAdjust();
		printTitle();

		System.out.println("Welcome to Hallowe'en Night, spooky girls and boys of all ages!");
		System.out.println("It is 8:30 pm, you should put on your costume.");
		//Player chooses a costume out of three options
		player.costumeBox();

		//How long it takes to put on each costume
		int changeTime = costumeChangeTime(player.getCostume());
		time-= changeTime;
		
		//Add New Neighborhood
		boolean goodChoice = false;
		Neighborhood currentHood = null;
		do{
			System.out.println("What neighborhood do you want to visit?");
			System.out.println("[1] My neighborhood\n[2] The fancier neighborhood\n[3] The fanciest neighborhood\n");
			Scanner s = new Scanner(System.in);
			int hoodChoice = s.nextInt();
			if((hoodChoice < 4) && (hoodChoice > 0)){
				
				currentHood = new Neighborhood(hoodChoice);
				time -= currentHood.travelTime(hoodChoice);
				
				goodChoice = true;
				
			}
			else{
				goodChoice = false;
			}
		}
		while(goodChoice = false);
		
		
		//Trick or Treat Loop
		while(time != 0) {
			System.out.println("\nWhat would you like to do next?");
			System.out.println("[1] Go to next house\n[2] Check candy levels\n[3] Check trickster score\n[4] Check time\n[5] Go home.");
			response = mainInput.nextInt();

			//How long it takes to travel to the next house
			int houseTime = randTime.nextInt(9) + 1;
			//Check if there is enough time left to perform action
			time = timeCheckAction(houseTime,time);
			
			if(response == 1) {
				if(time <= 0){
					break;
				}
				else{
					System.out.println("\nWould you like to trick or treat?");
					System.out.println("[1] Trick\n[2] Treat");
					response = mainInput.nextInt();
					
					if(response == 1){
						House newHouse = currentHood.nextHouse();
						trickScore += newHouse.trickAttempt(player.getSpeed(), trickScore, newHouse);
						time -= trickSpeed(houseTime, player.getSpeed());
						
					}
					else if(response == 2){
						House newHouse = currentHood.nextHouse();
						candy += newHouse.outputCandy(player.getScary(),player.getCute(), newHouse);
						time -= treatSpeed(houseTime, player.getSpeed());
					}
				}
			}
			else if(response == 2) {
				if(time <= 0){
					break;
				}
				else{
				
				if(candy<1) {
					System.out.println("You have no candy.");
				}
				else {
					System.out.println("You have "+candy+" candies.");
				}
				time--;
				}
			}
			else if(response == 3) {
				if(time <= 0){
					break;
				}
				else{
				System.out.println("You're trickster score is "+ trickScore +".");
				time -= 3;
				}
			}
			else if(response == 4) {
				if(time <= 0){
					break;
				}
				else{
				time--;
				timeCheck(time);
				}
			}
			else if(response == 5) {
				break;
			}
		}
		System.out.println("You end your night with "+candy+" candies and a trickster score of " +trickScore + ".");
		}

	//MAIN METHODS

	public static int costumeChangeTime(int costumeChoice){
		int changeTime = 0;
		if(costumeChoice == 0){ // no costume
			changeTime = 1;
		}
		else if(costumeChoice == 1){ // princess
			changeTime = 30;
		}
		else if(costumeChoice == 2){ // vampire
			changeTime = 15;
		}
		else if(costumeChoice == 3){ // superhero
			changeTime = 10;
		}
		return changeTime;
	}
	
	public static int timeCheckAction(int actionTime, int timeLeft){
		if(actionTime > timeLeft){
			System.out.println("You don't have enough time! Go home!");
			int doneTime = 0;
			return doneTime;
		}
		return timeLeft;
	}
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
	public static int trickSpeed(int houseTime, int costumeSpeed){
		int treatTime = 0;
		
		if(costumeSpeed <= 3){
			treatTime = houseTime + 5;
		}
		else if((costumeSpeed > 3) && (costumeSpeed <= 6)){
			if(houseTime >= 2){
			treatTime = houseTime + 3;
			}
			else{
				treatTime = houseTime + 5;
			}
		}
		else{
			if(houseTime >= 3){
				treatTime = houseTime + 1;
				}
				else{
					treatTime = houseTime + 5;
				}
		}
		
		
		return treatTime;
	}
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
			System.out.println("*                                           When satisfied, press any number                                              *");
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