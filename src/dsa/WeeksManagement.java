package dsa;

public class WeeksManagement {

	public static void main(String [] args) {
		
		int d=2;
		int n=19;
		
		int weekBehind = n%7;
	    int daysBehind = d - weekBehind;
	    if (weekBehind>d) {
	        System.out.println (7 + daysBehind);
	    } else {
	        System.out.println (daysBehind);
	    }
	}
}
