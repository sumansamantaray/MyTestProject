import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;


public class CommonTestServiceRestClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		getSidFromAccord("abcd1234", "novalue");
	}

	
	private static void getSidFromAccord(String pon, String ccna) {
		String lod = "";
		
		UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl("http://localhost:9000/getSidFromAccord")//("http://acotpazpa01.suman.com:7001/cafe2/cx/milestone/getLod")//("http://acofrdztw05.ebiz.suman.com:7001/cafe2/cx/milestone/getLod")
				.queryParam("pon", pon)
				.queryParam("ccna", null);
		HttpHeaders headers = new HttpHeaders();
        
        // Request to return JSON format
        headers.setContentType(MediaType.APPLICATION_JSON);
        
//        String targetEndpoint = "http://acofrdztw05.ebiz.suman.com:7001/cafe2/cx/milestone/getLod"; //?pon=R503-JUL13-M1S6&ccna=ATX
        
        HttpEntity<?> requestEntity = new HttpEntity<>(headers);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> serviceResponse = restTemplate.exchange(uriBuilder.toUriString(), HttpMethod.GET, requestEntity, String.class);
        System.out.println("Successfully called the ACCORD LOD service");
	}
}
