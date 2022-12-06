package restassured;

import org.json.simple.JSONObject;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class ecommerce_api {
	
	public static String url="https://ecommerceservice.herokuapp.com";
	public String token;
	
	@Test(enabled=false)
	public void user_signup()
	{
	RestAssured.baseURI=url;			
	JSONObject js=new JSONObject();	
	js.put("email", "spyder42@gmail.com");
	js.put("password", "spyder123");	
	given().contentType(ContentType.JSON).accept(ContentType.JSON).when().body(js.toJSONString()).post("/user/signup").then()
	.statusCode(201).log().all();
	
	}
	@Test(enabled=false)
	public void user_login()
	{	
	RestAssured.baseURI=url;
	JSONObject js=new JSONObject();
	js.put("email", "spyder42@gmail.com");
	js.put("password", "spyder123");
		
	given().contentType(ContentType.JSON).accept(ContentType.JSON).body(js.toJSONString()).
	   when().post("/user/login").then().log().all();
	//String jsonresponse=Res.asString();
	//JsonPath jp=new JsonPath(jsonresponse);
	//token=jp.get("accessToken");
	//System.out.println(token);
			
	}
	@Test(enabled=false)
	public void getallusers()
	{
		RestAssured.baseURI=url;
		JSONObject js=new JSONObject();
		given().auth().oauth2("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2MzczYmU4NjllYjcxMzAwMTc2MmE2NDAiLCJpYXQiOjE2Njg1Mjk5NTAsImV4cCI6MTY2ODYxNjM1MH0.qf8I7RS3-wBhQNbZZtZozmPOWp21wZddvYXCeORv-14")
		.contentType(ContentType.JSON).when().get("/user").then().log().all();
			
	}

	@Test(enabled=false)
	public void delete_user()
	{
		RestAssured.baseURI=url;
		JSONObject js=new JSONObject();
		given().auth().oauth2("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2MzczYmU4NjllYjcxMzAwMTc2MmE2NDAiLCJpYXQiOjE2Njg1Mjk5NTAsImV4cCI6MTY2ODYxNjM1MH0.qf8I7RS3-wBhQNbZZtZozmPOWp21wZddvYXCeORv-14")
		.contentType(ContentType.JSON).when().delete("/user/63738c149eb713001762a5d0").then().log().all();

	}
	@Test(enabled=false)
	public void get_products()
	{
		RestAssured.baseURI=url;
		JSONObject js=new JSONObject();	
		given().auth().oauth2("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2MzczYmU4NjllYjcxMzAwMTc2MmE2NDAiLCJpYXQiOjE2Njg1Mjk5NTAsImV4cCI6MTY2ODYxNjM1MH0.qf8I7RS3-wBhQNbZZtZozmPOWp21wZddvYXCeORv-14")
		.contentType(ContentType.JSON).when().get("/products").then().log().all();

	}
	@Test(enabled=false)
	public void create_product()
	{
		RestAssured.baseURI=url;
		JSONObject js=new JSONObject();	
		js.put("name", "mask");
		js.put("price", 23);
		given().auth().oauth2("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2MzczYmU4NjllYjcxMzAwMTc2MmE2NDAiLCJpYXQiOjE2Njg1Mjk5NTAsImV4cCI6MTY2ODYxNjM1MH0.qf8I7RS3-wBhQNbZZtZozmPOWp21wZddvYXCeORv-14")
		.contentType(ContentType.JSON).body(js.toJSONString()).when().post("/products").then().statusCode(200).log().all();
}
	@Test(enabled=false)
	public void get_product()
	{
		RestAssured.baseURI=url;
		JSONObject js=new JSONObject();	
		given().auth().oauth2("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2MzczYmU4NjllYjcxMzAwMTc2MmE2NDAiLCJpYXQiOjE2Njg1Mjk5NTAsImV4cCI6MTY2ODYxNjM1MH0.qf8I7RS3-wBhQNbZZtZozmPOWp21wZddvYXCeORv-14")
		.contentType(ContentType.JSON).when().get("/products/6373c3d49eb713001762a65a").then().log().all();

	}
	@Test(enabled=false)
	public void update_product()
	{
		RestAssured.baseURI=url;
		JSONObject js=new JSONObject();	
		js.put("name", "mask");
		js.put("price", 55);
		given().auth().oauth2("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2MzczYmU4NjllYjcxMzAwMTc2MmE2NDAiLCJpYXQiOjE2Njg1Mjk5NTAsImV4cCI6MTY2ODYxNjM1MH0.qf8I7RS3-wBhQNbZZtZozmPOWp21wZddvYXCeORv-14")
		.contentType(ContentType.JSON).body(js.toJSONString()).when().patch("/products/6373c3d49eb713001762a65a").then().log().all();

	}
	@Test(enabled=false)
	public void delete_product()
	{
		RestAssured.baseURI=url;
		JSONObject js=new JSONObject();	
		given().auth().oauth2("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2MzczYmU4NjllYjcxMzAwMTc2MmE2NDAiLCJpYXQiOjE2Njg1Mjk5NTAsImV4cCI6MTY2ODYxNjM1MH0.qf8I7RS3-wBhQNbZZtZozmPOWp21wZddvYXCeORv-14")
		.contentType(ContentType.JSON).when().delete("/products/6373c3d49eb713001762a65a").then().log().all();
	}
	@Test(enabled=false)
	public void get_orders()
	{
		RestAssured.baseURI=url;
		JSONObject js=new JSONObject();	
		given().auth().oauth2("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2MzczYmU4NjllYjcxMzAwMTc2MmE2NDAiLCJpYXQiOjE2Njg1Mjk5NTAsImV4cCI6MTY2ODYxNjM1MH0.qf8I7RS3-wBhQNbZZtZozmPOWp21wZddvYXCeORv-14")
		.contentType(ContentType.JSON).when().get("/orders").then().log().all();

	}
	@Test(enabled=false)
	public void create_order()
	{
		RestAssured.baseURI=url;
		JSONObject js=new JSONObject();	
		js.put("product", "6373c3d49eb713001762a65a");
		js.put("quantity", 2);
		given().auth().oauth2("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2MzczYmU4NjllYjcxMzAwMTc2MmE2NDAiLCJpYXQiOjE2Njg1Mjk5NTAsImV4cCI6MTY2ODYxNjM1MH0.qf8I7RS3-wBhQNbZZtZozmPOWp21wZddvYXCeORv-14")
		.contentType(ContentType.JSON).body(js.toJSONString()).when().post("/orders").then().log().all();
}
	@Test(enabled=false)
	public void get_order()
	{
		RestAssured.baseURI=url;
		JSONObject js=new JSONObject();	
		given().auth().oauth2("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2MzczYmU4NjllYjcxMzAwMTc2MmE2NDAiLCJpYXQiOjE2Njg1Mjk5NTAsImV4cCI6MTY2ODYxNjM1MH0.qf8I7RS3-wBhQNbZZtZozmPOWp21wZddvYXCeORv-14")
		.contentType(ContentType.JSON).when().get("/orders/6373c3d49eb713001762a65a").then().log().all();

	}
	@Test(enabled=false)
	public void update_order()
	{
		RestAssured.baseURI=url;
		JSONObject js=new JSONObject();	
		js.put("product", "243634734ge7474");
		js.put("quantity", 55);
		given().auth().oauth2("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2MzczYmU4NjllYjcxMzAwMTc2MmE2NDAiLCJpYXQiOjE2Njg1Mjk5NTAsImV4cCI6MTY2ODYxNjM1MH0.qf8I7RS3-wBhQNbZZtZozmPOWp21wZddvYXCeORv-14")
		.contentType(ContentType.JSON).body(js.toJSONString()).when().patch("/orders/6373c3d49eb713001762a65a").then().log().all();

	}
	@Test(enabled=false)
	public void delete_order()
	{
		RestAssured.baseURI=url;
		JSONObject js=new JSONObject();	
		given().auth().oauth2("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2MzczYmU4NjllYjcxMzAwMTc2MmE2NDAiLCJpYXQiOjE2Njg1Mjk5NTAsImV4cCI6MTY2ODYxNjM1MH0.qf8I7RS3-wBhQNbZZtZozmPOWp21wZddvYXCeORv-14")
		.contentType(ContentType.JSON).when().delete("/orders/6373c3d49eb713001762a65a").then().log().all();
	}
}