import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;

import org.apache.commons.codec.binary.Base64;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;


/**
 * 
 */

/**
 * @author samasu5
 *
 */
public class GetAccessTokenOauth {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		SimpleClientHttpRequestFactory clientHttpRequestFactory = new SimpleClientHttpRequestFactory();
		Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("sacproxy.suman.com", 5150));
		clientHttpRequestFactory.setProxy(proxy);
		
		
		StringBuilder url = new StringBuilder("https://my.suman.com/services/oauth2/authorize?");
		String clientId = "3MVG9PerJEe9i8iLGPerg5QJtFVONBAgZIXwinFgaqFnn0UvxYRGBKhpe_E5O_VKCboR5Y3FS4cX3RrXoqMje";
        String clientSecret = "4328403019391412923";
        String redirectUri = "https://my.suman.com/services/oauth2/success";
//        String authString = clientId + ":" + clientSecret;
        url = url.append("client_id="+clientId+"&redirect_uri="+redirectUri+"&response_type=code");
//		byte[] base64CredsBytes = Base64.encodeBase64(authString.getBytes());
//		String base64Creds = new String(base64CredsBytes);
		
		HttpHeaders headers = new HttpHeaders();
//		headers.add("Authorization", "Basic " + base64Creds);
		headers.add("content-type", "application/x-www-form-urlencoded");
//		headers.add("grant_type", "authorization_code");
		
		
		System.out.println(url.toString());
		HttpEntity<String> request = new HttpEntity<String>(headers);
//		ResponseEntity<?> response = new RestTemplate().postForEntity(url, request, responseType)(url, HttpMethod.POST, request, ResponseBody.class);
		ResponseEntity<String> response = new RestTemplate(clientHttpRequestFactory).postForEntity(url.toString(), request, String.class);
		System.out.println("Response"+ response.getBody());
        System.out.println(response.getHeaders().get("Location"));
    }

}
