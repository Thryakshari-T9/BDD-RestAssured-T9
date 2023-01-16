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
							.header("Authorization","Bearer EAARG5kpV5ZCABAMZCrAXVMQzPUMmCDKAZBF9ko1q6DpOnZCer76XbSrfZAdZAZBteTsTIdnRdYCOC0OasfFTYLWYZCK6CMOExLXwsQrUvdNu4qzltxuZAzOvqT89fGqBgnHFsGh2bJIdqZCsqhMBRz83ZCJkZCd0MxayNGsRyotz5orZBih4zZCFVQz9LqtbNKVMrZBkqDZA2ckjNb1ZBNhxY2WilfYjQ")
							.body(RequestBody).when()
							.post(URL);


		System.out.println(response.asPrettyString());
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
