package seleniumexamples;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReadDataInExcel {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Shruthi\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		Thread.sleep(500);
		
		
		String filePath = "C:\\Users\\EI13130\\Documents\\Works";
		String fileName = "Test.xlsx";
		String sheetName = "Sheet1";
		// Create an object of File class to open xlsx file

		File file = new File(filePath + "\\" + fileName);

		// Create an object of FileInputStream class to read excel file

		FileInputStream inputStream = new FileInputStream(file);

		Workbook workBook = null;

		// Find the file extension by splitting file name in substring and getting only
		// extension name

		String fileExtensionName = fileName.substring(fileName.indexOf("."));

		// Check condition if the file is xlsx file

		if (fileExtensionName.equals(".xlsx")) {

			// If it is xlsx file then create object of XSSFWorkbook class

			workBook = new XSSFWorkbook(inputStream);

		}
		// Check condition if the file is xls file

		else if (fileExtensionName.equals(".xls")) {

			// If it is xls file then create object of HSSFWorkbook class

			workBook = new XSSFWorkbook(inputStream);

		}
		// Read sheet inside the workbook by its name

		Sheet sheet = workBook.getSheet(sheetName);

		// Find number of rows in excel file

		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
		System.out.println("Row count " + rowCount);

		// Create a loop over all the rows of excel file to read it
		/*Row headerRow = sheet.getRow(0);
		Iterator<Cell> cellIterator = headerRow.cellIterator();
		while (cellIterator.hasNext()) {
			if(cellIterator.next().getStringCellValue() == "LName" ) {
				
			}
		}*/

		for (int i = 0; i < rowCount + 1; i++) {

			Row row = sheet.getRow(i);

			// Create a loop to print cell values in a row

			for (int j = 0; j < row.getLastCellNum(); j++) {

				// Print Excel data in console
				Cell c = row.getCell(j);
				if (c.getCellType() == CellType.STRING) {

					System.out.print(c.getStringCellValue() + " || ");
				}

				if (c.getCellType() == CellType.NUMERIC) {

					System.out.print(c.getNumericCellValue() + " || ");
				}

			}

			System.out.println();
		}
		Row row = sheet.getRow(1);
		
		String email = row.getCell(0).getStringCellValue();
		String password = row.getCell(1).getStringCellValue();
		
		System.out.println(email + " "  + password);
		driver.findElement(By.id("email")).sendKeys(email);
		driver.findElement(By.id("pass")).sendKeys(password);
		//driver.findElement(By.xpath("//button[@value='1']")).click(); 
		
		

	}
	
}
