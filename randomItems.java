import java.util.*;

public class randomItems {
	private Integer speed;
	private Integer cute;
	private Integer scary;
	private Integer movement;


	public static int[][] randomCostumeItems(){
		//[0] = Speed
		//[1] = Cuteness
		//[2] = Scariness
		//[3] = Movement

		int tiara [] = new int[4];
		tiara[0]=0;
		tiara[1]=2;
		tiara[3]=(-2);
		tiara[4]=(-1);

		int fakeFangs[] = new int[4];
		fakeFangs[0]=0;
		fakeFangs[1]=(-2);
		fakeFangs[2]=2;
		fakeFangs[3]=0;

		int rollerSkates [] = new int[4];
		rollerSkates[0]=2;
		rollerSkates[1]=0;
		rollerSkates[2]=0;
		rollerSkates[3]=1;

		int[][] 2dArr = {tiara, fakeFangs, rollerSkates};
		return 2dArr;
	}
	public int[] genRandItem(){
		int outPutArr[] = new int[4];
		
		return outPutArr[];
	}
}