package Generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Set;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
 


public class UtilityMethods {



	public WebDriver driver;	
	public static Sheet sheet;

	public void get_title() {
		String title= driver.getTitle();
		System.out.println(title);
	}

	public void get_url() {		
		String CurrentURL=driver.getCurrentUrl();
		System.out.println(CurrentURL);
	}
	
	public void clearTextField(WebElement elementToClear)
	{
		elementToClear.clear();
	}

	public void clickAction(WebElement element_To_Click) {
		element_To_Click.click();
	}

	public void enter_value(WebElement TextField,String value) {		
		clearTextField(TextField);
		TextField.sendKeys(value);
	}

	public Select select_classObject(WebElement DropDown){		
		Select select= new Select(DropDown);		
		return select;		
	}

	public Actions actions_classObject(WebDriver driver) {		
		Actions action=new Actions(driver);
		return action;

	}
	public void switchToASpecificTitledWindow(String title) { 
		String parentWindowId = driver.getWindowHandle(); 

		Set<String> allWindowIds = driver.getWindowHandles(); allWindowIds.remove(parentWindowId); 
		for(String windowId:allWindowIds){ driver.switchTo().window(windowId);
		if(driver.getTitle().equalsIgnoreCase(title)){ 
			break; 
		} 
		} 
	} 
	public void switchToASpecificWindow(WebElement element) {

		String parent=driver.getWindowHandle(); 
		Set<String> allWid=driver.getWindowHandles(); 
		allWid.remove(parent); 
		for(String sessionID:allWid){ 
			driver.switchTo().window(sessionID);

			if(element.isDisplayed()){ 
				break; 
			} 
		} 
	}
	            
	
	                      //Getting data from excel
	
	public static Object[][] getExcelData(String Sheetname) throws Exception
	{
		File f=new File("./TestData/q.xlsx");
		FileInputStream fis=new FileInputStream(f);
		Workbook book=new XSSFWorkbook(fis);
	    Sheet sheet = book.getSheet(Sheetname);
	    int r = sheet.getPhysicalNumberOfRows();
		int c = sheet.getRow(0).getPhysicalNumberOfCells();
		//System.out.println(r);
		//System.out.println(c);
		
		Row row=sheet.getRow(0);
		short lr = row.getLastCellNum();
		System.out.println(lr);

		Object[][] data=new Object[r][c];
		for(int i=0;i<r;i++)
		{
			for(int j=0;j<lr;j++)
			{
				String value = sheet.getRow(i).getCell(j).getStringCellValue();
				data[i][j]=value;
				//System.out.println(value);
				
			}
		}
		return data;	
	}
}
