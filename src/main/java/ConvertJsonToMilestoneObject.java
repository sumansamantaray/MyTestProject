import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.suman.vsib.vsibmilestonenotification.object.model.MilestoneMajorObjectModel;

public class ConvertJsonToMilestoneObject {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String jsonString = readMessage("commitment_milestone_json.txt");
		
		ObjectMapper mapper = new ObjectMapper();

		//JSON from file to Object
		try {
			MilestoneMajorObjectModel majorMilestone = mapper.readValue(jsonString, MilestoneMajorObjectModel.class);
			System.out.println(majorMilestone.getPon());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static String readMessage(String fileName) {
		StringBuilder sb = new StringBuilder();
		try {
			File file = new File("C:\\Users\\samasu5\\Documents\\CX_Workspace\\MyTestProject\\src\\main\\resources\\"+fileName); 
			  
			  BufferedReader br = new BufferedReader(new FileReader(file)); 
			   
			  String line;
	            while ((line = br.readLine()) != null) {
	                sb.append(line).append("\n");
	            }
//			    st.append(st);
	            br.close();
		} catch(Exception exp) {
			exp.printStackTrace();
		}
		
		return sb.toString();
	}

}
