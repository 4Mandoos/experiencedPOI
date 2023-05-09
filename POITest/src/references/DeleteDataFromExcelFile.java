package references;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/*
 * 특정 셀 삭제 불가능 
 * 특정 행의 모든 데이터 삭제 가능
 */
public class DeleteDataFromExcelFile {
	public static void main(String[] args) {
		try {
			FileInputStream file = new FileInputStream(new File("./src/", "excel.xlsx"));

			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheetAt(0);
			Cell cell = null;

//			// Retrieve the row and check for null
			XSSFRow sheetrow = sheet.getRow(3);
//			if (sheetrow != null) {
//				sheet.removeRow(sheetrow);
//			}
			// Update the value of cell
			cell = sheetrow.getCell(3);
			if (cell != null) {
				sheetrow.removeCell(cell);
			}
//			cell.setCellValue("Pass");

			file.close();

			FileOutputStream outFile = new FileOutputStream(new File("./src/", "excel.xlsx"));
			workbook.write(outFile);
			outFile.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
