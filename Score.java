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
