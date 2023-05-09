package references;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class PrintExcelDataToConsole {
	public static void main(String[] args) {
		try {
			FileInputStream fin = new FileInputStream(new File("./src/", "excel.xlsx"));

			XSSFWorkbook workbook = new XSSFWorkbook(fin);

			XSSFSheet sheet = workbook.getSheetAt(0);
			Iterator<Row> rowIterator = sheet.iterator();
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				Iterator<Cell> cellIterator = row.cellIterator();
				while (cellIterator.hasNext()) {
					Cell cell = (Cell) cellIterator.next();

					switch (cell.getCellType()) {
					case NUMERIC:
						System.out.print((int) cell.getNumericCellValue() + "\t");
						break;

					case STRING:
						System.out.print(cell.getStringCellValue() + "\t\t");
						break;
					}
				}
				System.out.println();
			}
			fin.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
