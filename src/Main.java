import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Transaction t = new Transaction(50, "Family", "15/12/2024", "expense");
        FinanceManager financeManager = new FinanceManager(new ArrayList<Transaction>());
        financeManager.addTransaction(new Transaction(15, "Shopping", "03-05-2025", "expense"));
        financeManager.addTransaction(new Transaction(145, "Gas", "13-07-2021", "expense"));
        financeManager.addTransaction(new Transaction(55, "Gas", "10-12-2024", "expense"));
        financeManager.addTransaction(new Transaction(67, "Shopping", "23-03-2023", "expense"));
        /*try {
            financeManager.saveToFile("first.txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/

        try{
            BufferedReader br = new BufferedReader(new FileReader("first.txt"));
            String line = br.readLine();
            while (line != null){
                System.out.println(line);
                line = br.readLine();
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}