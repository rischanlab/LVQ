

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScannerTokenDemo {
    public static void main(String[] args) {
        //
        // This file contains some data as follow:
        // a, b, c, d
        // e, f, g, h
        // i, j, k, l
        //
        File file = new File("jal.csv");
        try {
            //
            // Here we use the Scanner class to read file content line-by-line.
            //
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                
                //
                // From the above line of code we got a line from the file
                // content. Now we want to split the line with comma as the 
                // charater delimiter.
                //
                Scanner lineScanner = new Scanner(line);
                lineScanner.useDelimiter(",");
                while (lineScanner.hasNext()) {
                    //
                    // Get each splited data from the Scanner object and print
                    // the value.
                    //
                    String part = lineScanner.next();
                    System.out.print(part + ", ");
                }                
                System.out.println();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}