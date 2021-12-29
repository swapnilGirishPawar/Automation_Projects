package datademo;

import java.io.File;
import java.io.IOException;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class demo {

	public static void main(String[] args) throws IOException, RowsExceededException, WriteException, BiffException {
		// TODO Auto-generated method stub
		
		// I am importing excel file into workspace.
		File excel = new  File("C:\\Users\\user\\Desktop\\new createdFile.xls");
		
		// creating the workbook in excel sheet.
		WritableWorkbook writebook = Workbook.createWorkbook(excel);
		
		// create a sheet in the workbook
		writebook.createSheet("Swapnil", 0);
		
		// write something into sheet
		WritableSheet writeSheet = writebook.getSheet(0); // sheet of zero is first sheet ie swapnil.
		Label data1 = new Label(0, 0, "Hello World"); 
		writeSheet.addCell(data1); // line to add data into cell
		
		// second data 
		Label data2 = new Label(0, 2, "Moolya ST");
		writeSheet.addCell(data2);
		
		Label data3 = new Label(0,6, "Row Number 7th...");
		writeSheet.addCell(data3);
		
		// Mandatory steps to follow
		writebook.write();
		writebook.close();
		
		
		Workbook wb = Workbook.getWorkbook(excel);
		int sheets = wb.getNumberOfSheets();
		Sheet sheet = null;
		for (int i=0;i<sheets;i++)
		{
			 sheet = wb.getSheet(i);
			 int rows = sheet.getRows();
			 int colomns = sheet.getColumns();
			 System.out.println("Rows = "+rows + "\ncolomns = "+colomns);
			 
			 
			 for (int n =0; n<rows; n++) 
				 for(int m =0; m<colomns; m++)
				 {
					 Cell cell = sheet.getCell(m,n);
					 
					 if (cell.getContents().length()>0)
					 {
						 System.out.println(cell.getContents());
					 }
				 }
		}
	}
}
