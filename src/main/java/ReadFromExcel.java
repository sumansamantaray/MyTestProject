import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * 
 */

/**
 * @author samasu5
 *
 */
public class ReadFromExcel {

	public static Sheet datatypeSheet;
	static {
		try {
			FileInputStream excelFile = new FileInputStream(new File("./src/main/resources/jeop.xlsx"));
            Workbook workbook = new XSSFWorkbook(excelFile);
            datatypeSheet = workbook.getSheetAt(0);
            workbook.close();
		} catch (Exception exp) {
			exp.printStackTrace();
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		new ReadFromExcel().getJeopardyDesc("1T");
	}


	
	
	public String getJeopardyDesc(String jeopardyId) {
		
		Iterator<Row> iterator = ReadFromExcel.datatypeSheet.iterator();
		String jeopardyDesc = "";
        while (iterator.hasNext()) {
        	
        	/*if ("".equals(jeopardyDesc)) {
        		
        	} */
        	Row currentRow = iterator.next();
            Iterator<Cell> cellIterator = currentRow.iterator();

            while (cellIterator.hasNext()) {

                Cell currentCell = cellIterator.next();
                
                if (currentCell.getStringCellValue() != null && jeopardyId.equalsIgnoreCase(currentCell.getStringCellValue())) {
                	cellIterator.next();
                	jeopardyDesc = cellIterator.next().getStringCellValue();
                	System.out.print(jeopardyDesc);
                	return jeopardyDesc;
                }
            }
        }
		
		return jeopardyDesc;
	}


}
