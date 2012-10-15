import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;


public class CsvTest {

  public void readFile() {

    BufferedReader br = null;
    
    try {
      
      br = new BufferedReader(new FileReader("jal.csv"));
      String line = null;
      
      while ((line = br.readLine()) != null) {
        
        String[] values = line.split(",");
        
        //Do necessary work with the values, here we just print them out
        for (String str : values) {
          System.out.println(str);
        }
        System.out.println();
      }
    }
    catch (FileNotFoundException ex) {
      ex.printStackTrace();
    }
    catch (IOException ex) {
      ex.printStackTrace();
    }
    finally {
      try {
        if (br != null)
          br.close();
      }
      catch (IOException ex) {
        ex.printStackTrace();
      }
    }
  }

  public static void main(String[] args) {
    CsvTest test = new CsvTest();
    test.readFile();
  }
}