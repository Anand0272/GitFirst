package demo;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import java.io.FileInputStream;

import java.io.IOException;
import java.io.File;

public class ReadFromExcel {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileInputStream fis=new FileInputStream(new File("C:\\Users\\Pooja\\OneDrive\\Documents\\data.xlsx"));
		Workbook workbook=new XSSFWorkbook(fis);
		Sheet sheet=workbook.getSheetAt(0);
		for(Row row:sheet)
		{
			String agencyId=row.getCell(0).getStringCellValue();
			String userName=row.getCell(1).getStringCellValue();
			String fromDate=row.getCell(2).getStringCellValue();
			String toDate=row.getCell(3).getStringCellValue();
			System.out.println(agencyId);
			System.out.println(userName);
			System.out.println(fromDate);
			System.out.println(toDate);
		}

	}

}
