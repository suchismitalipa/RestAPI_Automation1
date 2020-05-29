package TestCases;

import org.json.simple.JSONObject;
import org.junit.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import BasePackage.TestBase;
import Utilities.RestUtils;
import io.restassured.RestAssured;
import io.restassured.http.Method;

public class TC003_Post_Employee_Record extends TestBase {
	
	String empName = RestUtils.empName();
	String empAge = RestUtils.empAge();
	String empSalary = RestUtils.empSalary();
	
	@BeforeClass
	void createEmployee() throws InterruptedException {
		logger.info("***********TC003_Post_Employee_Record************");
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		httpRequest = RestAssured.given();
		JSONObject jsonobject = new JSONObject();
		jsonobject.put("name", empName);
		jsonobject.put("age", empName);
		jsonobject.put("salary", empName);
		httpRequest.header("Content-Type","application/json");
		httpRequest.body(jsonobject.toJSONString());
		response = httpRequest.request(Method.POST,"/create");
		Thread.sleep(1000);		
	}
	@Test
	void checkResponseBody() {
		logger.info("**************Check Response Body********************");
		String responsebody=response.getBody().asString();
		//logger.info("Response Body==>"+responsebody);
		System.out.println(responsebody);
		Assert.assertEquals(responsebody.contains("id"),true);
		
	}
	@Test
	void CheckStatusCode() {
		logger.info("**************Check Status Code********************");
		int statuscode=response.getStatusCode();
		logger.info("Status Code is "+statuscode);
		Assert.assertEquals(statuscode, 200);
		}
	@Test
	void CheckStatusLine() {
		logger.info("**************Status Line********************");
		String statusline=response.getStatusLine();
		logger.info("Status Line is "+statusline);
		}
	@Test
	void CheckResponseTime() {
		logger.info("**************Response Time********************");
		long responsetime=response.getTime();
		logger.info("Response Time is "+responsetime);
		}
	@Test
	void CheckContentType() {
		logger.info("**************Content Type********************");
		String contentType=response.header("Content-Type");
		logger.info("Content Type is "+contentType);
		}
	@Test
	void CheckServerType() {
		logger.info("**************Content Line********************");
		String serverType=response.header("Server");
		logger.info("Server Type is "+serverType);
		}
	@Test
	void CheckContentEncoding() {
		logger.info("**************Content Encoding********************");
		String contentEncoding=response.header("Content-Encoding");
		logger.info("Content Encoding is "+contentEncoding);
		}
	@Test
	void CheckContentLength() {
		logger.info("**************Content Length********************");
		String contentLength=response.header("Content-Length");
		logger.info("Content Lenght is "+contentLength);
		if (Integer.parseInt(contentLength)<100) {
			logger.warn("Content length is less than 100");
		}
		}
	@Test
	void checkCookies() {
		logger.info("**************Checking Cookies********************");
		String cookie=response.getCookie("Recyclebin");
		logger.info("Cookies is "+cookie);
		}
	@AfterClass
	void tearDown() {
		logger.info("**************Finished TC001_Get_All_Employee_Data********************");
	}

}
