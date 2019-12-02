/*PSEUDO CODE
 * This class is for the high scores. It implements comparable so we can run a sort on the Array list
 * 
 * It contains variables for initials and the score value.
 * The constructor takes in a String and an int to construct the Score
 * Because this class implements comparable we have to override the compareTo method so it knows what two 
 * variables to use in the sort method.
 * There is a greater than, less than, and equals override too so that the comparison is of the value only
 */
public class Score implements Comparable {
private String initials;
private int value;

public Score (String name, int number){
	this.setInitials(name);
	this.setValue(number);
}

@Override
public int compareTo (Object object){
	Score otherScore = (Score) object;
	int compareValue = otherScore.getValue();
	return (compareValue - this.value);
}

@Override
public boolean equals(Object object) {
	Score otherScore = (Score) object;
	if (value == otherScore.getValue()) {
		return true;
	} else {
		return false;
	}
}

@Override
public String toString() {
	String s = initials + ", " + value + "\n";
	return s;
}

public boolean greaterThan(Object object){
	Score otherScore = (Score) object;
	if (value > otherScore.getValue()) {
		return true;
	} else {
		return false;
	}
}
public boolean lessThan(Object object){
	Score otherScore = (Score) object;
	if (value < otherScore.getValue()) {
		return true;
	} else {
		return false;
	}
}

public String getInitials() {
	return initials;
}
public void setInitials(String initials) {
	this.initials = initials;
}
public int getValue() {
	return value;
}
public void setValue(int value) {
	this.value = value;
}


}
