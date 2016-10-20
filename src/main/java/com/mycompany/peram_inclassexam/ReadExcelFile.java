/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.peram_inclassexam;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author S525754
 */
public class ReadExcelFile {

    private static final String FILE_PATH = "Peram_input.xlsx";

    public List getAccountListFromExcel() throws FileNotFoundException {
        List accountList = new ArrayList();
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(FILE_PATH);
            Workbook workbook = new XSSFWorkbook(fis);

            int numberOfSheets = workbook.getNumberOfSheets();
            for (int i = 0; i < numberOfSheets; i++) {
                Sheet sheet = workbook.getSheetAt(i);

                for (int j = 1; j < sheet.getPhysicalNumberOfRows(); j++) {
                    AccountDetails account = new AccountDetails();
                    Row row = (Row) sheet.getRow(j);

                    Iterator cellIterator = row.cellIterator();
                    while (cellIterator.hasNext()) {

                        Cell cell = (Cell) cellIterator.next();

                        if (Cell.CELL_TYPE_STRING == cell.getCellType()) {

                            if (cell.getColumnIndex() == 1) {
                                account.setLastName(cell.getStringCellValue());
                            }

                            if (cell.getColumnIndex() == 2) {
                                account.setAccountNo(cell.getStringCellValue());
                            }

                            if (cell.getColumnIndex() == 0) {
                                account.setFirstName(cell.getStringCellValue());
                            }

                        } else if (Cell.CELL_TYPE_NUMERIC == cell.getCellType()) {

                            if (cell.getColumnIndex() == 3) {
                                account.setAccountBalance((int) cell.getNumericCellValue());
                            }
                        }

                    }

                    accountList.add(account);
                }

            }

            fis.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return accountList;
    }
}
