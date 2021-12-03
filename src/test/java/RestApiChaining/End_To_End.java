package RestApiChaining;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class End_To_End {
	@Test
	public void Test1() {
		RestAssured.baseURI="http://localhost:7000";
		RequestSpecification request =RestAssured.given();
		
		Map<String , Object> PostBody= new HashMap<String, Object>();
		PostBody.put("name", "Gagan");
		PostBody.put("salary", "3000");
		
		Response PostResponse=request.contentType(ContentType.JSON).accept(ContentType.JSON)
				.body(PostBody).post("employees/create");
		
		String ResponseBody =PostResponse.body().asString();

		System.out.println(ResponseBody);
		
		JsonPath jpath =PostResponse.jsonPath();
		String ResponseID =jpath.get("id").toString();
		
		//==================put call=========
		
		RequestSpecification Putrequest =RestAssured.given();
		Map<String , Object> PutBody= new HashMap<String, Object>();
		PutBody.put("name", "Ram");
		PutBody.put("salary", "3000");
		
		Response PutResponse=Putrequest.contentType(ContentType.JSON).accept(ContentType.JSON)
				.body(PutBody).put("employees/"+ResponseID);
		
		ResponseBody =PutResponse.body().asString();

		System.out.println(ResponseBody);
		
		//===============Delete call=========
		
		RequestSpecification Deleterequest =RestAssured.given();
		Response DeleteResponse=Deleterequest.delete("/employees/"+ResponseID);
		int ActResponse =DeleteResponse.statusCode();
		int ExpResponse=200;
		AssertJUnit.assertEquals(ActResponse, ExpResponse);
		
		//==========================get call
		
		RequestSpecification GetRequest = RestAssured.given();
		
		Response GetResponse = GetRequest.get("/employees/" + ResponseID);
		
		ActResponse = GetResponse.statusCode();
		ExpResponse = 404;
		
		AssertJUnit.assertEquals(ActResponse, ExpResponse);

	}
}
