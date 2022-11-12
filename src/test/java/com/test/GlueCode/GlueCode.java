package com.test.GlueCode;



import com.google.gson.JsonArray;
import com.test.HitRestAPI.CallRestAPI;
import com.test.ReqPayloads.AddPetReqBody;
import com.test.ReqPayloads.ReqResRequestPayload;
import com.test.URLs.APIEndPoints;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.Assert;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public class GlueCode extends APIEndPoints{

	public Response response;
	
	@Given("^Prepare the Parameters to Hit API$")
	public void prepare_the_Parameters_to_Hit_API()  {
	   
	    System.out.println("======> Starting REST SERVICE API........!!!!!");
	}


	@Given("I hit the Get API")
	public void I_hit_the_Get_API()  {


		response = 	CallRestAPI.CallGETAPI(getReqresURl());
	}


	@Given("I print the Status Code and Response")
	public void print_the_Status_Code_and_Response()  {

		System.out.println("The Status code is ====>>> "+response.getStatusCode());
		System.out.println("The Status code is ====>>> "+response.body().asPrettyString());

	}


	@Given("I Validate Status Code and Response Body")
	public void I_Validate_Status_Code_and_Response_Body()  {

		int id = response.body().path("data[0].id");
		String emailId = response.body().path("data[0].email");
		String firstName = response.body().path("data[0].first_name");

		Assert.assertEquals(200,response.getStatusCode());
		Assert.assertEquals(7, id);
		Assert.assertEquals("michael.lawson@reqres.in", emailId);
		Assert.assertEquals("Michael", firstName);

	}


	@Given("I hit the POST API")
	public void I_hit_the_POST_API()  {

		JSONObject obj = 	AddPetReqBody.ReturnAddPetRequestPayload(7, "German Shepard","Available","DOG","urls","PET");

		response = 	CallRestAPI.CallPOSTAPI(getpeststoreURL(),obj );
	}

	@Given("I Validate POST API Status Code and Response Body")
	public void I_Validate_POST_API_Status_Code_and_Response_Body()  {


		String ctg= response.body().path("category.name");
		String tagName= response.body().path("tags[0].name");

		Assert.assertEquals(200, response.getStatusCode());
		Assert.assertEquals("DOG",ctg);
		Assert.assertEquals("PET",tagName);
	}



}

