package ictInternshipPortal;

import java.io.IOException;

import org.ict.constants.AutomationConstant;
import org.ict.pages.AdminDbPage;
import org.ict.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminDashboardTC extends TestBase{

	String actualResult=null;
	Boolean actualResults;
	LoginPage login;
	AdminDbPage adb;


	@Test(priority=8)
	public void TC_IP_1_4_1() throws IOException {
		launch();
		System.out.println("Running TC_IP_1_4_1");
		login=new LoginPage(driver);
		login.clickLogin();
		login.setName(prop.getProperty("admin_uname"));
		login.setPwd(prop.getProperty("admin_psw"));
		login.signin("admin");
		adb=new AdminDbPage(driver);
		actualResults=adb.adminProjects();
		System.out.println("Completed TC_IP_1_4_1");
//		login.clickLogout();
		Assert.assertEquals(actualResults,true);	
	}
	
	@Test(priority=9)
	public void TC_IP_1_4_2() {
		System.out.println("Running TC_IP_1_4_2");
		login=new LoginPage(driver);
//		login.clickLogin();
//		login.setName(prop.getProperty("admin_uname"));
//		login.setPwd(prop.getProperty("admin_psw"));
//		login.signin("admin");
		adb=new AdminDbPage(driver);
		actualResults=adb.editProject();
		System.out.println("Completed TC_IP_1_4_2");
		waitabit();
		login.clickLogout();
		Assert.assertEquals(actualResults,true);	
	}
	
	@Test(priority=10)
	public void TC_IP_1_4_3() {
		System.out.println("Running TC_IP_1_4_3");
		login=new LoginPage(driver);
		login.clickLogin();
		login.setName(prop.getProperty("admin_uname"));
		login.setPwd(prop.getProperty("admin_psw"));
		login.signin("admin");
		adb=new AdminDbPage(driver);
		actualResults=adb.deleteProject();
		System.out.println("Completed TC_IP_1_4_3");
		waitabit();
		login.clickLogout();
		Assert.assertEquals(actualResults,true);	
	}
	
	@Test(priority=11)
	public void TC_IP_1_4_4() {
		System.out.println("Running TC_IP_1_4_4");
		login=new LoginPage(driver);
		login.clickLogin();
		login.setName(prop.getProperty("admin_uname"));
		login.setPwd(prop.getProperty("admin_psw"));
		login.signin("admin");
		adb=new AdminDbPage(driver);
		actualResults=adb.addMentor("Cintu","cintu@gmail.com","9876543212","Cintu12345");
		System.out.println("Completed TC_IP_1_4_4");
		waitabit();
		login.clickLogout();
		Assert.assertEquals(actualResults,true);	
	}

	@Test(priority=12)
	public void TC_IP_1_4_5() {
		System.out.println("Running TC_IP_1_4_5");
		login=new LoginPage(driver);
		login.clickLogin();
		login.setName(prop.getProperty("admin_uname"));
		login.setPwd(prop.getProperty("admin_psw"));
		login.signin("admin");
		adb=new AdminDbPage(driver);
		actualResults=adb.addMentor("Deanamol","deanamol","9876543212","Cintu12345");
		System.out.println("Completed TC_IP_1_4_5");
		waitabit();
		login.clickLogout();
		Assert.assertEquals(actualResults,false);	
	}
	
	@Test(priority=13)
	public void TC_IP_1_4_6() {
		System.out.println("Running TC_IP_1_4_6");
		login=new LoginPage(driver);
		login.clickLogin();
		login.setName(prop.getProperty("admin_uname"));
		login.setPwd(prop.getProperty("admin_psw"));
		login.signin("admin");
		adb=new AdminDbPage(driver);
		actualResults=adb.addMentorBlank("Deanamol","deanamol@gmail.com","Cintu12345");
		System.out.println("Completed TC_IP_1_4_6");
//		waitabit();
//		login.clickLogout();
		Assert.assertEquals(actualResults,true);	
	}
	
	@Test(priority=14)
	public void TC_IP_1_4_7() {
		System.out.println("Running TC_IP_1_4_7");
		login=new LoginPage(driver);
//		login.clickLogin();
//		login.setName(prop.getProperty("admin_uname"));
//		login.setPwd(prop.getProperty("admin_psw"));
//		login.signin("admin");
		adb=new AdminDbPage(driver);
		actualResults=adb.editMentor("Deana");
		System.out.println("Completed TC_IP_1_4_7");
		waitabit();
//		login.clickLogout();
		driver.close();
		Assert.assertEquals(actualResults,true);	
	}
	
	@Test(priority=15)
	public void TC_IP_1_4_8() throws IOException {
		System.out.println("Running TC_IP_1_4_8");
		launch();
		login=new LoginPage(driver);
		login.clickLogin();
		login.setName(prop.getProperty("admin_uname"));
		login.setPwd(prop.getProperty("admin_psw"));
		login.signin("admin");
		adb=new AdminDbPage(driver);
		actualResults=adb.deleteMentor();
		System.out.println("Completed TC_IP_1_4_8");
		waitabit();
//		login.clickLogout();
		Assert.assertEquals(actualResults,true);	
	}
	
	@Test(priority=16)
	public void TC_IP_1_4_9() {
		System.out.println("Running TC_IP_1_4_9");
		login=new LoginPage(driver);
//		login.clickLogin();
//		login.setName(prop.getProperty("admin_uname"));
//		login.setPwd(prop.getProperty("admin_psw"));
//		login.signin("admin");
		adb=new AdminDbPage(driver);
		actualResults=adb.duplicateMentor("Cintu","cintu@gmail.com","9876543212","Cintu12345");
		System.out.println("Completed TC_IP_1_4_9");
		waitabit();
		login.clickLogout();
		driver.close();
		Assert.assertEquals(actualResults,true);	
	}
}
