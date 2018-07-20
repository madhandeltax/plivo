package com.plivo.configuration;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.plivo.dataProvider.TestDataProviderSource;

//Reading test data from csv file

public class ReadTestData {
	
	public HashMap<String, String> testDataMap = new HashMap<String, String>();
	
   	public void  populateDataSource(String filepath) {

        FileInputStream inputStream;
        
		try {
			inputStream = new FileInputStream(new File(filepath));
		
         
        Workbook workbook = new XSSFWorkbook(inputStream);
       // Sheet firstSheet = workbook.getSheetAt(0);
        
        int noOfSheets = workbook.getNumberOfSheets();
        
        for(int j=0;j<noOfSheets;j++) {    
        		        		   
        		switch (workbook.getSheetName(j)) 
        		{        		
        			case ("Launch"):
        				TestDataProviderSource.launchTestData = readSheet(workbook.getSheet("Launch"));                	
        				break; 
        				
                case ("Login"):
                		TestDataProviderSource.loginTestData = readSheet(workbook.getSheet("Login"));                	
                		break;     
                	
                case ("Cart"):
            			TestDataProviderSource.cartTestData = readSheet(workbook.getSheet("Cart"));                	
            			break;             		            
        		}        
        }
         
        		workbook.close();
        		inputStream.close();
        
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    
   	}
   	
   	public static Object[][] readSheet(Sheet sheet) {
   		
   		Object[][] testData = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
   		int i=0, x=0, y=0;
   		
        Iterator<Row> iterator = sheet.iterator();
        
        while (iterator.hasNext()) {
            Row nextRow = iterator.next();
            Iterator<Cell> cellIterator = nextRow.cellIterator();
            
            if(i==0) {
        			i++;
        			continue;
            }
             
            while (cellIterator.hasNext()) {
            	
                Cell cell = cellIterator.next();   
                cell.setCellType(Cell.CELL_TYPE_STRING);
                testData[x][y] = cell.toString();                            
                y++;
            }
            y=0;
            x++;
        }
        x=0;
        return testData;
   	}
		

}