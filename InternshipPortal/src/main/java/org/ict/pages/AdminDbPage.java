package org.ict.pages;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminDbPage {

	WebDriver driver;
	WebDriverWait wait;

	public AdminDbPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		this.wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	}
	
	@FindBy(xpath="//h2[text()='Projects']")
	WebElement Projects;
	
	@FindBy(xpath = "//button[text()='Add Project']")
	WebElement addProject;
	
	@FindBy(css="input[type='text']")
	WebElement projectName;
	
	@FindBy(xpath="//button[text()='Add']")
	WebElement add;
	
	@FindBy(xpath="//div[text()='Selenium for Testing']")
	WebElement projectedit;
	
	@FindBy(xpath="(//div[text()='Selenium for Testing']/following::button)[1]")
	WebElement editButton;
	
	@FindBy(css="input[value='Selenium for Testing']")
	WebElement newNameProject;
	
	@FindBy(xpath="//button[text()='Save']")
	WebElement save;
	
	@FindBy(xpath="(//div[text()='Selenium for Testing New']/following::button)[2]")
	WebElement deleteProject;
	
	@FindBy(xpath="//a[text()='Mentor Form']")
	WebElement mentorForm;
	
	@FindBy(name="Name")
	WebElement name;
	
	@FindBy(name="Email")
	WebElement email;
	
	@FindBy(name="PhoneNumber")
	WebElement number;
	
	@FindBy(name="Password")
	WebElement password;
	
	@FindBy(id="demo-simple-select")
	WebElement projectTopic;
	
	@FindBy(css="button[type='button']")
	WebElement submit;
	
	@FindBy(xpath="//p[text()='Phone Number is required and should be a valid phone number']")
	WebElement blankMsg;
	
	@FindBy(xpath="//a[text()='Mentors']")
	WebElement mentors;
	
	@FindBy(xpath="//p[text()='Mentor already exists']")
	WebElement duplicateMsg;
	
	@FindBy(xpath="//a[text()='Logout']")
	WebElement logout;
	
	
	public Boolean adminProjects() {
		Projects.click();
		addProject.click();
		projectName.sendKeys("Selenium for Testing");
		add.click();
		wait.until(ExpectedConditions.elementToBeClickable(logout));
		System.out.println("New project added");
		return true;
	}
	
	public Boolean editProject() {
		try{
//		Projects.click();
		wait.until(ExpectedConditions.visibilityOf(projectedit));
		editButton.click();
		newNameProject.clear();
        newNameProject.sendKeys(" New");
		save.click();
		Alert alert = wait.until((ExpectedConditions.alertIsPresent()));
		alert.dismiss();
		return true;
		}catch(Exception e) {
			System.out.println(e);
			return false;
		}
	}
	
	public Boolean deleteProject() {
		try{
		Projects.click();
		deleteProject.click();
		Alert alert = wait.until((ExpectedConditions.alertIsPresent()));
		alert.accept();
		return true;
		}catch(Exception e) {
			System.out.println(e);
			return false;
		}
	}
	
	public Boolean addMentor(String name1,String email1,String num,String pwd) {
		try{
			mentorForm.click();
		name.sendKeys(name1);
		email.sendKeys(email1);
		number.sendKeys(num);
		password.sendKeys(pwd);
		projectTopic.click();
		System.out.println("1");
		WebElement pt = driver.findElement(By.xpath("//*[contains(text(),'ICTAK Internship portal- student view')]"));
		pt.click();
		pt.sendKeys(Keys.ESCAPE); 
		System.out.println("2");
		System.out.println("3");
			System.out.println(submit.isEnabled());
			submit.click();
			System.out.println("Add mentor submit clicked");
			Alert alert = wait.until((ExpectedConditions.alertIsPresent()));
			alert.accept();
			System.out.println("Finished add mentor");
			return true;
		}catch(Exception e) {
			if(!(email1.contains("@"))) {
				System.out.println("Invalid Email");
				return true;
			}
			return false;
		}
		
	}
	
	public Boolean addMentorBlank(String name1,String email1,String pwd) {
		
			mentorForm.click();
		name.sendKeys(name1);
		email.sendKeys(email1);
		password.sendKeys(pwd);
		projectTopic.click();
		System.out.println("1");
		WebElement pt = driver.findElement(By.xpath("//*[contains(text(),'ICTAK Internship portal- student view')]"));
		pt.click();
		pt.sendKeys(Keys.ESCAPE); 
		System.out.println("2");
		System.out.println("3");
			System.out.println(submit.isEnabled());
			submit.click();
			System.out.println("Add mentor submit clicked");
			System.out.println(blankMsg.isDisplayed());
			if (blankMsg.isDisplayed())
				return true;
			else
				return false;
		
	}
	
	public Boolean editMentor(String newName) {
		try {
			mentors.click();
			List<WebElement> allUpdate=driver.findElements(By.xpath("//button[text()='Update']"));
			int count=allUpdate.size();
			System.out.println("Clicking last update");
			allUpdate.get(count-1).click();
			name.clear();
			name.sendKeys(newName);
			submit.click();
//			Alert alert = wait.until((ExpectedConditions.alertIsPresent()));
//			alert.accept();
			return true;
		}catch(Exception e) {
			System.out.println("Update Mentor failed");
			return false;
		}
	}
	
	public Boolean deleteMentor() {
		try {
		mentors.click();
		List<WebElement> allDelete=driver.findElements(By.xpath("//button[text()='Delete']"));
		int count=allDelete.size();
		System.out.println("Clicking last delete");
		allDelete.get(count-1).click();
		Alert alert = wait.until((ExpectedConditions.alertIsPresent()));
		alert.accept();
		return true;
	}catch(Exception e) {
		System.out.println("Deletion of Mentor failed");
		return false;
	}
	}
	
	public Boolean duplicateMentor(String name1,String email1,String num,String pwd) {
		try{
			mentorForm.click();
		name.sendKeys(name1);
		email.sendKeys(email1);
		number.sendKeys(num);
		password.sendKeys(pwd);
		projectTopic.click();
		System.out.println("1");
		WebElement pt = driver.findElement(By.xpath("//*[contains(text(),'ICTAK Internship portal- student view')]"));
		pt.click();
		pt.sendKeys(Keys.ESCAPE); 
		System.out.println("2");
		System.out.println("3");
			System.out.println(submit.isEnabled());
			submit.click();
			if(duplicateMsg.isDisplayed()) {
				return true;
			}else {
				System.out.println("Duplicate mentor message not displayed");
				return false;
			}
		}catch(Exception e) {
			return false;
		}
	}
}
