package restAPI;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetRequest_Post {

	@Test
	public void PostCall() {
		
		RestAssured.baseURI="http://localhost:7000";
		RequestSpecification request =RestAssured.given();
		
		Response res=request.contentType(ContentType.JSON).accept(ContentType.JSON).body("{\n" + 
				"    \"name\": \"Ramesh\",\n" + 
				"    \"salary\": \"8000\"\n" + 
				"}").post("employees/create");
		
		String ResponseBody =res.body().asString();

		
		System.out.println("ResponseBody");
}
}
