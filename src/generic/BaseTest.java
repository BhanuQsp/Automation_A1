package generic;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public abstract class BaseTest implements IAutoConst{
	public WebDriver driver;
	
	@Parameters({"browser","ip"})
	@BeforeMethod(alwaysRun=true)
	public void openApplication(@Optional("chrome")String browser,String ip) throws MalformedURLException{
		URL remote=new URL("http://"+ip+":4444/wd/hub");
		DesiredCapabilities dc;
		if(browser.equals("chrome")){
			dc= DesiredCapabilities.chrome();
		}
		else{
			dc= DesiredCapabilities.firefox();
		}
		driver=new RemoteWebDriver(remote,dc);
		String AUT=AUL.getProperty(SETTING_PATH,"AUT");
		driver.get(AUT);
		String strITO=AUL.getProperty(SETTING_PATH, "ITO");
		long ITO = Long.parseLong(strITO);
		driver.manage().timeouts().implicitlyWait(ITO,TimeUnit.SECONDS);
	}
	@AfterMethod(alwaysRun=true)
	public void closeApplication(ITestResult res){
		String testName=res.getName();
		if(res.getStatus()==2){
			AUL.takePhoto(PHOTO_PATH,testName, driver);
		}
		driver.quit();
	}
}










