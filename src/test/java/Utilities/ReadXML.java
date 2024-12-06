package Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadXML {

	public String read_excel_data(String sheetname, int row, int col) throws IOException {

		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"//TestData//MockSheet.xlsx");
		try (XSSFWorkbook wb = new XSSFWorkbook(file)) {
			XSSFSheet sheet = wb.getSheet(sheetname);
			String CellData = sheet.getRow(row).getCell(col).toString();
			return CellData;
		}	
	}
}
