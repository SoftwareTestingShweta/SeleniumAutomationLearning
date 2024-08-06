package Selenium.dataDrivenTesting;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ProviderClass {

    @DataProvider(name ="loginData")
    public String[][] getData() throws IOException {

        File file = new File("src/test/resources/Book1practice.xlsx");
        FileInputStream fis = new FileInputStream(file);
        //    System.out.println(file.exists());

        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheet("Sheet1");

        int noOfRows = sheet.getPhysicalNumberOfRows();
        int noOfCell = sheet.getRow(0).getLastCellNum();
        System.out.println(noOfRows);
        System.out.println(noOfCell);

        String [][] data = new String[noOfRows-1][noOfCell];
        for (int i = 0; i < noOfRows-1; i++) {
            for (int j = 0; j < noOfCell; j++) {
                DataFormatter df = new DataFormatter();
                data[i][j] = df.formatCellValue(sheet.getRow(i+1).getCell(j));
            }
        }



        wb.close();
        fis.close();

        return data;

        //        for (int i = 1; i < noOfRows; i++) {
//            for (int j = 0; j < noOfCell ; j++) {
//                DataFormatter df = new DataFormatter();
//                System.out.println(df.formatCellValue(sheet.getRow(i).getCell(j)));
//              //  System.out.println(sheet.getRow(i).getCell(j).getStringCellValue());
//            }
//            System.out.println();
//        }

//        for (String[] dataAr : data){
//            System.out.println(Arrays.toString(dataAr));
//        }


    }

}
