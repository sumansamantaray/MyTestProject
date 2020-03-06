import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.suman.vsib.vsibmilestonenotification.object.model.MilestoneMajorObjectModel;

public class GenerateJsonFromObjectModel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String jsonInString = "";
		try {
			jsonInString = new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(new MilestoneMajorObjectModel());
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(jsonInString);

	}
	
	

}
