import java.util.*;
import java.util.Random;

public class Neighborhood {
	
	private int numberOfHouses;
	private int fanciness;
	private int[][] currentHood;

	public Neighborhood(int fancy){
		int number;
		Random rand1 = new Random();
		int[][] myHouses = null;
		
		if(fancy == 1){
			number = rand1.nextInt(40-10) + 10;
		}
		else if(fancy == 2){
			number = rand1.nextInt(50-20) + 20;
		}
		else{
			number = rand1.nextInt(60-30) + 30;
		}
		//ArrayList thisHood = new ArrayList(number);
		
		for(int i = 0; i <= number; i++){
			myHouses[i][0] = 0;
		}
		this.currentHood = myHouses;
		this.fanciness = fancy;
		this.numberOfHouses = number;
	}
	
	public void beenToHouse(int houseNum){
		currentHood[houseNum][0]=1;
	}
	
	public int travelTime(int fancy){
		int walkTime;
		
		if(fancy == 1){
			walkTime = 2;
		}
		else if(fancy == 2){
			walkTime = 10;
		}
		else{
			walkTime = 30;
		}
		
		return walkTime;
	}
}
