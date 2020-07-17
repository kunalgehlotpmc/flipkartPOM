package flipkarttestutility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class facebookregistrationtestdata {
	public static XSSFWorkbook wb;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static String file = "C:\\Users\\GehlotK\\eclipse-workspace\\flipkartproject\\src\\main\\java\\testdata\\Testdata.xlsx";
	
	
	public static Object[][] getregistrationdata(String sheetname) throws IOException
	{
		File src = new File(file);
		FileInputStream fs = new FileInputStream(src);
		wb = new XSSFWorkbook(fs);
		sheet = wb.getSheet(sheetname);
		Object [][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for (int i=0;i<sheet.getLastRowNum();i++)
		{
			for (int k=0;k<sheet.getRow(0).getLastCellNum();k++)
			{
				
				row = sheet.getRow(i+1);
				cell=sheet.getRow(i+1).getCell(k);
				if (cell.getCellType()==CellType.STRING)
				{
				data[i][k]= sheet.getRow(i+1).getCell(k).getStringCellValue();
				System.out.println(data[i][k]);
			}
				else
				
				if (cell.getCellType()==CellType.NUMERIC)
				{
						data[i][k]= sheet.getRow(i+1).getCell(k).getNumericCellValue();
						System.out.println(data[i][k]);
					}
				
						
				
					
		}
		
	}
		return data;

}
}
