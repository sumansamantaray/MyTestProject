import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

import javax.xml.bind.DatatypeConverter;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;

/**
 * 
 */

/**
 * @author samasu5
 *
 */
public class DecodingBase64Text {

	/**
	 * @param args
	 * @throws DecoderException 
	 * @throws UnsupportedEncodingException 
	 */
	public static void main(String[] args) throws DecoderException, UnsupportedEncodingException {

		new DecodingBase64Text().decodeBase64();
	}
	
	public void decodeBase64() throws DecoderException, UnsupportedEncodingException {
		
		String fileContent = DecodingBase64Text.readFromTxtFile();
		// Get bytes from string

//		fileContent = fileContent.split("/", 1)[0];
		  byte[] byteArray = Base64.decodeBase64(fileContent);
		  
		  try {
	            Files.write(Paths.get("EUCR_Document.xls"), byteArray);
	        } catch (IOException ex) {
	        }
		  System.out.println("File generated successfully");
	}
	
	public static String readFromTxtFile() {
		
		String fileContent = "";
		try {
			byte[] encoded = Files.readAllBytes(Paths.get("./src/main/resources/DLR_Document_Content.txt"));
			fileContent = new String(encoded, StandardCharsets.US_ASCII);
			
		} catch (Exception exp) {
			exp.printStackTrace();
		}
		return fileContent;
	}

	public String readPonFromFile() {
		
		return null;
		
	}
}
