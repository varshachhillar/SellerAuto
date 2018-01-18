package com.vinc.qa.client;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;




public class RestClient {
	
	// 1. GET Method without header
	public CloseableHttpResponse get(String url) throws ClientProtocolException, IOException {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(url);
		CloseableHttpResponse closeableHttpResponse = httpClient.execute(httpGet);
		return closeableHttpResponse;

		
	}
	
	// 2. GET Method with header
	public CloseableHttpResponse get(String url, HashMap<String, String> headerMap) throws ClientProtocolException, IOException {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(url);
		
		for(Map.Entry<String, String> entry: headerMap.entrySet()) {
			httpGet.addHeader(entry.getKey(),entry.getValue());
		}
		
		CloseableHttpResponse closeableHttpResponse = httpClient.execute(httpGet);
		return closeableHttpResponse;
		
	}
	
	
	
	
	
	
	
	
	
	
	

}
