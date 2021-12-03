package restAPI;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostRequestWith_json {

	

	@Test
	public void PostCall() {
		
		RestAssured.baseURI="http://localhost:7000";
		RequestSpecification request =RestAssured.given();
		
		JSONObject PostBody = new  JSONObject();
		PostBody.put("name", "Virat");
		PostBody.put("salary", "3000");
		
		Response res=request.contentType(ContentType.JSON).accept(ContentType.JSON).body(PostBody.toString()).post("employees/create");
		
		String ResponseBody =res.body().asString();

		
		System.out.println("ResponseBody");
		
		int ActResponse =res.statusCode();
		int ExpResponse=201;
		AssertJUnit.assertEquals(ActResponse, ExpResponse);
		
		JsonPath jpath = res.jsonPath();
        
        String ActName = jpath.get("name");
        String ExpName = "Virat";
        AssertJUnit.assertEquals(ActName, ExpName);

		
}
}
