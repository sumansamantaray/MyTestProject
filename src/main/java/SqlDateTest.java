/**
 * 
 */

/**
 * @author samasu5
 *
 */
public class SqlDateTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SqlDateTest().testSqlDateConversion();
	}
	
	public void testSqlDateConversion() {
		Object[] orderDetailsResults = new Object[1];
		java.sql.Date sqlDateExample = new java.sql.Date(134567890);
		orderDetailsResults [0] = (java.sql.Date)sqlDateExample;
		System.out.println(orderDetailsResults[0]);
	}

}
