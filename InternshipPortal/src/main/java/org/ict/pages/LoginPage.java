package org.ict.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	WebDriver driver;
	WebDriverWait wait;

	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		this.wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	}
	
	@FindBy(xpath="//div[text()='ICTAK INTERNSHIP PORTAL']")
	WebElement home;
	
	@FindBy(xpath="//a[text()='Login']")
	WebElement login1;
	
	@FindBy(css="input[type='text']")
	WebElement userId;
	
	@FindBy(css="input[type='password']")
	WebElement password;
	
	@FindBy(xpath="//button[text()='Log in']")
	WebElement login;
	
	@FindBy(xpath="//h6[text()='ADMIN-Dashboard']")
	WebElement AdminDashboard;
	
	@FindBy(xpath="//h6[text()='ICTAK-Mentor Dashboard']")
	WebElement MentorDashboard;
	
	@FindBy(xpath="//a[text()='Logout']")
	WebElement logout;
	
	@FindBy(xpath="//h4[text()='LOGIN']")
	WebElement logoutPage;
	
	@FindBy(xpath="//p[text()='Error logging in']")
	WebElement InvalidMsg;
	
	@FindBy(css="p[class='MuiFormHelperText-root Mui-error MuiFormHelperText-sizeMedium MuiFormHelperText-contained css-v7esy']")
	WebElement BlankPwdMsg;
	
	public String safeLanding() {
		return home.getText();
	}
	
	public void setName(String name) {
		userId.clear();
		userId.sendKeys(name); 
	}
	
	public void setPwd(String pw) {
		password.clear();
		password.sendKeys(pw); 
	}
	
	public void clickLogin() {
		login1.click();
	}
	
	public String clickLogout() {
		System.out.println("Called logout");
//		wait.until(ExpectedConditions.elementToBeClickable(logout));
		logout.click();
		System.out.println("Clicked logout");
		return logoutPage.getText();
	}
	
	public String signin(String user) {
		login.click();
		if (user.equalsIgnoreCase("admin")){
			try {
		wait.until(ExpectedConditions.visibilityOf(AdminDashboard));
		return AdminDashboard.getText();
			}catch(Exception e) {
				try {
				wait.until(ExpectedConditions.visibilityOf(InvalidMsg));
				return InvalidMsg.getText();
				}catch(Exception e1) {
					return BlankPwdMsg.getText();
				}
			}
		}
		else if(user.equalsIgnoreCase("mentor")) {
			wait.until(ExpectedConditions.visibilityOf(MentorDashboard));
			return MentorDashboard.getText();
		}
		else
			wait.until(ExpectedConditions.visibilityOf(MentorDashboard));
		return MentorDashboard.getText();
	}

}
