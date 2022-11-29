package ai.ds.testLayer;

import org.testng.Assert;
import org.testng.annotations.Test;

import ai.ds.pageLayer.LoginPage;
import ai.ds.testBase.TestBase;

public class LoginPageTest extends TestBase {

	@Test
	public void verifyLoginTest() throws InterruptedException
	{
		String expected_url = "https://www.apps.dalalstreet.ai/dashboard";
		Thread.sleep(3000);
		String actaul_url =login.getActualUrl();
		Assert.assertEquals(actaul_url, expected_url);
	}
}
