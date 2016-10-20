/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.peram_inclassexam;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * WritePDFFile Class.
 * @author S525754
 */
public class WritePDFFile {
    
    
    public void createPDF(AccountDetails account) throws DocumentException, FileNotFoundException, BadElementException, IOException {
        
        Document document = new Document(PageSize.A4, 50, 50, 50, 50);
        
        PdfWriter write = PdfWriter.getInstance(document, new FileOutputStream(account.getLastName() + "_output.pdf"));
        
        document.open();
        
        Image image = Image.getInstance("image.png");
        
        image.scaleToFit(450f, 1500f);
        
        document.add(image);
        
        Paragraph welcomeParagraph = new Paragraph("Welcome! " + account.getFirstName() + " " + account.getLastName() + "!" );
        welcomeParagraph.setSpacingBefore(80);
        
        document.add(welcomeParagraph);
        
        String firstName = "First Name: " + account.getFirstName();
        String lastName = "Last Name: " + account.getLastName();
        String acctNumber = "Account Number: " + account.getAccountNo();
        String acctBalance = String.format("Account Balance: $%.1f", account.getAccountBalance());
        
        Paragraph detailsPara = new Paragraph("Below are your Account Details:\n" + firstName + "\n" + lastName + "\n" + acctNumber + "\n" + acctBalance );
        detailsPara.setIndentationLeft(50);
        detailsPara.setSpacingBefore(20);
        document.add(detailsPara);
        
        document.close();
        write.close();
    }

}
