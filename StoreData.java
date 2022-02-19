import java.io.*;
import java.util.*;

// Class that conducts basic arithmetic functions.
public class StoreData 
{
    // Saves each expense to the text file for storage.
    public void saveExpenses(String fileName, String expense, double cost) 
              throws IOException 
              {
    // Checks if the specified filename exists. If not, it creates it.
    try (FileWriter BudgetOutput = new FileWriter(new File(fileName), true)) {
        // Adds each expense and dollar amount to the file.
        BudgetOutput.append("\n" + expense + ": $" + cost);
    // Notifies user if there are any errors
    } catch (Exception e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    } 
  }

    // Saves income and remainder to the text file for storage.
    public void SaveBalance(String fileName, String credit, double amount) 
              throws IOException 
              {
    // Checks if the specified filename exists. If not, it creates it.     
    try (FileWriter BudgetOutput = new FileWriter(new File(fileName), true)) {
        // Adds each item and dollar amount to the file.
        BudgetOutput.append("\n" + credit +" $" + amount);
    // Notifies user if there are any errors
    } catch (Exception e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    } 
  }

  // Reads contents of the monthlyexpenses.txt file and prints it to screen
  public void readFile(String fileName) {  
    // Opens the specified file and prints its contents to the screen.
    try {
      File Balance = new File(fileName);
      Scanner fileReader = new Scanner(Balance);  
      // Checks if there is a new line, and prints its contents to the screen.
      while (fileReader.hasNextLine()) {
        String data = fileReader.nextLine();
        System.out.println(data);
      // Closes the Scanner once done.
      }fileReader.close();
    // Notifies user if there are any errors
    } catch (Exception e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    } 
  }  
} 
