package com.test.URLs;

public class APIEndPoints {

	private static final String reqresURl = "https://reqres.in/api/users?page=2";

	public  static final String peststoreURL  = "https://petstore.swagger.io/v2/pet";

	public static final String whatsappurl = "https://graph.facebook.com/v15.0/107203952249071/messages";

	public String getReqresURl(){

		return reqresURl;
	}


	public String whatsappurl(){

		return whatsappurl;
	}

	public String getpeststoreURL(){

		return peststoreURL;
	}



}
