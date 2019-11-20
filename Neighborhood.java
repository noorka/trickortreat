import java.util.*;

public class Neighborhood {
	
	private int numberOfHouses;
	private int fanciness;
	private House[] currentHood;

	public Neighborhood(int fancy){
		//Number of houses in neighborhood
		int number;
		Random rand1 = new Random();
		//Array to hold all houses in neighborhood
		
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
		House[] myHouses = new House[number];

		for(int i = 0; i < number; i++){
			
			House newHouse = new House(fancy);
			System.out.println(newHouse);

			myHouses[i]= newHouse;
		}

		this.currentHood = myHouses;
		this.fanciness = fancy;
		this.numberOfHouses = number;
	}
	
	public void beenToHouse(int houseNum){
		currentHood[houseNum].setHasBeenVisited(true);
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
	public House nextHouse(){
		for(int i = 0; i< currentHood.length; i++){
			if(currentHood[i].getHasBeenVisited() == false){
				return currentHood[i];
			}
		}
		return null;
	}
}