/**
 * 
 */

/**
 * @author samasu5
 *
 */
public class TestNullString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TestNullString().testNullForString(null);
		System.out.println("Test Complete");
		
	}

	
	public String testNullForString(Object o) {
		if (o == null) {
			System.out.println("Object is null");
			return "";
		} else {
			System.out.println("Object is NOT null");
			return o.toString();
		}
	}
}
