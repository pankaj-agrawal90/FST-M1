import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class GitHub_API {
	
	String ssh_Key = "ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAABgQC/8WxAFpDniuyJ1ohbmpTE4gVWDQ5DOUuN58Z9/2iLqPaxgs871JN3mgr2fwu5YNnQEeDptptccVxQmcg1ruhTCBFco3O+5yi+fJtr9ONKgcNRRmI4tAII7/WVW967vTnNes6qkajjm3Ge0SNApsBk3gJ6UmnXLINlXsd0tykRRILeRNK1kdI72VZVQm8elud1cbwieKzq3xeZ2Jjg9B8iUvSuP75yp+cEhXKsfhj6qSDJZ532XZ6wa9eTj5VyTAxbOJtAdCjHixABMu4augc9pLri4bHSuF2t6s8H7c0oFWvqdCenrxwxxuLlDNyNYzSe02YXVnIS/EdeVgLgz5t8//0CtBe2312CdkXqaaPs2zWCL/bZyyANummmVznuwCcl+8taw0gUR5EJNdOk8xG0kdXifxuQgDn4/yVb7HTs/qcnsnK3JnjFEqe1XzF5rtxfyQadwLdWUY1et+IZJdfM3BdQcZt47/7B7KS/hPkuhK6WjxWz8EP5AUqJYsO9Kgk=";
    int id ;
    //Declaring Request and Response Specifications 
    RequestSpecification request_spec ;
    ResponseSpecification  response_spec;
    
@BeforeClass

public void initialSetup()
{
	
	//Create Request specifcation
	request_spec = new RequestSpecBuilder().addHeader("Authorization","token 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")
			.setContentType(ContentType.JSON)
			.setBaseUri("https://api.github.com")
			.build();
	
	response_spec = new ResponseSpecBuilder()
			.expectContentType("application/json")
			.build();
	}


@Test(priority=1)

public void postrequest() {
	String request_body = "{ \"title\": \"TestAPIKey\", \"key\": \"ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAABgQC/8WxAFpDniuyJ1ohbmpTE4gVWDQ5DOUuN58Z9/2iLqPaxgs871JN3mgr2fwu5YNnQEeDptptccVxQmcg1ruhTCBFco3O+5yi+fJtr9ONKgcNRRmI4tAII7/WVW967vTnNes6qkajjm3Ge0SNApsBk3gJ6UmnXLINlXsd0tykRRILeRNK1kdI72VZVQm8elud1cbwieKzq3xeZ2Jjg9B8iUvSuP75yp+cEhXKsfhj6qSDJZ532XZ6wa9eTj5VyTAxbOJtAdCjHixABMu4augc9pLri4bHSuF2t6s8H7c0oFWvqdCenrxwxxuLlDNyNYzSe02YXVnIS/EdeVgLgz5t8//0CtBe2312CdkXqaaPs2zWCL/bZyyANummmVznuwCcl+8taw0gUR5EJNdOk8xG0kdXifxuQgDn4/yVb7HTs/qcnsnK3JnjFEqe1XzF5rtxfyQadwLdWUY1et+IZJdfM3BdQcZt47/7B7KS/hPkuhK6WjxWz8EP5AUqJYsO9Kgk=\"}";
	Response response = given().spec(request_spec).body(request_body).post("/user/keys");
	response.then().spec(response_spec);
	
	//Print
	String resp_body = response.getBody().asPrettyString();
	System.out.println(resp_body);
	id = response.then().extract().path("id");
	System.out.println("ID:" +id);
	//Assert
	Assert.assertEquals(response.getStatusCode(),201);
	
}
@Test(priority=2)

public void getRequest() {
	Response resopnse = given().spec(request_spec).get("/user/keys");
	//Print
	System.out.println(resopnse.getBody().asPrettyString());
	//Report
	Reporter.log(resopnse.getBody().asPrettyString());
	//Assert
	Assert.assertEquals(resopnse.getStatusCode(),200);
	
}

@Test(priority=3)

public void deleteRequest() {
	Response response = given().spec(request_spec).pathParam("keyId",id).delete("/user/keys/{keyId}");
	//Report
	Reporter.log(response.getBody().asPrettyString());
	//Assert
	Assert.assertEquals(response.getStatusCode(),204);
}
	
}