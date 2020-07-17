package flipkarttestutility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Testdatautil {
	static XSSFWorkbook wb;
	static XSSFSheet sheet;
	
	public static String path = "C:\\Users\\GehlotK\\eclipse-workspace\\flipkartproject\\src\\main\\java\\testdata\\Testdata.xlsx";
	public static Object[][] getdata (String sheetname) throws Exception
	{
		File src = new File(path);
		FileInputStream fs = new FileInputStream(src);
		wb = new XSSFWorkbook(fs);
		sheet = wb.getSheet(sheetname);
		Object [][] data = new Object [sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for (int i=0;i<sheet.getLastRowNum();i++)
		{
			for (int k=0;k<sheet.getRow(0).getLastCellNum();k++)
			{
				data[i][k] = sheet.getRow(i+1).getCell(k).getStringCellValue();
				System.out.println(data[i][k]);
			}
		}
		return data;
		
	}

}
