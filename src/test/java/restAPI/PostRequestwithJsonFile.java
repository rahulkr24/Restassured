package restAPI;


import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;


import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.reporters.Files;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostRequestwithJsonFile {
		
	@Test
	public void PostCall() throws IOException{
		
		RestAssured.baseURI="http://localhost:7000";
		RequestSpecification request =RestAssured.given();
		
		String JsonBody= ReadJsonsFile("data.json");
		
		Response res=request.contentType(ContentType.JSON).accept(ContentType.JSON)
				.body(JsonBody.toString()).post("employees/create");
		
		String ResponseBody =res.body().asString();

		
		System.out.println(ResponseBody);
		
		int ActResponse =res.statusCode();
		int ExpResponse=201;
		AssertJUnit.assertEquals(ActResponse, ExpResponse);
		
		JsonPath jpath = res.jsonPath();
        
        String ActName = jpath.get("name");
        String ExpName = "James";
        AssertJUnit.assertEquals(ActName, ExpName);

}
	public  String ReadJsonsFile(String FileName) throws IOException{
		
		String data= new  String()
;		return data;
	}
}
