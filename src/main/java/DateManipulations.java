import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * 
 */

/**
 * @author samasu5
 *
 */
public class DateManipulations {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Today's Date: "+new Date());
		
		System.out.println("Yesterday's Date: "+yesterday());
		
		convertDateFormat1();
	}

	
	private static Date yesterday() {
	    final Calendar cal = Calendar.getInstance();
	    cal.add(Calendar.DATE, -1);
	    return cal.getTime();
	}
	
	public static void convertDateFormat1() {
		try {
			DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
//			formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
			Date date = (Date)formatter.parse("2013-08-21 00:00:45.0");

			SimpleDateFormat output = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
			output.setTimeZone(TimeZone.getTimeZone("UTC"));
			System.out.println("formatedDate ="+ output.format(date));
		} catch (Exception exp) {
			exp.printStackTrace();
		}
		
		
	}
}
