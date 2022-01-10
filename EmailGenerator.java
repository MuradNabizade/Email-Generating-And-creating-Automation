package EmailGen;

import java.time.Duration;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class EmailGenerator {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","/Users/muradnabizade/Downloads/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://accounts.google.com/signup/v2/webcreateaccount?service=mail&continue=https%3A%2F%2Fmail.google.com%2Fmail%2Fu%2F0%2F&dsh=S1661548177%3A1641777274895512&biz=false&flowName=GlifWebSignIn&flowEntry=SignUp");
		Scanner scan= new Scanner(System.in);
		
		
		String firstName=  RandomString.getAlphaNumericString(5);
		String lastName= RandomString.getAlphaNumericString(5);
		String genNum="933";
		
		System.out.println("First Name: " +firstName);
		System.out.println("Last Name: " + lastName );
		
		String email = firstName+lastName+ genNum;
		System.out.println("Your Email or username: "+email);
		
		String password= RandomString.getAlphaNumericString(10)+"000";
		System.out.println("Yur password: "+password);
		driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys(firstName);
		driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys(lastName);
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(email);
		
		driver.findElement(By.xpath("//input[@name='Passwd']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@name='ConfirmPasswd']")).sendKeys(password);
	
	
		driver.findElement(By.xpath("//input[@id='i3']")).click();
	
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@class='VfPpkd-LgbsSe VfPpkd-LgbsSe-OWXEXe-k8QpJ VfPpkd-LgbsSe-OWXEXe-dgl2Hf nCP5yc AjY5Oe DuMIQc qIypjc TrZEUc lw1w4b']")).click();
		
		
		if(driver.findElement(By.id("phoneNumberId")).isEnabled()) {
		System.out.println("Google is asking for phone number. Please enter your phone number:");
		String phoneNum= "8087736676";
		
		
		driver.findElement(By.xpath("//input[@id='phoneNumberId']")).sendKeys(phoneNum);
		
		//driver.findElement(By.xpath("//body/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/button[1]/div[3]")).click();
		Actions a= new Actions(driver);
		WebElement move = driver.findElement(By.xpath("//body/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/button[1]/div[3]"));
		
		//move to target
		a.moveToElement(driver.findElement(By.xpath("//body/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/button[1]/div[3]"))).click().build().perform();
		}
		
	}


	
	
	
	
	
	
	
	
	
	
	
	
	
 static class RandomString {
	  
    static // function to generate a random string of length n
     String getAlphaNumericString(int n)
    {
  
        // chose a Character random from this String
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                                    + "0123456789"
                                    + "abcdefghijklmnopqrstuvxyz";
  
        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(n);
  
        for (int i = 0; i < n; i++) {
  
            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index
                = (int)(AlphaNumericString.length()
                        * Math.random());
  
            // add Character one by one in end of sb
            sb.append(AlphaNumericString
                          .charAt(index));
        }
  
        return sb.toString();
    	}

 	}
}