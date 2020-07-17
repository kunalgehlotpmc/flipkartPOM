package flipkarttestpages;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;






public class Excel {
	public Excel() throws IOException
	{
	
	String filepath = "C:\\Users\\GehlotK\\eclipse-workspace\\flipkartproject\\src\\main\\java\\testdata\\Testdata.xlsx";
	FileInputStream fs = new FileInputStream (filepath);
	Workbook wb = new XSSFWorkbook(fs);
	Sheet sh = wb.getSheet("Sheet1");
	int rowcount = sh.getro
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
