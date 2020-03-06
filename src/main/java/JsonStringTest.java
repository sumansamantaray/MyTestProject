import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 */

/**
 * @author samasu5
 *
 */
public class JsonStringTest {

	@JsonProperty("Statuses")
    private String Statuses;

    /*public void setaLogId(String aLogId) {
        this.aLogId = aLogId;
    }

    public String getaLogId() {
        return aLogId;
    }*/
	

    public static void main(String[] args) {

    	StringBuilder sb = new StringBuilder("Suman");
    	sb.append(" "+"Samantaray");
    	System.out.println(sb.toString());
    	
        ObjectMapper objectMapper = new ObjectMapper();

        JsonStringTest test = new JsonStringTest();

        test.setStatuses("anId");

        try {
            System.out.println("Serialization test: " + objectMapper.writeValueAsString(test));
            String jsonInString = new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(test);

            /*String json = "{\"Status\":\"anotherId\"}";

            JsonStringTest anotherTest = objectMapper.readValue(json, JsonStringTest.class);*/

            System.out.println(jsonInString);
//            System.out.println("Deserialization test: " +anotherTest.getStatus());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

	/**
	 * @return the statuses
	 */
	public String getStatuses() {
		return Statuses;
	}

	/**
	 * @param statuses the statuses to set
	 */
	public void setStatuses(String statuses) {
		Statuses = statuses;
	}

}
