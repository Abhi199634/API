package com.qa.client;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class RestClient {
	
	
	//1. Get Method without headers
	
	public CloseableHttpResponse get(String url) throws ClientProtocolException, IOException {
		
		CloseableHttpClient httpclient= HttpClients.createDefault();// create client connection 
		HttpGet httpget = new HttpGet(url);
		CloseableHttpResponse closeablehttpresponse = httpclient.execute(httpget); //hit the get URL
		
		return closeablehttpresponse;
	}
	
	//2 Get method with headers
	public CloseableHttpResponse get(String url, HashMap<String, String> headermap) throws ClientProtocolException, IOException {
		
		CloseableHttpClient httpclient= HttpClients.createDefault();// create client connection 
		HttpGet httpget = new HttpGet(url);
		for(Map.Entry<String, String> e:  headermap.entrySet()) {
			
			httpget.addHeader(e.getKey(),e.getValue());
		}
		CloseableHttpResponse closeablehttpresponse = httpclient.execute(httpget); //hit the get URL
		
		return closeablehttpresponse;
	}
	
}
