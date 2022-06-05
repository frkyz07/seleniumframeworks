import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDriven {

	// fileInputStream argument
	public ArrayList<String> getData(String testCaseName) throws IOException {
		
		ArrayList<String> array = new ArrayList();
		
		FileInputStream fis = new FileInputStream("C:\\Users\\frkyz\\OneDrive\\Belgeler\\demodata.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		
		int sheets = workbook.getNumberOfSheets();
		for(int i=0; i<sheets;i++)
		{
			if(workbook.getSheetName(i).equalsIgnoreCase("testdata")) 
			{
				XSSFSheet sheet = workbook.getSheetAt(i);// sheets collection of rows
				
				//Identy testcases column by scaning entire first row
				Iterator<Row> rows = sheet.iterator();
				Row firstrow = rows.next();
				Iterator<Cell> cel = firstrow.cellIterator(); // row is collection of cell
				int k =0;
				int column = 0;
				
				while(cel.hasNext()) 
				{
					Cell value = cel.next();
					if(value.getStringCellValue().equalsIgnoreCase("TestCases"))
					{
						column=k;
					}
					k++;
				}
				System.out.println(column);
				
				// once column is idenifed then scan entire test case column to idenify purchase testcase
				while(rows.hasNext()) 
				{
					Row r = rows.next();
					if(r.getCell(column).getStringCellValue().equalsIgnoreCase(testCaseName)) 
					{
						// after you grab purchase testcase row = pull all the data of that row and feed into text
						Iterator<Cell> cv = r.cellIterator();
						while(cv.hasNext())
						{
							Cell c = cv.next();
							if(c.getCellType()==CellType.STRING)
							{
								array.add(c.getStringCellValue());
							}
							else
							{
								array.add(NumberToTextConverter.toText(c.getNumericCellValue()));
							}
							
						
						}
						
					}
				}
			}
		
	} 	return array;
		
}
}


