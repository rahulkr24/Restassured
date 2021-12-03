package restAPI;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DeleteRequest {

	@Test
	public void PutCall() {
		
		RestAssured.baseURI="http://localhost:7000";
		RequestSpecification request =RestAssured.given();
		Response res=request.delete("/employees/8");
		int ActResponse =res.statusCode();
		int ExpResponse=200;
		AssertJUnit.assertEquals(ActResponse, ExpResponse);
}
}
