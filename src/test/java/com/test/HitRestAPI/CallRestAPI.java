package com.test.HitRestAPI;

import static io.restassured.RestAssured.given;

import com.google.gson.JsonArray;
import org.json.simple.JSONObject;

import io.restassured.response.Response;

public class CallRestAPI {

	
	public static Response CallGETAPI(String url) {
				
		Response response = 	given().relaxedHTTPSValidation()
								.headers("Content-Type", "application/json")
								.get(url);
								
			return response;
	}
	
	public static Response CallPOSTAPI(String URL, JSONObject RequestBody) {
				
		System.out.println("Request Body is --->" + RequestBody);
		
		Response response = given().relaxedHTTPSValidation()	
							.headers("Content-Type", "application/json")

							.body(RequestBody).when()
							.post(URL);
		
		
		return response;
	}


	public static JsonArray returnCallGETAPI(String url) {

		JsonArray jsonArray = new JsonArray();

		jsonArray = given().baseUri("https://petstore.swagger.io/v2")
				.basePath("pet/findByStatus?status=available")
				.get().as(JsonArray.class);
		return jsonArray;
	}


}
