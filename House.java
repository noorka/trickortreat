import java.util.Random;

// House Objects
public class House {
	private Integer cute;
	private Integer scary;
	private Integer trick;

	// We don't need a constructor with parameters any more,
	// Since the random house is made inside the method here
	
	public House() {
		Random rand1 = new Random();
		Random rand2 = new Random();
		Random rand3 = new Random(); 
		
		this.setCute(rand3.nextInt(11));
		this.setScary(rand2.nextInt(11));
		this.setTrick(rand1.nextInt(11));
	}
	
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

	public Integer trickAttempt(Integer userSpeed, Integer userTrick, House thisHouse){
		int trickScore = 0, trickLevel = 0, trickFactor = 0;
		trickLevel = thisHouse.getTrick();
		
		trickFactor = (userSpeed + userTrick) * 2;
		
		
		if(trickFactor > trickLevel){
			System.out.println("Trick success!");
			trickScore = 1;
		}
		else if(trickFactor < trickLevel){
			System.out.println("Trick fail.");
			trickScore = -1;
			
		}
		else{
			System.out.println("Trick was lame...");
			trickScore = 0;
			
		}
		
		return trickScore; 
	}
	public Integer outputCandy(Integer userScary, Integer userCute, House thisHouse){
		int candy = 0;
		int thisCute = thisHouse.getCute();
		int thisScary = thisHouse.getScary();
		
		if(thisScary > thisCute){ // scary house
			printSpookyHouse();
			System.out.println("BONG -*- BONG -*- BONG");
			System.out.println("*creeeeeeeek*");
			if(userScary <= 3){
				System.out.println("\"You look ... interesting.\"");
				candy = 1;
				System.out.println("+1 candy");
			}
			else if((userScary > 3) && (userScary <= 6)){
				System.out.println("\"Nice costume.\"");
				candy = 2;
				System.out.println("+2 candy");
			}
			else{
				System.out.println("\"Spooktacular costume!\"");
				candy = 3;
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
}