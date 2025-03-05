import java.io.*;
import java.util.ArrayList;

public class FinanceManager {
    private ArrayList<Transaction> transactions;
    public FinanceManager (ArrayList<Transaction> transactions){
        this.transactions = transactions;
    }

    public void addTransaction(Transaction transaction){
        this.transactions.add(transaction);
    }

    public void viewTransactions(){
        System.out.println(this.transactions);
    }

    public void calculateBalance(){
        double income = 0, expenses = 0, balance = 0;
        for (Transaction t : this.transactions){
            if (t.getType().equals("income")){
                balance += t.getAmount();
                income += t.getAmount();
            }else if(t.getType().equals("expense")) expenses += t.getAmount();
        }
        System.out.println("Total income = " + income);
        System.out.println("Total expenses = " + expenses);
        System.out.println("Balance = " + balance);
    }

    public void saveToFile(String filename) throws IOException {
        try{
            FileWriter writer = new FileWriter(filename);
            for(Transaction t: this.transactions){
                writer.write(t.toString()+"\n");
            }
            writer.close();
            System.out.println("File written");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    public static Transaction getTransaction(String input){
        String category, date, type;
        double amount;
        //Get date
        int endOfWord = input.indexOf(' ');
        date = input.substring(0, endOfWord);
        input = input.substring(endOfWord+3);   //Shorten the line
        //Get type
        endOfWord = input.indexOf(':');
        type = input.substring(0, endOfWord);
        input = input.substring(endOfWord+2);   //Shorten the line
        endOfWord = input.indexOf(' ');
        amount = Double.parseDouble(input.substring(0,endOfWord));
        input = input.substring(endOfWord+2);   //Shorten the line
        category = input.substring(input.indexOf('(')+1, input.indexOf(')'));
        return new Transaction(amount, category, date, type);
    }

    public void loadFromFile(String filename) throws FileNotFoundException {
        try{
            BufferedReader br = new BufferedReader(new FileReader("first.txt"));
            String line = br.readLine();
            while (line != null && !line.isEmpty()){
                this.addTransaction(getTransaction(line));
                line = br.readLine();
            }
            System.out.println("File loaded");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public String toString(){
        String ans = "";
        for (Transaction t: this.transactions){
            ans += t.toString() + "\n";
        }
        return ans;
    }

}