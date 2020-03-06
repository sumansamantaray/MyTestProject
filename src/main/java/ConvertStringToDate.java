import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;



/**
 * 
 */

/**
 * @author samasu5
 *
 */
public class ConvertStringToDate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*convertStringToDate("20190423");//("20181217 0930");
		justAnotherConversion ("04/23/2019");*/
		/*Calendar cal = new GregorianCalendar();
		System.out.println(cal.getTime());*/
//		convertDateTimeZone();
//		new ConvertStringToDate().convertOneFormatToOther("20190917");
//		convertDate("Date");//("2018-07-30T14:39:00.000+0000");//("2019-04-18T09:18:30.000+0000");
		convertStringToDate("20190418");
	}

	public Date convertToDate(String dateString) {
		/*Date tradeDate = new Date();
		try {
		    String oldFormat = "yyyyMMdd";
		    String newFormat = "yyyy-MM-dd'T'HH:mm:ss";
		    SimpleDateFormat sdf = new SimpleDateFormat(oldFormat);
		    try {
		        Date newDate = sdf.parse(dateString);
		        sdf.applyPattern(newFormat);
		        System.out.println(sdf.format(newDate));
		    } catch (ParseException e) {
		        e.printStackTrace();
		    }*/
		try {
			/*DateFormat df = new SimpleDateFormat("yyyyMMdd");
			Date date = df.parse(dateString);
			Calendar cal = new GregorianCalendar();
			cal.setTime(date);
			System.out.println(cal.getTime());*/
//			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd HHmm");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
			SimpleDateFormat output = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
//			Date d = sdf.parse("20180830 1523");
			Date d = sdf.parse("2018-12-08T02:59:31.278-05:00");
			String formattedTime = output.format(d);
			System.out.println("************formattedTime******* "+formattedTime);
		} catch (Exception exp) {
			exp.printStackTrace();
		}
		
		/*DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM/yyyy HH:mm:ss");
		DateTime dt = formatter.parseDateTime(dateString);*/
		return null;
	}
	
	private static Date convertStringToDate(String dateAsString) {
		Date newDate = new Date();
//		dateAsString = "20181217 0930";
		if (!StringUtils.isEmpty(dateAsString)) {
			Calendar cal = new GregorianCalendar();
			try {
				if (dateAsString.length() == 8) {
					dateAsString = dateAsString + " 0000"; // Formatting to the same date pattern
				}
				DateFormat df = new SimpleDateFormat("yyyyMMdd HHmm");
//				df.setTimeZone(TimeZone.getTimeZone("UTC"));
				Date date = df.parse(dateAsString);
				cal.setTime(date);
			} catch (ParseException exp) {
//				LOGGER.error("[convertStringToDate] Exception occurred while converting the date "+exp.toString());
//				throw new OrderMilestoneApplicationException("Exception occurred while converting the date "+exp.toString());
			} catch (Exception exception) {
				exception.printStackTrace();
			}
			System.out.println(cal.getTime());
			return cal.getTime();
		}
		
		
		return newDate;
	}
	
	private static void convertDateTimeZone() {
		GregorianCalendar c = new GregorianCalendar();
		c.setTime(new Date());
		XMLGregorianCalendar date2 =null;
		try {
			date2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
			System.out.println("Date in local timezone: "+date2);
			DateTimeZone timeZone = DateTimeZone.forID("America/Chicago");
			// Creates DateTime object with information like year, month,
	        // day, hour, minute, second and milliseconds
			DateTime dateTime = new DateTime(date2.getYear(),date2.getMonth(), date2.getDay(), date2.getHour(), date2.getMinute(), date2.getSecond(),date2.getMillisecond(), timeZone);
			DateTime dateTimeUtc = dateTime.toDateTime(DateTimeZone.UTC); 
			Date formattedDate = dateTimeUtc.toLocalDateTime().toDate();
			System.out.println(dateTimeUtc);
			System.out.println("formattedDate: "+formattedDate);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private String convertOneFormatToOther(String dateFormat) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String newFormat = dateFormat;
		try {
			Date d1 = sdf.parse(newFormat);
			sdf.applyPattern("yyyy/MM/dd");
			newFormat = sdf.format(d1);
			System.out.println(newFormat);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return newFormat;
	}
	
	public static String convertDate(String dateString) { 
		final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";
	        try {
	            DateFormat df = new SimpleDateFormat(DATE_FORMAT);
	            SimpleDateFormat output = new SimpleDateFormat("MM/dd/yyyy");
	            Date d = df.parse(dateString);
	            String formattedTime = output.format(d);
	            System.out.println(formattedTime);
	            return formattedTime;
	        } catch (ParseException e) {
	        	System.out.println(dateString);
	            return dateString;
	        }
	}
	
	public static void justAnotherConversion(String dateString) {
		
		String regex = "^\\d{2}\\/\\d{2}\\/\\d{4}$";
		 
		Pattern pattern = Pattern.compile(regex);
		
		Matcher matcher = pattern.matcher(dateString.toString());
		System.out.println(matcher.matches());
		if (dateString != null && dateString.length() == 10 && matcher.matches()) {
			try {
				DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
				Date date = (Date)formatter.parse(dateString);

				SimpleDateFormat output = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
				output.setTimeZone(TimeZone.getTimeZone("UTC"));
				String formatedDate = output.format(date);
				System.out.println("formatedDate : " + formatedDate);
			} catch (Exception exp) {
				exp.printStackTrace();
			}
		}
		
		
	}
}
