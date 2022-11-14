package com.test.GlueCode;

import com.test.HitRestAPI.CallRestAPI;
import com.test.ReqPayloads.AddPetReqBody;
import com.test.URLs.APIEndPoints;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.junit.Assert;

public class ReqresGlueCodeAshok extends APIEndPoints {

    public Response response;

    @Given("Prepare The Parameters to Hit API")
    public void Prepare_The_Parameters_to_Hit_API(){

        System.out.println("======> Starting REST SERVICE API........!!!!!");
    }

    @When("I Hit the REQRES GET API")
    public void I_Hit_the_REQRES_GET_API(){
       response = CallRestAPI.CallGETAPI(getReqresURl());
    }

    @Then("I Print the Status Code and Response")
    public void I_Print_the_Status_Code_and_Response(){
        System.out.print("The Status Code is ===> " +response.getStatusCode());
        System.out.print("The Response Body is ===>" +response.body().asPrettyString());
    }

    @Then("I Validate the Status Code and Response Body")
    public void I_Validate_the_Status_Code_and_Response_Body(){

        int id = response.body().path("data[0].id");
        String emailid = response.body().path("data[0].email");
        String firstname = response.body().path("data[0].first_name");
        String lastname = response.body().path("data[0].last_name");

        Assert.assertEquals(200, response.getStatusCode());
        Assert.assertEquals(7, id);
        Assert.assertEquals("michael.lawson@reqres.in", emailid);
        Assert.assertEquals("Michael", firstname);
        Assert.assertEquals("Lawson", lastname);

    }

    @When("I Hit the PETSTORE POST API")
    public void I_Hit_the_PETSTORE_POST_API(){

        JSONObject obj = AddPetReqBody.ReturnAddPetRequestPayload(7,"German Sherpard","Available","dog","urls","pet" );

        response = CallRestAPI.CallPOSTAPI(getpeststoreURL(), obj);
    }

    @Then("I Validate the PETSTORE POST API Status Code and Response Body")
    public void I_Validate_the_PETSTORE_POST_API_Status_Code_and_Response_Body(){
        Assert.assertEquals(200, response.getStatusCode());

        String ctg = response.body().path("category.name");
        String tagName = response.body().path("tags[0].name");

        Assert.assertEquals("dog", ctg);
        Assert.assertEquals("pet", tagName);
    }

}
