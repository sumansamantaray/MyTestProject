import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * 
 */

/**
 * @author samasu5
 *
 */
public class ReadFromTextFile {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(ReadFromTextFile.readFromTxtFile());
	}

	
	public static String readFromTxtFile() {
		
		String fileContent = "";
		try {
			byte[] encoded = Files.readAllBytes(Paths.get("./src/main/resources/jsonText.txt"));
			fileContent = new String(encoded, StandardCharsets.UTF_8);
			
		} catch (Exception exp) {
			exp.printStackTrace();
		}
		return fileContent;
	}
}
