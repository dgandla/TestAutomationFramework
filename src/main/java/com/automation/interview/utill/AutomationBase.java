package com.automation.interview.utill;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;


public class AutomationBase {
	public WebDriver driver;
	private StringBuilder screenDir;
	private int count = 1;
	
	private String getScreenDir() {
		if (null == screenDir) {
			screenDir = new StringBuilder(Config.getScreenOutDir());
			File dir = new File(screenDir.toString());
			if (!(dir.exists()))
				dir.mkdirs();
		}
		return screenDir.toString();
	}
	
	private String buildPath(String filename) {
		StringBuilder sb = new StringBuilder(getScreenDir());
		sb.append(File.separatorChar).append(buildFilename(filename));
		return sb.toString();
	}
	
	
	
	public void captureScreen(String filename) {
		String filePath = buildPath(filename);
		CaptureScreenshot.capture(driver, filePath);
	}
	private String buildFilename(String name) {
		String pName = this.getClass().getName();
		StringBuilder sb = new StringBuilder(name);
		sb.append("_").append(pName.substring(pName.lastIndexOf(".") + 1)).append("_").append(count).append(".png");
		count++;
		return sb.toString();
	}
	
	@BeforeSuite
	public void Intialize() throws Exception {
		Config.getDriver();		
	}
		
}
