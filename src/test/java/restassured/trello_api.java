package restassured;

import static io.restassured.RestAssured.given;


import org.json.simple.JSONObject;
import org.testng.annotations.Test;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class trello_api {
public String url = "https://api.trello.com";
public String key= "3023c5ec09717db09d7b95231bc7f6ce";
public String token="856102a9c2a114afcd0ffb82f36335d969d89e4453f6c5004f252af275fef0a6";
public String id;

@Test(enabled=true)
public void tc1_create() {
	JSONObject js = new JSONObject();	
   RestAssured.baseURI=url;
   Response response=given().queryParam("name", "ravi")
			.queryParam("key", key)
			.queryParam("token", token)
			.header("Content-Type", "application/json")
			.when()
			.post("/1/boards/")
			.then()
			.assertThat().statusCode(200).contentType(ContentType.JSON)
			.extract().response();
   
			String jsonresponse = response.asString();
			JsonPath jr= new JsonPath(jsonresponse);	
			id = jr.get("id");
			System.out.println(id);		
		}

@Test(enabled=false)
public void tc2_getall() {
	JSONObject js = new JSONObject();
	   RestAssured.baseURI=url;
	    given().queryParam("key", key).queryParam("token", token).contentType(ContentType.JSON).accept(ContentType.JSON).when().get("1/members/me/boards/").then().statusCode(200).log().all();
	}
@Test(enabled=false)
public void tc3_update() {
	JSONObject js = new JSONObject();
	   RestAssured.baseURI=url;
	    given().queryParam("name", "spyder").queryParam("key", key).queryParam("token", token).contentType(ContentType.JSON).accept(ContentType.JSON).when().put("1/boards/GkfEH5cd").then().statusCode(200).log().all();
	}
@Test(enabled=true)
public void tc4_delete() {
	JSONObject js = new JSONObject();
	   RestAssured.baseURI=url;
	    given().queryParam("key", key).queryParam("token", token).contentType(ContentType.JSON).accept(ContentType.JSON).when().delete("/1/boards/"+id).then().log().all();
	}


}

