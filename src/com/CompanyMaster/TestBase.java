package com.CompanyMaster;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.CompanyMaster.CompanyMaster;
import com.excelRead.XlsReader;

import junit.framework.Assert;

public class TestBase {
	static XlsReader reader;
	static WebDriver driver;
	static Properties prop;

	public String workingDir;
	
	HSSFWorkbook workbook;
	// Declare An Excel Work Sheet
	HSSFSheet sheet;
	// Declare A Map Object To Hold TestNG Results
	Map<String, Object[]> TestNGResults;
	 
	@Test(description = "Opens the Website for Login Test", priority = 1)
	public void LaunchWebsite() throws Exception {

		try {
			driver.get(prop.getProperty("url"));
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			TestNGResults.put("2", new Object[] { 1d, "Navigate to website", "Site gets opened", "Pass" });
		} catch (Exception e) {
			TestNGResults.put("2", new Object[] { 1d, "Navigate to website", "Site gets opened", "Fail" });
			Assert.assertTrue(false);
		}
	}
	
	
	@Test(description = "Fill the Login Details", priority = 2)
	public void FillLoginDetails() throws Exception {

		try {
			// Get the username element
			WebElement username = driver.findElement(By.xpath("//*[@id='myLogin_UserName']"));
			username.sendKeys(prop.getProperty("username"));

			// Get the password element
			WebElement password = driver.findElement(By.xpath("//*[@id='myLogin_Password']"));
			password.sendKeys(prop.getProperty("password"));

		Thread.sleep(1000);
			TestNGResults.put("3", new Object[] { 2d, "Fill Login form data (Username/Password)",
					"Login details gets filled", "Pass" });

		} catch (Exception e) {
			TestNGResults.put("3",
					new Object[] { 2d, "Fill Login form data (Username/Password)", "Login form gets filled", "Fail" });
			Assert.assertTrue(false);
		}
	}
	
	@Test(description = "Perform Login", priority = 3)
	public void DoLogin() throws Exception {

		try {
			// Click on the Login button
			WebElement login = driver.findElement(By.xpath("//*[@id='myLogin_LoginButton']"));
			login.click();

			Thread.sleep(2000);
			// Assert the user login by checking the Online user
			String PageTitle = driver.getTitle();
			System.out.println("Page Title is : " + PageTitle);
			TestNGResults.put("4", new Object[] { 3d, "Click Login and verify Dashboard", "Login success", "Pass" });
		} catch (Exception e) {
			TestNGResults.put("4",
					new Object[] { 3d, "Click Login and verify Dashboard", "Login success", "Fail" });
			Assert.assertTrue(false);
		}
	}
	
	@Test(description = "Fill Company Master Form", priority = 4)
	public void FillCompanyMasterForm() throws Exception {
		try{
			reader = new XlsReader(prop.getProperty("xlsPath"));
						
			}catch(Exception e){
				e.printStackTrace();
				}
		int rowCount = reader.getRowCount("CompanyMaster");
		
		for(int rowNo=2; rowNo<=rowCount; rowNo++){
			Thread.sleep(2000);
			WebElement element = driver.findElement(By.xpath("//*[@id='aspnetForm']/div[3]/div[1]/a[2]"));
			element.click();
		Thread.sleep(1500);
			Actions Action = new Actions(driver);
			WebElement element1 = driver.findElement(By.id("ctl00_rptMenu_ctl01_masters"));
			Action.moveToElement(element1).click().build().perform();
		Thread.sleep(1500);
			Actions Action1 = new Actions(driver);
			WebElement element2 = driver.findElement(By.xpath("//*[@id='ctl00_rptMenu_ctl01_rptSubMenu_ctl00_HyperLink1']"));
			Action1.moveToElement(element2).click().build().perform();
		Thread.sleep(2000);
			driver.findElement(By.id("ctl00_ContentPlaceHolder1_ucCompanyMaster1_btnNew")).click();
		
			String CompanyName = reader.getCellData("CompanyMaster", "CompanyName", rowNo);
			String CompanyRegNo = reader.getCellData("CompanyMaster", "CompanyRegNo", rowNo);
			String InvoiceNoType = reader.getCellData("CompanyMaster", "InvoiceNoType", rowNo);
			String TaxInvoicePrefix = reader.getCellData("CompanyMaster", "TaxInvoicePrefix", rowNo);
			String MobileNo = reader.getCellData("CompanyMaster", "MobileNo", rowNo);
			String Email = reader.getCellData("CompanyMaster", "Email", rowNo);
			String Address1 = reader.getCellData("CompanyMaster", "Address1", rowNo);
			String Address2 = reader.getCellData("CompanyMaster", "Address2", rowNo);
			String Address3 = reader.getCellData("CompanyMaster", "Address3", rowNo);
			String Pincode = reader.getCellData("CompanyMaster", "Pincode", rowNo);
			String City = reader.getCellData("CompanyMaster", "City", rowNo);
			String State = reader.getCellData("CompanyMaster", "State", rowNo);
			String RegDateYear = reader.getCellData("CompanyMaster", "RegDateYear", rowNo);
			String RegDateMonth = reader.getCellData("CompanyMaster", "RegDateMonth", rowNo);
			String RegDateDay = reader.getCellData("CompanyMaster", "RegDateDay", rowNo);
			String RenewalDateYear = reader.getCellData("CompanyMaster", "RenewalDateYear", rowNo);
			String RenewalDateMonth = reader.getCellData("CompanyMaster", "RenewalDateMonth", rowNo);
			String RenewalDateDay = reader.getCellData("CompanyMaster", "RenewalDateDay", rowNo);
			String BankName = reader.getCellData("CompanyMaster", "BankName", rowNo);
			String BranchName = reader.getCellData("CompanyMaster", "BranchName", rowNo);
			String BankAcNo = reader.getCellData("CompanyMaster", "BankAcNo", rowNo);
			String IFSC = reader.getCellData("CompanyMaster", "IFSC", rowNo);
			String AccountType = reader.getCellData("CompanyMaster", "AccountType", rowNo);
			
			int RowNumber = rowNo-1;
			System.out.println("         ");
			System.out.println("****Output : "+ RowNumber +"*******");
			System.out.println("         ");

			
			CompanyMaster.CoMaster(CompanyName, CompanyRegNo,InvoiceNoType, TaxInvoicePrefix, MobileNo, Email, Address1, Address2, Address3, Pincode, City, State,
			RegDateYear, RegDateMonth, RegDateDay, RenewalDateYear, RenewalDateMonth, RenewalDateDay, BankName, BranchName, BankAcNo, IFSC, AccountType );
		}
		
		try {
			TestNGResults.put("5", new Object[] { 4d, "Fill Details on Company Master Form", "Company Master Form Filled", "Pass" });
			} catch (Exception e) {
				TestNGResults.put("5",new Object[] { 4d, "Fill Details on Company Master  Form", "Company Master Form Filled", "Fail" });
			Assert.assertTrue(false);s
		}
	}
	
	@Test(description = "Logout From the Application", priority = 5)
	public void Logout() throws Exception {
		try {
	//Logout function
		WebElement logout = driver.findElement(By.id("ctl00_lblusername"));
				logout.click();
		Thread.sleep(3000);
				WebElement Logout1 = driver.findElement(By.id("ctl00_hyLogOut"));
				Logout1.click();
		Thread.sleep(4000);
			
		TestNGResults.put("6", new Object[] { 5d, "Click on Logout", "Logout Successfully", "Pass" });
		} catch (Exception e) {
			TestNGResults.put("6",
					new Object[] { 5d, "Click on Logout", "Logout Successfully", "Fail" });
			Assert.assertTrue(false);
		}
	}
	
@BeforeClass(alwaysRun = true)
	public void suiteSetUp() {

		// create a new work book
		workbook = new HSSFWorkbook();
		// create a new work sheet
		sheet = workbook.createSheet("TestNG Result Summary");
		TestNGResults = new LinkedHashMap<String, Object[]>();
		// add test result excel file column header
		// write the header in the first row
		TestNGResults.put("1", new Object[] { "Test Step No.", "Action", "Expected Output", "Actual Output" });

		try {
			prop = new Properties();
			FileInputStream input = new FileInputStream("D:\\Mayuresh\\Mayuresh Data\\Workspace\\CompanyMasterMyFleetMan\\src\\objectRepository\\ObjectRepository.properties");
		    prop.load(input); 
		    
		    System.out.println(prop.getProperty("browser"));
		    String browserName = prop.getProperty("browser");
		
		    if(browserName.equals("chrome")){
				System.setProperty("webdriver.chrome.driver", prop.getProperty("chromePath"));	
				driver = new ChromeDriver(); 
			}
			else if(browserName.equals("Firefox")){
				System.setProperty("webdriver.gecko.driver", prop.getProperty("firefoxPath"));	
				driver = new FirefoxDriver(); 
			}
			else {
				System.out.println("Browser not Found");
				}
		    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		} catch (Exception e) {
			throw new IllegalStateException("Can't start the Chrome Web Driver", e);
		}
	}

	@AfterClass
	public void suiteTearDown() {
		// write excel file and file name is SaveTestNGResultToExcel.xls
		Set<String> keyset = TestNGResults.keySet();
		int rownum = 0;
		for (String key : keyset) {
			Row row = sheet.createRow(rownum++);
			Object[] objArr = TestNGResults.get(key);
			int cellnum = 0;
			for (Object obj : objArr) {
				Cell cell = row.createCell(cellnum++);
				if (obj instanceof Date)
					cell.setCellValue((Date) obj);
				else if (obj instanceof Boolean)
					cell.setCellValue((Boolean) obj);
				else if (obj instanceof String)
					cell.setCellValue((String) obj);
				else if (obj instanceof Double)
					cell.setCellValue((Double) obj);
			}
		}
		try {
			FileOutputStream out = new FileOutputStream(new File("SaveTestNGResultToExcel.xls"));
			workbook.write(out);
			out.close();
			System.out.println("Successfully saved Selenium WebDriver TestNG result to Excel File!!!");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// close the browser
		driver.close();
		driver.quit();
	}
}
