package com.CompanyMaster;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CompanyMaster extends TestBase {
	public static String CoMaster(String CompanyName,String CompanyRegNo, String InvoiceNoType, String TaxInvoicePrefix, String MobileNo, 
	String Email, String Address1, String Address2, String Address3,String Pincode, String City, String State,String RegDateYear, 
	String RegDateMonth, String RegDateDay, String RenewalDateYear, String RenewalDateMonth, String RenewalDateDay, String BankName,
	String BranchName, String BankAcNo, String IFSC, String AccountType)throws InterruptedException, IOException {
		
//------ insert Data to Company Master Form -----//
		
			WebElement NameofCompany = driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_ucCompanyMaster1_txtCompanyName']"));
			NameofCompany.sendKeys(CompanyName);
			System.out.println("company name is : " + CompanyName);
		
		Thread.sleep(2000);
			WebElement RegNoTxtBox = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ucCompanyMaster1_txtRegistrationNo"));
			RegNoTxtBox.click();
		Thread.sleep(3000);
			WebElement RegNo = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ucCompanyMaster1_txtRegistrationNo"));
			RegNo.sendKeys(CompanyRegNo);
			System.out.println("company Rergistration Number : " + CompanyRegNo);
			
	Thread.sleep(2000); 
		Select s1 = new Select(driver.findElement(By.id("ctl00_ContentPlaceHolder1_ucCompanyMaster1_ddlInvoiceNoType")));
		s1.selectByVisibleText(InvoiceNoType);
		System.out.println("Invoice no is : " + InvoiceNoType);
	
	Thread.sleep(1000);
		WebElement TaxInvoice = driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_ucCompanyMaster1_txtInvoicePrefix']"));
		TaxInvoice.sendKeys(TaxInvoicePrefix);
		System.out.println("Tax Invoice Prefix is : " + TaxInvoicePrefix);
		
	Thread.sleep(1000);
		WebElement MobNo = driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_ucCompanyMaster1_txtMobileNo']"));
		MobNo.sendKeys(MobileNo);
		System.out.println("Mobile Number is : " + MobileNo);
		
	Thread.sleep(1000);
		WebElement EmailID = driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_ucCompanyMaster1_txtEmailId']"));
		EmailID.sendKeys(Email);
		System.out.println("Email ID is : " + Email);
	
	Thread.sleep(1000);
		WebElement Addr1 = driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_ucCompanyMaster1_txtAddress']"));
		Addr1.sendKeys(Address1);
		System.out.println("Address1 is : " + Address1);

	Thread.sleep(1000);
		WebElement Addr2 = driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_ucCompanyMaster1_txtAddress2']"));
		Addr2.sendKeys(Address2);
		System.out.println("Address2 is : " + Address2);
	
	Thread.sleep(1000);
		WebElement Addr3 = driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_ucCompanyMaster1_txtAddress3']"));
		Addr3.sendKeys(Address3);
		System.out.println("Address3 is : " + Address3);
	
	Thread.sleep(1000);
		WebElement PinCode = driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_ucCompanyMaster1_txtPinCode']"));
		PinCode.sendKeys(Pincode);
		System.out.println("Pincode : " + Pincode);
	
	Thread.sleep(1000);
		Select s2 = new Select(driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_ucCompanyMaster1_ddlCity']")));
		s2.selectByVisibleText(City);
		System.out.println("City is : " + City);
	
	Thread.sleep(1000);
		Select s3 = new Select(driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_ucCompanyMaster1_ddlState']")));
		s3.selectByVisibleText(State);
		System.out.println("State is : " + State);
	
//---- Select Reg. Date - DD-MM-YYYY ----//	
			Thread.sleep(1000);
				driver.findElement(By.id("ctl00_ContentPlaceHolder1_ucCompanyMaster1_txtRegistrationDate")).click();
				try{	
//---- Select Year ----//
			Thread.sleep(1000);
				Select s4 = new Select(driver.findElement(By.cssSelector("#ui-datepicker-div > div > div > select.ui-datepicker-year")));
				s4.selectByVisibleText(RegDateYear);
//---- Select Month ----//
				Select s5 = new Select(driver.findElement(By.cssSelector("#ui-datepicker-div > div > div > select.ui-datepicker-month")));
				s5.selectByVisibleText(RegDateMonth);
//---- Select Day ----//	
			Thread.sleep(1000);
				List <WebElement> Days = driver.findElements(By.xpath("//*[@id='ui-datepicker-div']/table/tbody/tr/td/a"));
					for(WebElement d:Days){
						d.getText();
					if(d.getText().equals(RegDateDay)){
						d.click();
						}
						}
					} catch (Exception e){
						System.out.println(e);
					}
					System.out.println("Reg.Date is : " + RegDateDay + "/" + RegDateMonth + "/" + RegDateYear );
					
				
//---- Select Renewal. Date - DD-MM-YYYY ----//	
			Thread.sleep(1000);
				driver.findElement(By.id("ctl00_ContentPlaceHolder1_ucCompanyMaster1_txtRenewalDate")).click();
				try{	
//---- Select Year ----//
			Thread.sleep(1000);
				Select s6 = new Select(driver.findElement(By.cssSelector("#ui-datepicker-div > div > div > select.ui-datepicker-year")));
				s6.selectByVisibleText(RenewalDateYear);
//---- Select Month ----//
				Select s7 = new Select(driver.findElement(By.cssSelector("#ui-datepicker-div > div > div > select.ui-datepicker-month")));
				s7.selectByVisibleText(RenewalDateMonth);
//---- Select Day ----//	
			Thread.sleep(1000);
				List <WebElement> Days = driver.findElements(By.xpath("//*[@id='ui-datepicker-div']/table/tbody/tr/td/a"));
					for(WebElement d:Days){
						d.getText();
					if(d.getText().equals(RenewalDateDay)){
						d.click();
						}
						}
					} catch (Exception e){
						System.out.println(e);
					}
				System.out.println("Renewal. Date is : " + RenewalDateDay  + "/" + RenewalDateMonth + "/" + RenewalDateYear );
				
		Thread.sleep(1000);
			WebElement  Bank = driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_ucCompanyMaster1_txtBankName']"));
			Bank.sendKeys(BankName);
			System.out.println("Bank Name is : " + BankName);
			
		Thread.sleep(1000);
			WebElement  Branch = driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_ucCompanyMaster1_txtBranchName']"));
			Branch.sendKeys(BranchName);
			System.out.println("Branch Name is : " + BranchName);
			
		Thread.sleep(1000);
			WebElement  AccountNo = driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_ucCompanyMaster1_txtBankAcNo']"));
			AccountNo.sendKeys(BankAcNo);
			System.out.println("Account Number is : " + BankAcNo);
		
		Thread.sleep(1000);
			WebElement  ifsc = driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_ucCompanyMaster1_txtIFSC']"));
			ifsc.sendKeys(IFSC);
			System.out.println("IFSC Code is : " + IFSC);
			
		Thread.sleep(2000);
			Select s8 = new Select(driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_ucCompanyMaster1_ddlAccountType']")));
			s8.selectByVisibleText(AccountType);
			System.out.println("Account Type is : " + AccountType);
		
		Thread.sleep(1000);	
			WebElement  AddButton = driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_ucCompanyMaster1_btnAddBankInfo']"));
			AddButton.click();
			
		Thread.sleep(5000);	
			WebElement  SubmitButton = driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_ucCompanyMaster1_btnsubmit']"));
			SubmitButton.click();
			
	return null;
	}
	
}
