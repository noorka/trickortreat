import java.util.Random;

// House Objects
public class House {
	private Integer cute;
	private Integer scary;
	private Integer trick;
	private boolean hasBeenVisited;
	private Integer fancyCandy;
	
	public House() {
		//Generates a house with random values
		Random rand1 = new Random();
		Random rand2 = new Random();
		Random rand3 = new Random(); 
		
		this.setCute(rand3.nextInt(11));
		this.setScary(rand2.nextInt(11));
		this.setTrick(rand1.nextInt(11));
		
		this.setHasBeenVisited(false);
		this.fancyCandy = 0;
	}
	public House (int neighborhoodFanciness){
		//Set a house with a specific neighborhood fanciness
		Random rand1 = new Random();
		Random rand2 = new Random();
		Random rand3 = new Random(); 
		
		this.setCute(rand3.nextInt(11));
		this.setScary(rand2.nextInt(11));
		if(neighborhoodFanciness==1){
			this.setTrick(rand1.nextInt(11));
		}
		if(neighborhoodFanciness==2){
			this.setTrick(rand1.nextInt(8));
		}
		if(neighborhoodFanciness==3){
			this.setTrick(rand1.nextInt(6));
		}
		this.setHasBeenVisited(false);
		this.fancyCandy = neighborhoodFanciness;
	}
	
	//Cute Value of House
	private void setCute(int i) {
		this.cute = i;
	}
	public Integer getCute() {
		return cute;	
	}
	
	//Scary Value of House
	private void setScary(int i) {
		this.scary = i;
	}
	public Integer getScary() {
		return scary;	
	}
	public void setFancyCandy(int fanciness){
		fancyCandy = fanciness;
	}

	//User attempts to pull a prank on a house
	public Integer trickAttempt(Integer userSpeed, Integer userTrick, Integer hoodChoice){
		int trickScore = 0, trickLevel = 0, trickFactor = 0;
		trickLevel = this.getTrick();
		
		trickFactor = (userSpeed + userTrick);
		
		
		if(trickFactor > trickLevel){
			System.out.println("Trick success!");
			//Your neighborhood has a less chance of success
			if(hoodChoice==1){
				trickScore = 3;
			}
			if(hoodChoice==2){
				trickScore = 2;
			}
			if(hoodChoice==3){
				trickScore = 1;
			}
		}
		else if(trickFactor < trickLevel){
			System.out.println("Trick fail.");
			if(hoodChoice==1){
				trickScore = -1;
			}
			if(hoodChoice==2){
				trickScore = -2;
			}
			if(hoodChoice==3){
				trickScore = -3;
			}
			
			
		}
		else{
			System.out.println("Trick was lame...");
			trickScore = 0;
			
		}
		
		return trickScore; 
	}

	//Checks user values against house, gives proper amount of candy
	public Integer outputCandy(Integer userScary, Integer userCute){
		int candy = 0;
		int thisCute = this.getCute();
		int thisScary = this.getScary();
		
		if(thisScary > thisCute){ // scary house
			printSpookyHouse();
			System.out.println("BONG -*- BONG -*- BONG");
			System.out.println("*creeeeeeeek*");
			if(userScary <= 3){
				System.out.println("\"You look ... interesting.\"");
				candy = 1*fancyCandy;
				System.out.println("+1 candy");
			}
			else if((userScary > 3) && (userScary <= 6)){
				System.out.println("\"Nice costume.\"");
				candy = 2*fancyCandy;
				System.out.println("+2 candy");
			}
			else{
				System.out.println("\"Spooktacular costume!\"");
				candy = 3*fancyCandy;
				System.out.println("+3 candy");
			}
		
		}
		else if (thisCute > thisScary){ // cute house
			printCuteHouse();
			System.out.println("Ding a ling a ling-!");
			if(userCute <= 3){
				System.out.println("\"Goodness, what a costume.\"");
				candy = 1;
				System.out.println("+1 candy");
			}
			else if((userCute > 3) && (userCute <= 6)){
				System.out.println("\"Nice costume.\"");
				candy = 2;
				System.out.println("+2 candy");
			}
			else{
				System.out.println("\"You look boo-tiful!\"");
				candy = 3;
				System.out.println("+3 candy");
			}
		}
		else{ //neutral house
			printNormalHouse();
			candy = 2; 
			System.out.println("Ding-dong");
			System.out.println("\"Happy Halloween!\"");
			System.out.println("+2 candy");
		}
		return candy;
	}

	//Cute Houses
	public static void printCuteHouse(){
		Random rand1 = new Random();
		int houseNumber = rand1.nextInt(9999-1000) + 1000;
		//Art by Igbeard at https://www.asciiart.eu/buildings-and-places/houses
		System.out.println("***************************************************************************************************************************");
		System.out.println("*                                                                                                                         *");
		System.out.println("*        [::]                                                                                                             *");
		System.out.println("*        [::]   _......_                                                                                                  *");
		System.out.println("*        [::].-'      _.-`.                                                                                               *");
		System.out.println("*        [:.\'    .-. \'-._.-`.                                                                                             *");
		System.out.println("*        [/ /\\   |  \\        `-..                                                                                         *");
		System.out.println("*        / / |   `-.'      .-.   `-.                                                                                      *");
		System.out.println("*       /  `-'            (   `.    `.                                                                                    *");
		System.out.println("*      |           /\\      `-._/      \\                                                                                   *");
		System.out.println("*      '    .'\\   /  `.           _.-'|                                                                                   *");
		System.out.println("*     /    /  /   \\_.-'        _.':;:/                                                                                    *");
		System.out.println("*   .'     \\_/             _.-':;_.-'                                                                                     *");
		System.out.println("*  /   .-.             _.-' \\;.-'                                                                                         *");
		System.out.println("* /   (   \\       _..-'     |                                                                                             *");
		System.out.println("* \\    `._/  _..-'    .--.  |                                                                                             *");
		System.out.println("*  `-.....-'/  _ _  .'    '.|                                                                                             *");
		System.out.println("*           | |_|_| |      | \\        O           ______                                                                  *");
		System.out.println("*           | |_|_| |      | |      \\/|\\         | "+houseNumber+" |                                                                 *");
		System.out.println("*          /  ''''' |     o|  \\       | \\        | CUTE |                                                                 *");
		System.out.println("*      :;  |        |      |  |/     / \\[]       |__CT__|                                                                 *");
		System.out.println("*       ;: `-.._    /__..--'\\.' ;:  /   \\           ||                                                                    *");
		System.out.println("*           :;  `--' :;   :;                 .,.   .||.,. .                                                               *");
		System.out.println("*                                                                                                                         *");
		System.out.println("***************************************************************************************************************************");
	}
	//Spooky House
	public static void printSpookyHouse(){
		Random rand1 = new Random();
		int houseNumber = rand1.nextInt(9999-1000)+1000;
		//Art by Igbeard at https://www.asciiart.eu/holiday-and-events/halloween
		System.out.println("***************************************************************************************************************************");
		System.out.println("*                                                                                                                         *");
		System.out.println("*                                               ,           ^'^  _                                                        *");
		System.out.println("*                                               )               (_) ^'^                                                   *");
		System.out.println("*          _/\\_                    .---------. ((        ^'^                                                              *");
		System.out.println("*          (('>                    )`'`'`'`'`( ||                 ^'^                                                     *");
		System.out.println("*     _    /^|                    /`'`'`'`'`'`\\||           ^'^                                                           *");
		System.out.println("*     =>--/__|m---               /`'`'`'`'`'`'`\\|                                                                         *");
		System.out.println("*          ^^           ,,,,,,, /`'`'`'`'`'`'`'`\\      ,                                                                  *");
		System.out.println("*                      .-------.`|`````````````|`  .   )                                                                  *");
		System.out.println("*                     / .^. .^. \\|  ,^^, ,^^,  |  / \\ ((                                                                  *");
		System.out.println("*                    /  |_| |_|  \\  |__| |__|  | /,-,\\||                                                                  *");
		System.out.println("*         _         /_____________\\ |\")| |  |  |/ |_| \\|                                                                  *");
		System.out.println("*        (\")         |  __   __  |  '==' '=='  /_______\\       _                                                          *");
		System.out.println("*       (' ')        | /  \\ /  \\ |   _______   |,^, ,^,|    (\")           O                                               *");
		System.out.println("*        \\  \\        | |--| |--| |  ((--.--))  ||_| |_||   (' ')        \\/|\\         ______                               *");
		System.out.println("*      _  ^^^ _      | |__| |(\"| |  ||  |  ||  |,-, ,-,|   /  /           | \\       | "+houseNumber+" |                              *");
		System.out.println("*    ,' ',  ,' ',    |           |  ||  |  ||  ||_| |_||   ^^^           / \\[]      |SCARY |                              *");
		System.out.println("* .,,|RIP|,.|RIP|,.,,'==========='==''=='==''=='=======',,....,,,,.,... /   \\       |__ST__|                              *");
		System.out.println("*                                                                                      ||                                 *");
		System.out.println("*                                                                                      ||                                 *");
		System.out.println("***************************************************************************************************************************");
	}
	//Neutral House
	public static void printNormalHouse(){
		Random rand1 = new Random();
		int houseNumber = rand1.nextInt(9999-1000)+1000;
		// Art by Ric_Hotchkiss_sdrc_com at https://www.asciiart.eu/buildings-and-places/houses
		System.out.println("***************************************************************************************************************************");
		System.out.println("*                                                                                                                         *");
		System.out.println("*                                                                                                                         *");
		System.out.println("*                                                                                                                         *");
		System.out.println("*              /\\                                                                                                         *");
		System.out.println("*  =====      /  \\                                                                                                        *");
		System.out.println("* _|___|_____/ __ \\____________                                                                                           *");
		System.out.println("*|::::::::::/ |  | \\:::::::::::|                                                                                          *");
		System.out.println("*|:::::::::/  ====  \\::::::::::|                                                                                          *");
		System.out.println("*|::::::::/__________\\:::::::::|                                                                                          *");
		System.out.println("*|_________| _______ |_________|                                                                                          *");
		System.out.println("*  | ______ | / || \\ | _______ |                                                                                          *");
		System.out.println("*  ||  |   || ====== ||   |   ||                                                                                          *");
		System.out.println("*  ||--+---|| |    | ||---+---||                                                                                          *");
		System.out.println("*  ||__|___|| |   o| ||___|___||        O                                                                                 *");
		System.out.println("*  |========| |____| |=========|      \\/|\\       ______                                                                   *");
		System.out.println("* (^^-^^^^^-|________|-^^^--^^^)        | \\     | "+houseNumber+" |                                                                  *");
		System.out.println("* (,, , ,, ,/________\\,,,, ,, ,)       / \\[]    |NORMAL|                                                                  *");
		System.out.println("*','',,,,' /__________\\,,,',',;;      /   \\     |_BLVD_|                                                                  *");
		System.out.println("*                                                  ||                                                                     *");
		System.out.println("*                                                ..||,.                                                                   *");
		System.out.println("*                                                                                                                         *");
		System.out.println("***************************************************************************************************************************");
	}

	public Integer getTrick() {
		return trick;
	}

	public void setTrick(Integer trick) {
		this.trick = trick;
	}
	public boolean getHasBeenVisited() {
		return hasBeenVisited;
	}

	public void setHasBeenVisited(boolean visit) {
		this.hasBeenVisited = visit;
	}
	
}