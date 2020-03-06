import java.io.UnsupportedEncodingException;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

public class ConvertByteAsStringToString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String byteArray = "436F6D70616E793A2052696E672043656E7472616C20436172726965723A20457175696E6978202D20566572697A6F6E20617574686F72697A65732074686520636F6D70616E792061626F766520746F207465726D696E617465206F6E652047696745206F6E746F2074686520457175696E6978";
		byte[] bytes;
		try {
			bytes = Hex.decodeHex(byteArray.toCharArray());
			System.out.println(new String(bytes, "UTF-8"));
		} catch (DecoderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(new String("436F6D70616E793A2052696E672043656E7472616C20436172726965723A20457175696E6978202D20566572697A6F6E20617574686F72697A65732074686520636F6D70616E792061626F766520746F207465726D696E617465206F6E652047696745206F6E746F2074686520457175696E6978"));
	}

}
