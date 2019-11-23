import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
public class sandbox {
	public static void main(String[] args) {
		String fileName = "treatHighScores.txt";
		Scanner scoreScn = null;
		String[][] highestTreat;
		
		try{
			scoreScn = new Scanner (new File(fileName));
		}catch(FileNotFoundException fnf){
			System.err.println("File not found.");
			System.out.println("There are no treat high scores!");
			scoreScn.close();
			System.exit(1);
		}
		highestTreat = processHighScore(scoreScn);

	}
	public static String[][] processHighScore(Scanner sc){
		String[][] myArry;
		String lineInput;
		int i = 0;
		//Integer num = 0;
		lineInput = sc.nextLine();
		
		while(sc.hasNext()){
			String[] lineData;
			lineData = lineInput.split("[,]");
			myArry[i] = lineData[0];
			myArry[i][0] = lineData[1];
			//num= Integer.valueOf(lineData[2].trim());
			i++;
		}
		return myArry;
	}
}