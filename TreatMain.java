//User chooses costume
//Program asks if they want to go to next house or go home (y/n), 
//as well as tells them how much candy they have
//If next house, randomized next house, with candy

import java.util.Random;
import java.util.*;

public class TreatMain {
	public static void main(String[] args) {
		Scanner mainInput = new Scanner(System.in);
		int candy = 0, cuteness =0 , scariness=0, response = 0, speed = 0;
		int time = 150;
		Random randTime = new Random ();
		printAdjust();
		printTitle();

		System.out.println("Welcome to Hallowe'en Night, spooky girls and boys of all ages!");
		int choice = costumeBox();

		//There should be a way to make this a method but I kept getting problems
		if(choice==1){
			Princess costume = new Princess();
			scariness = costume.getScary();
			cuteness = costume.getCute();
			speed = costume.getSpeed();
			System.out.println("Here is your gown, your majesty.");
		}
		else if(choice==2){
			Superhero costume = new Superhero();
			scariness = costume.getScary();
			cuteness = costume.getCute();
			speed = costume.getSpeed();
			System.out.println("Here is your cape, this town needs your help!");
		}
		else if(choice ==3){
			Vampire costume = new Vampire();
			scariness = costume.getScary();
			cuteness = costume.getCute();
			speed = costume.getSpeed();
			System.out.println("Go forth, you creature of the night.");
		}
		
		while(time != 0) {
			System.out.println("\nWhat would you like to do next?");
			System.out.println("[1] Go to next house\n[2] Check candy levels\n[3] Check time\n[4] Go home.");
			response = mainInput.nextInt();
			int houseTime = randTime.nextInt(9) + 1;
			
			time = timeCheckAction(houseTime,time);
			
			if(response == 1) {
				if(time <= 0){
					break;
				}
				else{
				
				House newHouse = new House();
				candy += newHouse.outputCandy(scariness,cuteness);
				time -= treatSpeed(houseTime, speed);
				System.out.println(time);
				}
			}
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
				System.out.println(time);
				}
			}
			else if(response == 3) {
				if(time <= 0){
					break;
				}
				else{
				time--;
				timeCheck(time);
				System.out.println(time);
				}
			}
			else if(response == 4) {
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
			System.out.println("You have "+ minLeft+" min left to trick or treat!");
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
}