import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

public class RestServiceClient {

	public static void main(String[] args) {

		new RestServiceClient().restClientForFileConversion();
	}
	
	public void restClientForFileConversion() {
		MultiValueMap<String, Object> bodyMap = new LinkedMultiValueMap<>();
	      try {
			bodyMap.add("file", getUserFileResource());
			bodyMap.add("columns", 5);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      HttpHeaders headers = new HttpHeaders();
	      headers.setContentType(MediaType.MULTIPART_FORM_DATA);
	      HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(bodyMap, headers);

	      RestTemplate restTemplate = new RestTemplate();
	     /* ResponseEntity<String> response = restTemplate.exchange("http://localhost:8080/upload",
	              HttpMethod.POST, requestEntity, String.class);*/
	      ResponseEntity<byte[]> response = restTemplate
                  .exchange("http://localhost:9000/tocsv", HttpMethod.POST, requestEntity, byte[].class);
	      System.out.println("response status: " + response.getStatusCode());
	      System.out.println("response body: " + new String(response.getBody()));
	}
	
	public static Resource getUserFileResource() throws IOException {
	      //todo replace tempFile with a real file
	      /*Path tempFile = Files.createTempFile("./src/main/resources/VSIB_EC2_November2019", ".xlsx");
	      Files.write(tempFile, "some test content...\nline1\nline2".getBytes());
	      System.out.println("uploading: " + tempFile);*/
	      File file = new File("./src/main/resources/VSIB_EC2_November2019.xlsx");
	      //to upload in-memory bytes use ByteArrayResource instead
	      return new FileSystemResource(file);
	  }

}
