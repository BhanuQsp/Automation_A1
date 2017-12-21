package script;

import page.LoginPage;
import org.testng.annotations.Test;
import generic.BaseTest;
import generic.Excel;
import page.EnterTimeTrackPage;

public class ValidLogin extends BaseTest {
	@Test(priority=1,groups={"smoke","login"})
	public void testValidLogin(){
		
		//Enter valid User Name
		LoginPage l=new LoginPage(driver); 
		l.setUserName("admin");
		//Enter valid password
		l.setPassword("manager");
		//Click on login
		l.clickLogin();
		//verify that Home Page is Displayed
		EnterTimeTrackPage e=new EnterTimeTrackPage(driver);
		e.verifyTitle(driver,"actiTIME - Enter Time-Track");
	}
}

