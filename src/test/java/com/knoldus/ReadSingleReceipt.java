package com.knoldus;
import java.io.File;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class ReadSingleReceipt {
    public static void main(String[] args) {
        Tesseract tesseract = new Tesseract();
        try {

            tesseract.setDatapath("/home/knoldus/Downloads/Tess4J-3.4.8-src/Tess4J/tessdata");

            // the path of your tess data folder
            // inside the extracted file
            String text
                    = tesseract.doOCR(new File("/home/knoldus/Downloads/WalmartSampleReceipts/walmartRecepit.jpg"));

            // path of your image file
            System.out.print(text);
            if(text.contains("ST#"));
            System.out.println("correct receipt");

            int index = text.indexOf("ST#");
            System.out.println(index);
            System.out.println(text.substring(index,index+9));
        } catch (TesseractException e) {
            e.printStackTrace();
        }
    }
}
