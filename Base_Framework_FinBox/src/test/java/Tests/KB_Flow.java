package Tests;



import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Generic.Base_test;
import Generic.UtilityMethods;
import Pages.Personal_Information_1;



public class KB_Flow extends Base_test{

/*	@Test
	public void dataq() throws IOException {
		File f=new File("./TestData/config.properties.txt");
		FileInputStream fe =new FileInputStream(f);
		Properties p=new Properties();
		p.load(fe);
		System.out.println(p.get("UN"));
	}   */
	
	@DataProvider(name="PI")
	public Object[][] PersonalInfo() throws Exception{
		Object[][] data = UtilityMethods.getExcelData("Sheet1");
		return data;
		
	}
	
	@Test
	public void checkbox()
	{
		Personal_Information_1 pi=new Personal_Information_1(driver);
		pi.clickCheckBox();
	}
	//Executing 1st page Scripts
	@Test(dataProvider = "PI",dependsOnMethods = "checkbox")
	public void Personal_Information_Scripts_1(String name,String email) throws InterruptedException
	{
		Personal_Information_1 pi=new Personal_Information_1(driver);
		pi.enterYourFullName(name);
		pi.enterEmailAddress(email);
		pi.clicknextButton();	
		Thread.sleep(2000);
	}
	
}
