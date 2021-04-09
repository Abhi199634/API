package com.qa.test;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.testbase;
import com.qa.client.RestClient;
import com.qa.util.testutil;

public class getAPITest extends testbase {
	
	testbase test;
	String apiurl;
	String seriveurl;
	String url;
	public static RestClient rs = new RestClient() ;
	CloseableHttpResponse closeablehttpresponse;
	
	public getAPITest() throws FileNotFoundException {
		super();
		// TODO Auto-generated constructor stub
	}

	@BeforeMethod
	public void setup() throws IOException {
		
		test= new testbase();
		
		String apiurl= prop.getProperty("URL");
		
		String seriveurl= prop.getProperty("serviceurl");
		
		url= apiurl+seriveurl;
	}
	@Test(priority=1)
	
	public void gettestwithoutHeaders() throws ClientProtocolException, IOException {
		
		closeablehttpresponse= rs.get(url);
		int statusCode= closeablehttpresponse.getStatusLine().getStatusCode();
		System.out.println("statuscode"+statusCode);
		
		Assert.assertEquals(statusCode,Response_status_response_code_200,"status code is not 200");
		
	}
	@Test(priority=2)
	
	//single value assertions 
	public void responsedata() throws ParseException, IOException {
		String responseStirng= EntityUtils.toString(closeablehttpresponse.getEntity(),"UTF-8");
		
		JSONObject responsejson = new JSONObject(responseStirng);
		System.out.println("response json from API"+responsejson);
		
		//per page 
		String perpage= testutil.getValueByJPath(responsejson, "/per_page");
		System.out.println(perpage);
		Assert.assertEquals(Integer.parseInt(perpage), 6);
		
		//total count 
		String totalvalue = testutil.getValueByJPath(responsejson, "/total");
		System.out.println(totalvalue);
		
		Assert.assertEquals(Integer.parseInt(totalvalue), 12);
		
		//get the value from json array
		String last_name= testutil.getValueByJPath(responsejson, "/data[0]/last_name");
		String id= testutil.getValueByJPath(responsejson, "/data[0]/id");
		String avatar= testutil.getValueByJPath(responsejson, "/data[0]/avatar");
		String first_name= testutil.getValueByJPath(responsejson, "/data[0]/first_name");
		
		System.out.println(last_name);
		System.out.println(id);
		System.out.println(avatar);
		System.out.println(first_name);

	}
	@Test(priority=3)
	public void getAPIwithHeaders() throws ClientProtocolException, IOException {
	
		HashMap<String, String> headermap = new HashMap<String, String>();
		
		headermap.put("content-type", "application/json");
		//headermap.put("username	", "test");
		//headermap.put("password", "test123");
		closeablehttpresponse= rs.get(url, headermap);
		
		int statusCode= closeablehttpresponse.getStatusLine().getStatusCode();
		System.out.println("statuscode"+statusCode);
		
		Assert.assertEquals(statusCode,Response_status_response_code_200,"status code is not 200");
	}
	@Test(priority=4)
	
	//single value assertions 
	public void responsedatawithheaders() throws ParseException, IOException {
		String responseStirng= EntityUtils.toString(closeablehttpresponse.getEntity(),"UTF-8");
		
		JSONObject responsejson = new JSONObject(responseStirng);
		System.out.println("response json from API"+responsejson);
		
		//per page 
		String perpage= testutil.getValueByJPath(responsejson, "/per_page");
		System.out.println(perpage);
		Assert.assertEquals(Integer.parseInt(perpage), 6);
		
		//total count 
		String totalvalue = testutil.getValueByJPath(responsejson, "/total");
		System.out.println(totalvalue);
		
		Assert.assertEquals(Integer.parseInt(totalvalue), 12);
		
		//get the value from json array
		String last_name= testutil.getValueByJPath(responsejson, "/data[0]/last_name");
		String id= testutil.getValueByJPath(responsejson, "/data[0]/id");
		String avatar= testutil.getValueByJPath(responsejson, "/data[0]/avatar");
		String first_name= testutil.getValueByJPath(responsejson, "/data[0]/first_name");
		
		System.out.println(last_name);
		System.out.println(id);
		System.out.println(avatar);
		System.out.println(first_name);
	}
}
