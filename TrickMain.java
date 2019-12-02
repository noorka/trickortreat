/* PSEUDO CODE
 * This is for the overall game play, some of the functions mentioned exist inside other classes
 * 
 * File IO for the high score boards for tricking and treating is set up and scores are processed
 * into ArrayLists
 * User adjust screen for graphics. 
 * The base user, candy, trick score, response, and time (150 minutes) are set.
 * User enters a three character name for the leaderboard
 * User selects a costume
 * 	-their costume selection impacts the amount of time they have eg a more complicated costume (princess)
 * 	takes more time to put on.
 * User selects a neighborhood
 * 	-the fancier the neighborhood the longer it takes to get their, but the more candy you could get and the 
 * 	more houses there are to interact with
 * User selects one of five options: next house, check candy, check trickster score, check time, or go home
 * 	- next house lets user pick between tricking or treating and an appropriate adjustment is made to
 * 	their scores depending upon what random amount of candy/trick success they get.
 * 	- check candy allows user to check how much candy they currently have in their back. minimally impacts time
 * 	- check trickster score allows user to check how successful of a trickster they are. minimally impacts time
 * 	- check time allows user to see how much time they have left, does not impact time
 * 	- go home ends the game early
 * If a user selects to go home, runs out of time, or runs out of houses their ending candy and trickster
 * values are printed. Their scores may be added to the leaderboard if they qualify
 * Leaderboard values overwrite the input file with the new values.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.*;

public class TrickMain {
	public static void main(String[] args) {
		Scanner mainInput = new Scanner(System.in);
		String fileTreat = "treatHighScore.txt";
		Scanner scoreScn = null;
		ArrayList<Score> highestTreat;
		ArrayList<Score> highestTrick;
		User player = new User();

		try{
			scoreScn = new Scanner (new File(fileTreat));
		}catch(FileNotFoundException fnf){
			System.err.println("File not found.");
			System.out.println("There are no treat high scores!");
			scoreScn.close();
			System.exit(1);
		}
		highestTreat = processHighScore(scoreScn);
		scoreScn.close();
		
		String fileTrick = "trickHighScore.txt";
		
		try{
			scoreScn = new Scanner (new File(fileTrick));
		}catch(FileNotFoundException fnf){
			System.err.println("File not found.");
			System.out.println("There are no trick high scores!");
			scoreScn.close();
			System.exit(1);
		}
		
		highestTrick = processHighScore(scoreScn);
		scoreScn.close();		
		
		//************************************
		int candy = 0, response = 0, trickScore = 0;
		int time = 150;
		String playerName;
		
		Random randTime = new Random ();
		printAdjust();
		printTitle();

		System.out.println("Welcome to Hallowe'en Night, spooky girls and boys of all ages!");
		playerName = askName();
		System.out.println("It is 8:30 pm, you should put on your costume.");
		//Player chooses a costume out of three options
		player.costumeBox();

		//How long it takes to put on each costume
		int changeTime = costumeChangeTime(player.getCostume());
		time-= changeTime;
		
		//Add New Neighborhood
		boolean goodChoice = false;
		Neighborhood currentHood = new Neighborhood(1);
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
						if(newHouse == null){
							System.out.println("There are no more houses in this neighborhood.");
							break;
						}
						trickScore += newHouse.trickAttempt(player.getSpeed(), trickScore);
						newHouse.setHasBeenVisited(true);
						time -= trickSpeed(houseTime, player.getSpeed());
						
					}
					else if(response == 2){
						House newHouse = currentHood.nextHouse();
						if(newHouse == null){
							System.out.println("There are no more houses in this neighborhood.");
							break;
						}
						candy += newHouse.outputCandy(player.getScary(),player.getCute());
						newHouse.setHasBeenVisited(true);
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
		// checking if the score belongs in the high scores and adding them
		scoreCheck(highestTreat, candy, playerName);
		scoreCheck(highestTrick, trickScore, playerName);
		// printing the high scores and outputting them to the file
		System.out.println("TREAT HIGH SCORES:");
		outputHighScore(printScores(highestTreat), fileTreat);
		System.out.println("TRICK HIGH SCORES:");
		outputHighScore(printScores(highestTrick), fileTrick);
		}

	//MAIN METHODS ******************************************************************************************************
	
	// Asks user to create a three character name, checks for only three characters.
	public static String askName(){
		Scanner key = new Scanner(System.in);
		String playerName;
		boolean goodNm = false;
		do{
		System.out.println("Please enter three characters for the high-score board.");
		playerName = key.next().toUpperCase();
		if((playerName.length() > 1) && (playerName.length() <= 3)){
			goodNm = true;
		}
		else if(playerName.length() < 1){
			System.out.println("This is too short. Try again.");
		}
		else{
			System.out.println("This is too long. Try again.");
		}
		}while(goodNm == false);
		
		return playerName;
	}
	
	//creates a new score, adds it to the arraylist, removes any scores that go beyond the top 10
	public static void scoreCheck(ArrayList<Score> thisArry, int score, String playerName){
		Score newScore = new Score(playerName,score);
		thisArry.add(newScore);
		Collections.sort(thisArry);
		for(int i = 9; i < thisArry.size(); i++){
			thisArry.remove(i);
		}
	}
	// formats the scores for printing and for file output
	public static String printScores(ArrayList<Score> thisArry){
		String finalScores = "";
		for(int i = 0; i < thisArry.size(); i++){
			finalScores += thisArry.get(i).toString();
		}
		System.out.print(finalScores);
		return finalScores;
	}
	// overwrites the initial files with the new high score data
	public static void outputHighScore(String output, String fileName){
		try {
			PrintWriter pw = new PrintWriter(new FileOutputStream(fileName, false));
			pw.append(output);
			pw.close();
		} catch (FileNotFoundException e) {
			System.err.println("Cannot save high scores.");
		}
		
	}
	// takes formatted data out of the file, creates a new Score, puts all the scores into an arraylist
	public static ArrayList<Score> processHighScore(Scanner sc){
		ArrayList<Score> myArry = new ArrayList<Score>();
		String lineInput;
		int i = 0;
		do{
			Integer num = 0;
			lineInput = sc.nextLine();
			String[] lineData = lineInput.split(",");
			num= Integer.valueOf(lineData[1].trim());
			Score thisScore = new Score(lineData[0], num);
			myArry.add(thisScore);
			i++;
		}while(sc.hasNext());
		return myArry;
	}
// how much time it takes a user to change into their costume depending upon their choice
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
	// checks if the user has enough time to complete a certain action and returns 0 if there is not 
	// enough time to complete it.
	public static int timeCheckAction(int actionTime, int timeLeft){
		if(actionTime > timeLeft){
			System.out.println("You don't have enough time! Go home!");
			int doneTime = 0;
			return doneTime;
		}
		return timeLeft;
	}
	// formatting the time left into hours and minutes
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
	// how quickly a user can get candy depending upon their costume choice's speed. 
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
	// how quickly a user can trick a house depending upon their costume choice's speed. 
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
	// printing out the adjustment screen so the user can view the graphics 
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
	// printing out the game title screen
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