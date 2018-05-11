package com.vinc.qa.tests;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.seller.qa.base.TestBase;
import com.seller.qa.util.TestUtil;
import com.vinc.qa.client.RestClient;

public class GetAPITest extends TestBase {
	TestBase testbase ;
	String admin;
	String service;
	String apiurl;
	RestClient restclient;
	CloseableHttpResponse closeableHttpResponse;
	HashMap<String, String> headerMap ;
	
	@BeforeMethod
	public void setUp() {
		testbase = new TestBase();
		admin = prop.getProperty("adminURL");
		service = prop.getProperty("service");
		
		apiurl = admin + service;
		restclient = new RestClient();
		headerMap = new HashMap<String, String>();
	}
	
	@Test
	public void getTestWithoutHeader() throws ClientProtocolException, IOException {
		closeableHttpResponse = restclient.get(apiurl);

		//Status Code
		int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
		System.out.println("Status Code-----------> "+ statusCode);
		Assert.assertEquals(statusCode, RESPONSE_STATUS_CODE_200,"Status code is not as expected");

		//Response body
		String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(),"UTF-8");
		JSONObject responseJson = new JSONObject(responseString);
		System.out.println("responsebody------>"+ responseJson);

		String vendorcode = TestUtil.getValueByJPath(responseJson, "/VendorCode");
		System.out.println("vendorcode------>"+ vendorcode);
		Assert.assertEquals(Integer.parseInt(vendorcode), 7167,"vendor code is not as expected"); //Single value assertion

		//Get value from JSOn array
		String lastname = TestUtil.getValueByJPath(responseJson, "/data[0]/last_name");
		System.out.println("lastname------>"+ lastname);

		//response header
		Header[] responseHeader = closeableHttpResponse.getAllHeaders();
		HashMap<String, String> allHeader = new HashMap<String, String>();

		for(Header header: responseHeader) {
			allHeader.put(header.getName(),header.getValue());
		}
		System.out.println("responseHeader------>"+ allHeader);

	}
	
	@Test
	public void getTestWithHeader() throws ClientProtocolException, IOException {
 
		headerMap.put("Authorization", "token acbca1081b92f0ed8ccc411bce2ee4b4ee418998");
		closeableHttpResponse = restclient.get(apiurl,headerMap);		

		//Status Code
		int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
		System.out.println("Status Code-----------> "+ statusCode);
		Assert.assertEquals(statusCode, RESPONSE_STATUS_CODE_200,"Status code is not as expected");
		
		//Response body
		String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(),"UTF-8");
		JSONObject responseJson = new JSONObject(responseString);
		System.out.println("responsebody------>"+ responseJson);
		
		String orderNo = TestUtil.getValueByJPath(responseJson, "/Order No");
		System.out.println("Order No------>"+ orderNo);
		Assert.assertEquals(orderNo, "101586841","orderNo is not as expected"); //Single value assertion
		
		//Get value from JSOn array
		String vendorcode = TestUtil.getValueByJPath(responseJson, "/Order Items[0]/Vendor Code");
		System.out.println("Vendor Code------>"+ vendorcode);

		//response header
		Header[] responseHeader = closeableHttpResponse.getAllHeaders();
		HashMap<String, String> allHeader = new HashMap<String, String>();
		
		for(Header header: responseHeader) {
			allHeader.put(header.getName(),header.getValue());
		}
		System.out.println("responseHeader------>"+ allHeader);

	}


}
