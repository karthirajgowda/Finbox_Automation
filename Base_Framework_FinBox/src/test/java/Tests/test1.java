package Tests;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class test1 {

		
		@DataProvider(name = "registerData")
		public Object[][] register() {
			Object[][] data=new Object[1][5];
			data[0][0]="karthik1";
			data[0][1]="raj";
			data[0][2]="karthi@gmail11.com";
			data[0][3]="karthi@123";
			data[0][4]="karthi@123";
			return data;
		}
		
		@Test(dataProvider = "registerData" )
		public void registerTC(String firstname,String lastname,String email,String password,String confirmPassword)
		{
			System.out.println(firstname);	
			System.out.println(lastname);
		}
		
		
		@Test
		public Object[][] data(String Sheetname) throws Exception
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
		
		@DataProvider(name="PI")
		public Object[][] PersonalInfo() throws Exception{
			Object[][] data=data("Sheet1");
			return data;
			
		}
		
		@Test(dataProvider = "PI")
		public void zz(String name,String email)
		{
			System.out.println(name);
			System.out.println(email);
			System.out.println("-------------------");
			
		}
		   
			
		}
