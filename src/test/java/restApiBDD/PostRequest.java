package restApiBDD;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class PostRequest {
	@Test
	public void PostCall() {
		
		
		
		
		Map<String , Object> PostBody= new HashMap<String,Object>();
		PostBody.put("name", "Raja");
		PostBody.put("salary", "3000");
		RestAssured.given().baseUri("http://localhost:7000")
							.contentType(ContentType.JSON)
							.accept(ContentType.JSON)
							.body(PostBody)
							.when()
							.post("/employees/create")
							.then()
							.statusCode(201)
							.log()
							.all();
							
		
}
}

