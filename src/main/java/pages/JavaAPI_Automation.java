package pages;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;

import org.json.JSONObject;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import io.restassured.path.json.JsonPath;

public class JavaAPI_Automation {
	String platformURL = "https://api.test.hotelbeds.com";

	// Begin UTC creation

	double utcDate = Math.floor(new Date().getTime() / 1000);

	// Begin Signature Assembly

	String assemble = ("wz6v7pqher4kebkutqsmkzap" + "FnHhyj9UYg" + utcDate);

	String output;
	String output1;

	public static void main(String[] args) {
		JavaAPI_Automation obj = new JavaAPI_Automation();
		System.out.println(obj.xSignature());
		obj.APICall();

	}

	public JavaAPI_Automation APICall() {
		try {
			Client client = Client.create();
			WebResource webResource = client.resource(platformURL + "/hotel-api/1.0/hotels");
			System.out.println("POST REQUEST: " + webResource);
			String input1 = "{\"stay\":{\"checkIn\":\"2019-11-15\",\"checkOut\":\"2019-11-20\"},\"occupancies\":[{\"rooms\":1,\"adults\":1,\"children\":0}],\"hotels\":{\"hotel\":[114959,195432]}}";
			JSONObject jO1 = new JSONObject(input1);
			JsonPath jp1 = new JsonPath(jO1.toString());
			System.out.println("json request is :" + jp1.prettify());
			ClientResponse response = webResource.type("application/json").header("Api-key", "wz6v7pqher4kebkutqsmkzap")
					.header("X-Signature", xSignature()).accept("application/json").post(ClientResponse.class, input1);
			System.out.println("Output from Server .... \n");
			output1 = response.getEntity(String.class);
			// JSONObject output2 = new JSONObject(output1);
			//JsonPath jp = new JsonPath(output2.toString());
			System.out.println("String of Json Post Request:" + output1);

			/*
			 * disputeid = jp.getString("disputeId"); System.out.println("Dispute ID:  " +
			 * disputeid);
			 */

		} catch (Exception e) {

			e.printStackTrace();

		}
		return this;

	}

	public String xSignature() {
		// Begin SHA-256 Encryption

		MessageDigest digest = null;
		try {
			digest = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		byte[] byteOfTextToHash = assemble.getBytes(StandardCharsets.UTF_8);
		byte[] hashedByetArray = digest.digest(byteOfTextToHash);
		String encoded = Base64.getEncoder().encodeToString(hashedByetArray);
		return encoded;
	}

}
