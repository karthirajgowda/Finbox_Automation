package Generic;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;


import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class KhataBook_UAT{ 
	
	//GENERATING RANDOM NUMBER AND CUSTOMER ID
	int num = (int)(Math.random()*(999-1+1)+1);
	String CustomerID="_Automation_"+num;
	
	//STORING URL AND TOKEN
	String URL;
	String Token;
	
	                                              //CREATING USER
	@Test
	public void POST_Create()
	{
		System.out.println("CoustmerID > "+CustomerID);
		//specify the base URI
		RestAssured.baseURI="https://lendinguat.finbox.in";
		
		//creating send request object
		RequestSpecification httpRequest=RestAssured.given();
		
		httpRequest.header("Content-Type","application/json");
		httpRequest.header("x-api-key","84b29f378a2e4ff19de28db31c5a809f");
		
		//creating json object 
		JSONObject body=new JSONObject();
		
		//to write the body
		body.put("customerID", CustomerID);
		body.put("mobile", "8123365951");
		
		
		
		httpRequest.body(body.toJSONString());
		
		//sending request and storing response
		Response response=httpRequest.request(Method.POST,"/v1/user/create");
		
		response.prettyPrint();
		
		System.out.println();
		System.out.println();
		System.out.println("------------------------------------------------------------------------------------------------------------");
		
	}
	 
	                 //CREATING ENDPOINT TO CHECK ELIGIBILITY
	
	String EndPoint="/v1/user/eligibility?customerID=";
	String EndpointUrl=EndPoint.concat(CustomerID);
	
	
	                 //GETTING ELIGIBILITY
	
	@Test(dependsOnMethods="POST_Create")
	public void GET_Eligibility()
	{
		
		//Specify Base URI
		RestAssured.baseURI="https://lendinguat.finbox.in";
		
		//Creating request object
		RequestSpecification hr=RestAssured.given();
		
		//Specifying headers
		hr.header("Content-Type","application/json");
		hr.header("x-api-key","84b29f378a2e4ff19de28db31c5a809f");
		
		Response response=hr.request(Method.GET,EndpointUrl);
		
		response.prettyPrint();
		
		System.out.println();
		System.out.println();
		System.out.println("------------------------------------------------------------------------------------------------------------");

	} 
	
	
	                          //CREATING LINK
	
	@Test(dependsOnMethods="GET_Eligibility")
	public void POST_generateLink()
	{
		//Specify base URI
		RestAssured.baseURI="https://lendinguat.finbox.in";
		
		//CREATE REQUEST OBJECT
		RequestSpecification hr=RestAssured.given();
		
		hr.header("Content-Type","application/json");
		hr.header("x-api-key","84b29f378a2e4ff19de28db31c5a809f");
		
		//creating json object 
		JSONObject body=new JSONObject();
		
		//to write the body
		body.put("customerID", CustomerID);
		body.put("redirectURL", "https://yoururl/redirect/to/after/user/exits");
		
		
		
		hr.body(body.toJSONString());
		
		//sending request and storing response
		Response response=hr.request(Method.POST,"/v1/user/session");
		
		response.prettyPrint();
		
		 Object o = response.jsonPath().get("data");
		 String data=o.toString();
		// System.out.println(data);
		//URL = BaseClass.getLink(data);
		 URL=data.substring(5, data.length()-1);
		
		System.out.println();
		System.out.println();
		System.out.println("------------------------------------------------------------------------------------------------------------");
		
	}

}
