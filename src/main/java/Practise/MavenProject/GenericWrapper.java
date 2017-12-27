package Practise.MavenProject;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;



import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

public abstract class GenericWrapper{
	
	public RemoteWebDriver driver;
	int i=1;

	public void invokeApp(String browserName, String url) {
		
		try {
			if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			driver=new ChromeDriver();
			
			}
			if(browserName.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
			driver=new FirefoxDriver();
			}
			driver.navigate().to(url);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			System.out.println("the browser " + browserName + " launched succesfully");
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			System.out.println("the browser "+browserName+" failed to launch.");
		}
		finally {
			takeSnap();
		}
	}

	
	public void enterById(String id, String data)
	{
		try {
			driver.findElement(By.id(id)).clear();
			driver.findElement(By.id(id)).sendKeys(data);
			System.out.println("The data "+data+" entered successfully in the field "+id);
		} catch (NoSuchElementException e) {
			System.out.println("The data "+data+" could not be entered in the field "+id);
		}catch (ElementNotVisibleException e) {
		    System.out.println("element no visible because of "+id);
		} 
		catch (WebDriverException e) {
			System.out.println("unexpected error occurred because of idValue as "+id);
		}
		
		
		finally {
			takeSnap();
		}
	}
	

	public void enterByName(String nameValue, String data) 
	{
		try {
			driver.findElement(By.name(nameValue)).clear();
			driver.findElement(By.name(nameValue)).sendKeys(data);
			System.out.println("The data "+data+" entered successfully in the field "+nameValue);
		} catch (NoSuchElementException e) {
			System.out.println("The data "+data+" could not be entered in the field "+nameValue);
		}catch (ElementNotVisibleException e) {
		    System.out.println("element no visible because of nameValue as "+nameValue);
		} 
		catch (WebDriverException e) {
			System.out.println("unexpected error occurred because of nameValue as "+nameValue);
		}
		
		
		finally {
			takeSnap();
		}
		
	}

	public void enterByXpath(String xpathValue, String data)
	{
		try {
			driver.findElement(By.xpath(xpathValue)).clear();
			driver.findElement(By.xpath(xpathValue)).sendKeys(data);
			System.out.println("The data "+data+" entered successfully in the field "+xpathValue);
		} catch (NoSuchElementException e) {
			System.out.println("The data "+data+" could not be entered in the field "+xpathValue);
		}catch (ElementNotVisibleException e) {
		    System.out.println("element no visible because of xpath locator as "+xpathValue);
		} 
		catch (WebDriverException e) {
			System.out.println("unexpected error occurred because of xpath locator as "+xpathValue);
		}
		
		
		finally {
			takeSnap();
		}
		
	}

	public boolean verifyTitle(String title) {
		boolean bReturns=false;
		try {
			if(driver.getTitle().equals(title))
			{
				System.out.println("title is verified");
			}
			bReturns=true;
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			System.out.println("not able to verify using " + title);
		}
		finally {
			takeSnap();
		}
		return bReturns;
		
		
		
	}

	public void verifyTextById(String id, String text) {
		// TODO Auto-generated method stub
		try {
			if(driver.findElement(By.id(id)).getText().equals(text))
			{
				System.out.println("Text is Verified");
			}
			else
			{
				System.out.println("text is not verified");
			}
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			System.out.println("error occured while verifying text with "+id);
		}
		
		finally {
			takeSnap();
		}
	}

	public void verifyTextByXpath(String xpath, String text) {
		try {
			if(driver.findElement(By.xpath(xpath)).getText().equals(text))
			{
				System.out.println("Text is Verified");
			}
			else
			{
				System.out.println("text is not verified");
			}
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			System.out.println("error occured while verifying text with "+xpath);
		}
		
		finally {
			takeSnap();
		}
		
	}

	public void verifyTextContainsByXpath(String xpath, String text) {
		try {
			if(driver.findElement(By.xpath(xpath)).getText().contains(text))
			{
				System.out.println("Text is Verified");
			}
			else
			{
				System.out.println("text is not verified");
			}
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			System.out.println("error occured while verifying text with "+xpath);
		}
		
		finally {
			takeSnap();
		}
		
		
	}

	public void verifyTextContainsById(String id, String text) {
		try {
			if(driver.findElement(By.id(id)).getText().contains(text))
			{
				System.out.println("Text is Verified");
			}
			else
			{
				System.out.println("text is not verified");
			}
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			System.out.println("error occured while verifying text with "+id);
		}
		
		finally {
			takeSnap();
		}
	}

	public void clickById(String id) {
		try {
			driver.findElement(By.id(id)).click();
			System.out.println("the element "+id+" was successfully clicked.");
		}catch (NoSuchElementException e) {
			System.out.println("The element "+id+" was not able to click");
		}
		catch (WebDriverException e) {
			System.out.println("unexpected error occurred");
		}
		
		finally {
			takeSnap();
		}
		
	}

	public void clickByClassName(String classVal) {
		try {
			driver.findElement(By.className(classVal)).click();
			System.out.println("the element "+classVal+" was successfully clicked.");
		}catch (NoSuchElementException e) {
			System.out.println("The element "+classVal+" was not able to click");
		}
		catch (WebDriverException e) {
			System.out.println("unexpected error occurred");
		}
		
		finally {
			takeSnap();
		}
		
	}

	public void clickByName(String name) {
		try {
			driver.findElement(By.name(name)).click();
			System.out.println("the element "+name+" was successfully clicked.");
		}catch (NoSuchElementException e) {
			System.out.println("The element "+name+" was not able to click");
		}
		catch (WebDriverException e) {
			System.out.println("unexpected error occurred");
		}
		
		finally {
			takeSnap();
		}
		
	}

	public void clickByLink(String name) {
		try {
			driver.findElement(By.linkText(name)).click();
			System.out.println("the element "+name+" was successfully clicked.");
		}catch (NoSuchElementException e) {
			System.out.println("The element "+name+" was not able to click");
		}
		catch (WebDriverException e) {
			System.out.println("unexpected error occurred");
		}
		
		finally {
			takeSnap();
		}
		
	}
	
	public void clickByLinkwithoutSnap(String name) {
		try {
			driver.findElement(By.linkText(name)).click();
			System.out.println("the element "+name+" was successfully clicked.");
		}catch (NoSuchElementException e) {
			System.out.println("The element "+name+" was not able to click");
		}
		catch (WebDriverException e) {
			System.out.println("unexpected error occurred");
		}
		
		
		
	}

	public void clickByXpath(String xpathVal) {
		try {
			driver.findElement(By.xpath(xpathVal)).click();
			System.out.println("the element "+xpathVal+" was successfully clicked.");
		}catch (NoSuchElementException e) {
			System.out.println("The element "+xpathVal+" was not able to click");
		}
		catch (WebDriverException e) {
			System.out.println("unexpected error occurred");
		}
		
		finally {
			takeSnap();
		}
		
	}

	public String getTextById(String idVal) {
		String text=null;
		try {
			text = driver.findElement(By.id(idVal)).getText();
			
		} catch (WebDriverException e) {
			System.out.println("not able to verify using id value"+ idVal);
		}
		
		
		finally {
			takeSnap();
		}
		
		return text;
	}

	public String getTextByXpath(String xpathVal) {
		String text=null;
		try {
			text = driver.findElement(By.xpath(xpathVal)).getText();
			
		} catch (WebDriverException e) {
			System.out.println("not able to verify using xpath value "+xpathVal);
		}
		
		
		finally {
			takeSnap();
		}
		
		return text;
	}

	public void selectVisibileTextById(String id, String value) {
		
		WebElement element=driver.findElement(By.id(id));
		Select sel=new Select(element);
		sel.selectByValue(value);
		
	}

	public void selectIndexById(String id, int i) {
		WebElement element=driver.findElement(By.id(id));
		Select sel=new Select(element);
		sel.selectByIndex(i);
		
	}


	public void acceptAlert() {
		// TODO Auto-generated method stub
		driver.switchTo().alert().accept();
	}
	
	public void dismissAlert() {
		// TODO Auto-generated method stub
		driver.switchTo().alert().dismiss();
	}

	public void quitBrowser() {
		// TODO Auto-generated method stub
		driver.quit();
	}
	
	public void closeBrowser() {
		// TODO Auto-generated method stub
		driver.close();
	}

	public void takeSnap() {
		File src = driver.getScreenshotAs(OutputType.FILE);
		File dest=new File("./snaps/img"+i+".png");
		i++;
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void switchToWindow(int index) {
		try {
			Set<String> allWindowHandles = driver.getWindowHandles();
			System.out.println("number of windows "+allWindowHandles.size());
			List<String> allHandles = new ArrayList<String>();
			allHandles.addAll(allWindowHandles);
			driver.switchTo().window(allHandles.get(index));
			
		} catch (NoSuchWindowException e) {
			System.out.println("The driver could not move to the given window by index "+index);
		} catch (WebDriverException e) {
			System.out.println("WebDriverException : "+e.getMessage());
		}
	}

}

