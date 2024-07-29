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

public class MentorDbPage {
	WebDriver driver;
	WebDriverWait wait;

	public MentorDbPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		this.wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	}

	@FindBy(xpath="//h6[text()='ICTAK-Mentor Dashboard']")
	WebElement mentorHome;
	
	@FindBy(css="button[type='button']")
	WebElement show;
	
	@FindBy(xpath="(//a[text()='VIEW'])[1]")
	WebElement viewProject;
	
	@FindBy(xpath="(//td[@class='MuiTableCell-root MuiTableCell-body MuiTableCell-sizeMedium css-q34dxg'])[5]")
	WebElement status;
	
	@FindBy(xpath="(//a[text()='VIEW'])[1]")
	WebElement viewButton;
	
	@FindBy(css="div[role='combobox']")
	WebElement marks;
	
	@FindBy(css="ul[role='listbox']")
	WebElement selMarks;
	
	@FindBy(css="li[data-value='9']")
	WebElement newMark;
	
	@FindBy(css="textarea[name='Comments']")
	WebElement comments;
	
	@FindBy(xpath="(//button[text()='DELETE'])[1]")
	WebElement delete;
	
	@FindBy(css="div[role='combobox']")
	WebElement filter;
	
	@FindBy(css="li[data-value='KKEM March MLAI']")
	WebElement batch;
	
	@FindBy(xpath="//td[text()='KKEM March MLAI']")
	WebElement batchResult;
	
	@FindBy(css="li[data-value='Software Testing']")
	WebElement topic;
	
	@FindBy(xpath="//td[text()='Software Testing']")
	WebElement topicResult;
	
	@FindBy(xpath="//a[text()='Reference Material']")
	WebElement referenceButton;
	
	@FindBy(xpath="(//button[@type='button'])[1]")
	WebElement addRef;
	
	@FindBy(xpath="(//input[@type='text'])[1]")
	WebElement title;
	
	@FindBy(xpath="(//input[@type='text'])[2]")
	WebElement description;
	
	@FindBy(xpath="(//input[@type='text'])[3]")
	WebElement link;
	
	@FindBy(xpath="(//button[@type='button'])[4]")
	WebElement add;
	
	@FindBy(xpath="//button[text()='Add']")
	WebElement addrefMat;
	
	public Boolean safeLanding() {
		wait.until(ExpectedConditions.visibilityOf(mentorHome));
		show.click();
		List<WebElement> allProjects = driver.findElements(By.cssSelector("div[class='MuiPaper-root MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation1 MuiCard-root css-s18byi']"));
		int count=allProjects.size();
//		System.out.println(count);
		if(count>0)
			return true;
		else
			return false;
	}
		
	public Boolean projectDetails() {
		viewProject.click();
		List<WebElement> projectDetails = driver.findElements(By.cssSelector("td[class='MuiTableCell-root MuiTableCell-body MuiTableCell-sizeMedium css-q34dxg']"));
		int count=projectDetails.size();
//		System.out.println(count);
		if(count>0)
			return true;
		else
			return false;
	}
	
	public Boolean checkStatus() {
		viewProject.click();
		String statusmsg=status.getText();
		System.out.println(statusmsg);
		if(statusmsg.equalsIgnoreCase("Completed")||statusmsg.equalsIgnoreCase("Pending")) {
			return true;
		}else {
			System.out.println("Evaluation status is not Completed/Pending");
			return false;
		}
	}
	
	public Boolean evaluateSubmission() {
		try{
			viewProject.click();
		viewButton.click();
		marks.click();
		newMark.click();
		newMark.sendKeys(Keys.ESCAPE);
		System.out.println("New mark entered");
		comments.sendKeys("Good Work");
		System.out.println("New comment entered");
		show.click();
		Alert alert = wait.until((ExpectedConditions.alertIsPresent()));
		alert.accept();
		return true;
		}catch(Exception e) {
			System.out.println(e);
			return false;
		}
	}
	
	public Boolean deleteSubmission() {
		try{
			viewProject.click();
			delete.click();
			Alert alert = wait.until((ExpectedConditions.alertIsPresent()));
			alert.accept();
			return true;
		}catch(Exception e) {
			System.out.println("Submission not deleted");
			return false;
		}
	}
	
	public Boolean batchWiseFilter() {
		try {
			viewProject.click();
			filter.click();
			batch.click();
			System.out.println("Batch filter entering");
			batch.sendKeys(Keys.ESCAPE);
			System.out.println("Batch filter entered");
			return batchResult.isEnabled();
		}catch(Exception e) {
			System.out.println("Batchwise filter failed");
			return false;
		}
	}
	
	public Boolean topicWiseFilter() {
		try {
			viewProject.click();
			filter.click();
			if(!driver.findElements(By.cssSelector("li[data-value='Software Testing']")).isEmpty()){
				System.out.println("Inside empty topic filter");
			topic.click();
			topic.sendKeys(Keys.ESCAPE);
			return topicResult.isEnabled();
			}else {
				return false;
			}
		}catch(Exception e) {
			System.out.println("Topicwise filter failed");
			return false;
		}finally {
			driver.close();
		}
	}
	
	public Boolean addReference() {
		try{
			System.out.println("Inside add reference");
			referenceButton.click();
		addRef.click();
		title.sendKeys("Selenium For Testing");
		description.sendKeys("Selenium is a popular open-source testing tool used for web application testing. It enables testers to write automated tests in various programming languages to test the functionality of web applications.");
		link.sendKeys("https://testsigma.com/blog/selenium-based-automated-testing/");
		System.out.println("Entered reference details.");
		addrefMat.click();
		return true;
		}catch(Exception e) {
			System.out.println("Add reference failed");
			return false;
		}
	}
		
		public Boolean deleteReference() {
			try{
				System.out.println("Inside delete reference");
//				referenceButton.click();
				System.out.println("taking refereals");
				List<WebElement> allDeletes = driver.findElements(By.xpath("//button[text()='Delete']"));
				int count=allDeletes.size();
				System.out.println(count);
				allDeletes.get(count-1).click();
				if(count>0)
					return true;
				else
					return false;
			}catch(Exception e) {
				System.out.println("Delete reference failed");
				return false;
			}
	}
	
}
