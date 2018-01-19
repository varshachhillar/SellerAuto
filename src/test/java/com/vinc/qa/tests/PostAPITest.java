package com.vinc.qa.tests;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ibcash.qa.data.Users;
import com.seller.qa.base.TestBase;
import com.vinc.qa.client.RestClient;

public class PostAPITest extends TestBase {
	
	TestBase testbase ;
	String ibcash;
	String service;
	String apiurl;
	RestClient restclient;
	CloseableHttpResponse closeableHttpResponse;
	HashMap<String, String> headerMap ;
	
	@BeforeMethod
	public void setUp() {
		testbase = new TestBase();
		ibcash = prop.getProperty("ibcashURL");
		service = prop.getProperty("ibcashservice");
		
		apiurl = ibcash + service;
		restclient = new RestClient();
		headerMap = new HashMap<String, String>();
	}
	
	@Test
	public void postTest() throws JsonGenerationException, JsonMappingException, IOException {
		headerMap.put("Content-Type", "application/json");
		
		//jackson API:
		ObjectMapper mapper = new ObjectMapper();
		Users user = new Users("varsha","automation","vc3@ib.com","auto","auto");
		
		//covert pojo to json file
		mapper.writeValue(new File("C:\\Users\\User1\\eclipse-workspace\\javaenv\\MavenAuto\\src\\main\\java\\com\\ibcash\\qa\\data\\users.json"), user);
		
		//json file to json string
		String userjson = mapper.writeValueAsString(user);
		System.out.println(userjson);
		
		//call post method
		closeableHttpResponse = restclient.post(apiurl, userjson, headerMap);
		
		//1. Status code
		int Statuscode = closeableHttpResponse.getStatusLine().getStatusCode();
		System.out.println(Statuscode);
		
		//2. Json object
		String responseString =  EntityUtils.toString(closeableHttpResponse.getEntity(),"UTF-8");
		JSONObject responseJson = new JSONObject(responseString);
		
		System.out.println(responseJson);
		
		//json to java obj
		Users userobj = mapper.readValue(responseString, Users.class);
		System.out.println(userobj);
		System.out.println(userobj.getFirstName().equals(user.getFirstName()));
		System.out.println(userobj.getLastName().equals(user.getLastName()));



	}
	
	
	

}
