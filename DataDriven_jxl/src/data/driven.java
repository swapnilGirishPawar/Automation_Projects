package data;
import java.io.File;
import java.io.IOException;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class driven {

	public static void main(String[] args) throws IOException, RowsExceededException, WriteException {
		// TODO Auto-generated method stub
		
		// I am importing excel file into workspace.
		File excel = new  File("C:\\Users\\user\\Desktop\\testingFile.xls");
		
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
		
		Label data3 = new Label(0,6, "sixth row");
		writeSheet.addCell(data3);
		
		writebook.write();
		writebook.close();
		
	}

}
