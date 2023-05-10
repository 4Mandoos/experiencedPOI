package poi;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

public class CustomerExcelReader {
	public void reader() {
		
		System.out.println("\n--------------------------------------------------------------\n");

		try {
			// FileInputStream을 사용하여 파일을 읽어온다. filePath와 fileNm 변수를 사용하여 파일의 경로와 이름을 지정.
			FileInputStream file = new FileInputStream(MainApplication.FILE_AFTER_2007);

			// XSSFWorkbook을 사용하여 엑셀 파일의 내용을 읽어온다. file로부터 XSSFWorkbook 인스턴스를 생성.
			XSSFWorkbook workbook = new XSSFWorkbook(file);

			// workbook.getSheetAt(0)을 사용하여 첫 번째 시트를 가져온다. XSSFSheet 객체 => 시트를 나타냄
			XSSFSheet sheet = workbook.getSheetAt(0);

			// 만약 특정 이름의 시트를 찾는다면 workbook.getSheet("찾는 시트의 이름");
			// 만약 모든 시트를 순회하고 싶으면
			// for(Integer sheetNum : workbook.getNumberOfSheets()) {
			// XSSFSheet sheet = workbook.getSheetAt(i);
			// }
			// 아니면 Iterator<Sheet> s = workbook.iterator() 를 사용해서 조회해도 좋다.

			// 모든 행(row)들을 조회한다.
			Iterator<Row> rowIterator = sheet.iterator(); // sheet.iterator() => 시트의 행(row)들을 순회하는 Iterator를 가져온다.
			while (rowIterator.hasNext()) { // rowIterator.hasNext() => 다음 행이 있는지 확인
				Row row = rowIterator.next(); // rowIterator.next() => 다음 행을 가져온다.

				// 각각의 행에 존재하는 모든 열(cell)을 순회한다. => row와 동일한 방식
				Iterator<Cell> cellIterator = row.cellIterator();
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();

					switch (cell.getCellType()) { // cell.getCellType() => 셀의 타입을 확인
					case STRING: // 문자 셀인 경우 cell.getStringCellValue()를 사용하여 값을 가져온다.
						System.out.print(cell.getStringCellValue() + "\t");
						break;
					}
				}
				System.out.println();
			}
			file.close();
			System.out.println("\n--------------------------------------------------------------\n");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
