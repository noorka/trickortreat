import java.util.*;
import java.util.Random;

public class Neighborhood {
	
	private int numberOfHouses;
	private int fanciness;
	private ArrayList currentHood;

	public void buildHood(int fancy){
		int number;
		Random rand1 = new Random();
		if(fancy == 1){
			number = rand1.nextInt(40-10) + 10;
		}
		else if(fancy == 2){
			number = rand1.nextInt(50-20) + 20;
		}
		else{
			number = rand1.nextInt(60-30) + 30;
		}
		ArrayList thisHood = new ArrayList(number);
		
	}
}
