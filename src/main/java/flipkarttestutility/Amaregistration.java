package flipkarttestutility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Amaregistration {
	public static XSSFSheet sheet;
	public static XSSFWorkbook workbook;
	public static int i ;
	public static int k;
	public static String path = "C:\\Users\\GehlotK\\eclipse-workspace\\flipkartproject\\src\\main\\java\\testdata\\Testdata.xlsx";
	public static Object[][] getdata (String sheetname) throws IOException {
	File src = new File(path);
	FileInputStream file = new FileInputStream(src);
	workbook = new XSSFWorkbook(file);
	sheet = workbook.getSheet(sheetname);
	Object[][] data = new Object [sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
	for (i=0;i<sheet.getLastRowNum();i++)
	{
		for (k=0;k<sheet.getRow(0).getLastCellNum();k++)
		{
			data[i][k]=sheet.getRow(i+1).getCell(k).getStringCellValue();
		}
	}
	return data;
	

}
}
