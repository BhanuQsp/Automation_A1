package generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

//import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

//Automation Utility Library
public class AUL {
	public static String getProperty(String path,String key){
		String v="";
		try{
			Properties p=new Properties();
			p.load(new FileInputStream(path));
			v=p.getProperty(key);
		}
		catch(Exception e){
		}
		return v;
	}
	//Method to take screen shot of App
	public static void takePhoto(String folder,String TestName,WebDriver driver){
		String dateTime = new Date().toString().replaceAll(":","_");
		TakesScreenshot t=(TakesScreenshot)driver;
		File srcFile = t.getScreenshotAs(OutputType.FILE);
		String dstPath=folder+TestName+dateTime+".png";
		try {
			//FileUtils.copyFile(srcFile,new File(dstPath));
		} catch (Exception e) {
		}
	}
}








