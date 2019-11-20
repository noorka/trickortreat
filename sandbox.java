import java.util.*;
public class sandbox {
	public static void main(String[] args) {
		int candy = 0;
		Neighborhood currentHood = new Neighborhood(1);
		House newHouse = currentHood.nextHouse();
		System.out.println(newHouse);
		candy += newHouse.outputCandy(1,1);
	}
}