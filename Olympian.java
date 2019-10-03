import java.util.ArrayList;

public class Olympian {
	private String name;
	private String sport;
	private Integer numMedals;
	private String event;

	/** This constructs the Olympian class with all its required elements.
	 * 
	 * @param name, sport, number of medals, and event
	 * @return none 
	 * */
	public Olympian(String name, String sport, Integer numMedals, String event) {
		this.setName(name);
		this.setSport(sport);
		this.setNumMedals(numMedals);
		this.setEvent(event);
	}
	/** This method formats the string output of the olympians.  
	 * 
	 * @param none
	 * @return String
	 * */
	public String toString() {
		
		String printOut = String.format("%-21s%-18s%7s %-24s", getName(), getSport() , getNumMedals(), getEvent());
		return printOut;
	}
	/** This method for-eachs through each Olympian in the ArrayList and gets the number of medals then adds this to the
	 * total number of medals won.  
	 * 
	 * @param Array List of Olympians
	 * @return int of total medals
	 * */
	public static int computeMedals(ArrayList<Olympian> athletes) {
		int totMedals = 0;
		for (Olympian athlete : athletes) {
			totMedals += athlete.getNumMedals();
		}
		return totMedals;
	}
	/** This method gets the name.  
	 * 
	 * @param none
	 * @return String
	 * */
	public String getName() {
		return name;
	}
	/** This method sets the name.  
	 * 
	 * @param String
	 * @return none
	 * */
	public void setName(String name) {
		this.name = name;
	}
	/** This method gets the sport.  
	 * 
	 * @param none
	 * @return String
	 * */
	public String getSport() {
		return sport;
	}
	/** This method sets the sport.  
	 * 
	 * @param String
	 * @return none
	 * */
	public void setSport(String sport) {
		this.sport = sport;
	}
	/** This method gets the Event.  
	 * 
	 * @param none
	 * @return String
	 * */
	public String getEvent() {
		return event;
	} 
	/** This method sets the event.  
	 * 
	 * @param String
	 * @return none
	 * */
	public void setEvent(String event) {
		this.event = event;
	}
	/** This method gets the number of medals.  
	 * 
	 * @param none
	 * @return Integer
	 * */
	public Integer getNumMedals() {
		return numMedals;
	}
	/** This method sets the number of medals.  
	 * 
	 * @param Integer
	 * @return none
	 * */
	public void setNumMedals(Integer numMedals) {
		this.numMedals = numMedals;
	}

};
