import org.apache.commons.lang3.StringUtils;

/**
 * 
 */

/**
 * @author samasu5
 *
 */
public class StringUtilsTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(StringUtils.isEmpty(null));
		String number = "00001d000";
		int result = Integer.parseInt(number);
		System.out.println(result);
	}

}
