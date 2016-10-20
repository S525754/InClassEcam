/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.peram_inclassexam;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.DocumentException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author S525754
 */
public class Driver {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     * @throws com.itextpdf.text.DocumentException
     * @throws com.itextpdf.text.BadElementException
     */
    public static void main(String[] args) throws FileNotFoundException, DocumentException, BadElementException, IOException {
        ReadExcelFile read = new ReadExcelFile();
        List<AccountDetails> account = read.getAccountListFromExcel();
        
        WritePDFFile write = new WritePDFFile();
        for (AccountDetails accounts: account) {
            write.createPDF(accounts);
        }
        
    }
    
}
