package ictInternshipPortal;


import org.ict.constants.AutomationConstant;
import org.ict.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTC extends TestBase {
	
	String actualResult=null;
	Boolean actualResults;
	LoginPage login;


	@Test(priority=1)
	public void TC_IP_1_1_1() {
		System.out.println("Running TC_IP_1_1_1");
		login=new LoginPage(driver);
		actualResult = login.safeLanding();
		Assert.assertEquals(actualResult, AutomationConstant.ExpectedHome);
	}
	
	@Test(priority=2)
	public void TC_IP_1_2_1() {
		System.out.println("Running TC_IP_1_2_1");
		login=new LoginPage(driver);
		login.clickLogin();
		login.setName(prop.getProperty("admin_uname"));
		login.setPwd(prop.getProperty("admin_psw"));
		actualResult = login.signin("admin");
		login.clickLogout();
		Assert.assertEquals(actualResult, AutomationConstant.ExpectedAdminHome);	
	}
	
	@Test(priority=3)
	public void TC_IP_1_2_2() {
		System.out.println("Running TC_IP_1_2_2");
		login=new LoginPage(driver);
		login.clickLogin();
		login.setName(prop.getProperty("useridMentor"));
		login.setPwd(prop.getProperty("pwdMentor"));
		actualResult = login.signin("mentor");
		login.clickLogout();
		Assert.assertEquals(actualResult, AutomationConstant.ExpectedMentorHome);
	
	}
	
	@Test(priority=4)
	public void TC_IP_1_2_3() {
		System.out.println("Running TC_IP_1_2_3");
		login=new LoginPage(driver);
		login.clickLogin();
		login.setName(prop.getProperty("admin_uname"));
		login.setPwd(prop.getProperty("admin_psw"));
		login.signin("admin");
		actualResult = login.clickLogout();
		Assert.assertEquals(actualResult, AutomationConstant.ExpectedLogoutHome);
	
	}
	
	@Test(priority=5)
	public void TC_IP_1_2_6() {
		System.out.println("Running TC_IP_1_2_6");
		login=new LoginPage(driver);
		login.clickLogin();
		login.setName(prop.getProperty("useridMentor"));
		login.setPwd(prop.getProperty("pwdMentor"));
		login.signin("mentor");
		actualResult = login.clickLogout();
		Assert.assertEquals(actualResult, AutomationConstant.ExpectedLogoutHome);
	
	}
	
	@Test(priority=6)
	public void TC_IP_1_2_4() {
		System.out.println("Running TC_IP_1_2_4");
		login=new LoginPage(driver);
		login.clickLogin();
		login.setName(prop.getProperty("admin_uname"));
		login.setPwd(prop.getProperty("invalidpwdAdmin"));
		actualResult = login.signin("admin");
		Assert.assertEquals(actualResult, AutomationConstant.ExpectedInvalidLoginMsg);	
	}

	@Test(priority=7)
	public void TC_IP_1_2_5() {
		System.out.println("Running TC_IP_1_2_5");
		driver.get(prop.getProperty("url"));
		login=new LoginPage(driver);
		login.clickLogin();
		login.setName(prop.getProperty("admin_uname"));
		actualResult = login.signin("admin");
		driver.close();
		Assert.assertEquals(actualResult, AutomationConstant.ExpectedBlankLoginMsg);	
	}


}
