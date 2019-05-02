package util;

import tree.*;

import java.io.File;
import java.util.Scanner;

public class DataManager {

    public Tree readCSVFile(String path) {
        System.out.println("Reading file....");

        int numberOfLines = 0;
        boolean isFirstLine = true;
        int attributeNumber = 0;
        try {
            File file = new File(path);
            Scanner fileScanner = new Scanner(file);
            String currentLine;
            while ( (currentLine = fileScanner.nextLine()).charAt(0) != ' ') {
                if (isFirstLine) {
                    attributeNumber = currentLine.split(",").length;
                    isFirstLine = false;
                }
                numberOfLines++;
            }
        } catch (Exception e) {

            System.out.println("Done reading file.");
        }
//3
        String[][] data = new String[numberOfLines][attributeNumber];

        try {
            int i, j=0;
            File file = new File(path);
            Scanner fileScanner = new Scanner(file);
            String currentLine;
            while ( (fileScanner.hasNextLine())) {
                currentLine = fileScanner.nextLine();
                String[] curr = currentLine.split(",");
                for(i=0; i<attributeNumber; i++) {
                    data[j][i] = curr[i];
                }
                j++;
            }
        } catch (Exception e){
            e.printStackTrace();
        }

        return new Tree(new NonLeafNode(data, numberOfLines, attributeNumber));
    }

}
