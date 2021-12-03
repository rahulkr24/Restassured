package restAPI;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetRequestWithParam {

	
	@Test
	public void GetCall() {
		
		RestAssured.baseURI="http://localhost:7000";
		RequestSpecification request =RestAssured.given();
		Response response=request.param("id", "1").get("/employees");
		String  Responsebody=response.body().asString();
		System.out.println(Responsebody);
		

		//====================
		
		
		int ActResponse= response.statusCode();
		int Expresponse=200;
		
		AssertJUnit.assertEquals(ActResponse, Expresponse);
		
		
		//========
		
		System.out.println(response.getHeaders());
		
		String ActHeader=response.getHeader("Content-type");
		String ExpHeader="application/json; charset=utf-8";
		
		AssertJUnit.assertEquals(ActHeader, ExpHeader);
		
		//======verify response body
		
		AssertJUnit.assertTrue(Responsebody.contains("Pankaj"));
		
		
		JsonPath jpath = response.jsonPath();
		List<String> Name= jpath.get("name");
		String ActName= Name.get(0);
		String ExpName= "Pankaj";
		
		AssertJUnit.assertEquals(ActName, ExpName);
				
	}
}
