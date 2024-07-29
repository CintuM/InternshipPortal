package ictInternshipPortal;

import java.io.IOException;

import org.ict.pages.LoginPage;
import org.ict.pages.MentorDbPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class MentorDashboardTC extends TestBase{

		String actualResult=null;
		Boolean actualResults;
		LoginPage login;
		MentorDbPage mdb;
		
		@Test(priority=17)
		public void TC_IP_1_3_1() throws IOException {
			launch();
			System.out.println("Running TC_IP_1_3_1");
			login=new LoginPage(driver);
			login.clickLogin();
			login.setName(prop.getProperty("useridMentor"));
			login.setPwd(prop.getProperty("pwdMentor"));
			login.signin("mentor");
			mdb=new MentorDbPage(driver);
			actualResults=mdb.safeLanding();
			login.clickLogout();
			Assert.assertEquals(actualResults,true);	
		}
		
		@Test(priority=18)
		public void TC_IP_1_3_2() {
			System.out.println("Running TC_IP_1_3_2");
			login=new LoginPage(driver);
			login.clickLogin();
			login.setName(prop.getProperty("useridMentor"));
			login.setPwd(prop.getProperty("pwdMentor"));
			login.signin("mentor");
			mdb=new MentorDbPage(driver);
			mdb.safeLanding();
			actualResults=mdb.projectDetails();
			login.clickLogout();
			Assert.assertEquals(actualResults,true);	
		}
		
		@Test(priority=18)
		public void TC_IP_1_3_3() {
			System.out.println("Running TC_IP_1_3_3");
			login=new LoginPage(driver);
			login.clickLogin();
			login.setName(prop.getProperty("useridMentor"));
			login.setPwd(prop.getProperty("pwdMentor"));
			login.signin("mentor");
			mdb=new MentorDbPage(driver);
			mdb.safeLanding();
			actualResults=mdb.checkStatus();
			login.clickLogout();
			Assert.assertEquals(actualResults,true);	
		}
		
		@Test(priority=19)
		public void TC_IP_1_3_4_6() {
			System.out.println("Running TC_IP_1_3_4");
			login=new LoginPage(driver);
			login.clickLogin();
			login.setName(prop.getProperty("useridMentor"));
			login.setPwd(prop.getProperty("pwdMentor"));
			login.signin("mentor");
			mdb=new MentorDbPage(driver);
			mdb.safeLanding();
			actualResults=mdb.evaluateSubmission();
			login.clickLogout();
			Assert.assertEquals(actualResults,true);	
		}
		
		@Test(priority=20)
		public void TC_IP_1_3_5() {
			System.out.println("Running TC_IP_1_3_5");
			login=new LoginPage(driver);
			login.clickLogin();
			login.setName(prop.getProperty("useridMentor"));
			login.setPwd(prop.getProperty("pwdMentor"));
			login.signin("mentor");
			mdb=new MentorDbPage(driver);
			mdb.safeLanding();
			actualResults=mdb.deleteSubmission();
			login.clickLogout();
			Assert.assertEquals(actualResults,true);	
		}
		
		@Test(priority=21)
		public void TC_IP_1_3_7() {
			System.out.println("Running TC_IP_1_3_7");
			login=new LoginPage(driver);
			login.clickLogin();
			login.setName(prop.getProperty("useridMentor"));
			login.setPwd(prop.getProperty("pwdMentor"));
			login.signin("mentor");
			mdb=new MentorDbPage(driver);
			mdb.safeLanding();
			actualResults=mdb.batchWiseFilter();
			login.clickLogout();
			Assert.assertEquals(actualResults,true);	
		}
		
		@Test(priority=22)
		public void TC_IP_1_3_8() {
			System.out.println("Running TC_IP_1_3_8");
			login=new LoginPage(driver);
			login.clickLogin();
			login.setName(prop.getProperty("useridMentor"));
			login.setPwd(prop.getProperty("pwdMentor"));
			login.signin("mentor");
			mdb=new MentorDbPage(driver);
			mdb.safeLanding();
			actualResults=mdb.topicWiseFilter();
//			login.clickLogout();
			Assert.assertEquals(actualResults,true);	
		}
		
		@Test(priority=23)
		public void TC_IP_1_3_9() throws IOException {
			launch();
			System.out.println("Running TC_IP_1_3_9");
			login=new LoginPage(driver);
			login.clickLogin();
			login.setName(prop.getProperty("useridMentor"));
			login.setPwd(prop.getProperty("pwdMentor"));
			login.signin("mentor");
			mdb=new MentorDbPage(driver);
			mdb.safeLanding();
			actualResults=mdb.addReference();
//			login.clickLogout();
			Assert.assertEquals(actualResults,true);	
		}
		
		@Test(priority=24)
		public void TC_IP_1_3_10() {
			System.out.println("Running TC_IP_1_3_10");
			login=new LoginPage(driver);
//			login.clickLogin();
//			login.setName(prop.getProperty("useridMentor"));
//			login.setPwd(prop.getProperty("pwdMentor"));
//			login.signin("mentor");
			mdb=new MentorDbPage(driver);
//			mdb.safeLanding();
			actualResults=mdb.deleteReference();
//			login.clickLogout();
			Assert.assertEquals(actualResults,true);	
		}
}
