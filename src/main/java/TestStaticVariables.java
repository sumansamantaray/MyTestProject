import java.time.ZonedDateTime;

/**
 * 
 */

/**
 * @author samasu5
 *
 */
public class TestStaticVariables {

	private static String name = "Suman";
	private static long milliseconds = ZonedDateTime.now().toInstant().toEpochMilli();
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("The time when class was loaded: "+milliseconds);
		System.out.println("Name When the class loaded: "+name);
		new TestStaticVariables().changeStaticVariable("The Don");
		System.out.println("Name changed: "+name);
		long millisecondsInApp = ZonedDateTime.now().toInstant().toEpochMilli();
		System.out.println("The time after method call: "+millisecondsInApp);
		long timeduration = millisecondsInApp - milliseconds;
		System.out.println("Difference in milliseconds: "+timeduration);
		if (timeduration > 1) {
			System.out.println("Print this..duration is more than 1 millisecond");
		}
		
	}
	
	public void changeStaticVariable(String nameChanged) {
		TestStaticVariables.name = nameChanged;
	}

}
