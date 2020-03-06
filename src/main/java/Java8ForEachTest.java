import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.suman.test.ordermilestone.ErrorDetails;

/**
 * 
 */

/**
 * @author samasu5
 *
 */
public class Java8ForEachTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		new Java8ForEachTest().testForEach();
		new Java8ForEachTest().getAttributeNames(null);
	}
	
	public void testForEach() {
		List<ErrorDetails> strList = new ArrayList();
		ErrorDetails errordetails = new ErrorDetails();
		errordetails.setErrorCode("01");
		errordetails.setErrorDescription("Desc");
		strList.add(errordetails);
	/*	if (strList.size() > 0) {
			strList.forEach(str->{
				if ("Desc".equals(str.getErrorDescription())) {
					System.out.println("Successfull");
				}
			});
		}*/
		
	}
	
	public List<String> getAttributeNames(List<ErrorDetails> attributeList) {
		
		List<String> stringList = attributeList.stream().map(ErrorDetails::getErrorCode).collect(Collectors.toList());
		
		return stringList;
	}

}
