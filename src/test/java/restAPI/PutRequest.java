package restAPI;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PutRequest {

	
	@Test
	public void PutCall() {
		
		RestAssured.baseURI="http://localhost:7000";
		RequestSpecification request =RestAssured.given();
		
		Map<String , Object> PostBody= new HashMap<String, Object>();
		PostBody.put("name", "Rob");
		PostBody.put("salary", "8000");
		
		Response res=request.contentType(ContentType.JSON).accept(ContentType.JSON).body(PostBody)
				.put("/employees/5");
		
		String ResponseBody =res.body().asString();

		
		System.out.println("ResponseBody");
		
		int ActResponse =res.statusCode();
		int ExpResponse=200;
		AssertJUnit.assertEquals(ActResponse, ExpResponse);
}
}
