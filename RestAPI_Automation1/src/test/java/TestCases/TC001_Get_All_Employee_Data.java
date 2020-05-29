package TestCases;

import org.junit.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import BasePackage.TestBase;
import io.restassured.RestAssured;
import io.restassured.http.Method;

public class TC001_Get_All_Employee_Data extends TestBase {

@BeforeClass
void getAllEmployees() throws InterruptedException {
	logger.info("**************Started TC001_Get_All_Employee_Data**************** ");
	RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
	httpRequest = RestAssured.given();
	response = httpRequest.request(Method.GET,"/employees");
	Thread.sleep(3000);
}

@Test
void checkResponseBody() {
	logger.info("**************Check Response Body********************");
	String responsebody=response.getBody().asString();
	logger.info("Response Body==>"+responsebody);
	Assert.assertTrue(responsebody!=null);
	
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
