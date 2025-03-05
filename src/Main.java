import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to your Personal Finance Manager!");
        System.out.println("Press Enter to start...");
        scanner.nextLine();
        FinanceManager financeManager = new FinanceManager();
        int userInput;
        while (true){
            System.out.println("Please choose an action:");
            System.out.println("-1- Add a transaction");
            System.out.println("-2- View all transactions");
            System.out.println("-3- Calculate the balance");
            System.out.println("-4- Save transactions to a file");
            System.out.println("-5- Load transactions from a file");
            System.out.println("-6- Exit the program");
            userInput = Integer.parseInt(scanner.nextLine());
            double amountInput;
            String categoryInput, dateInput, typeInput, fileNameInput;
            switch (userInput){
                case 1:{
                    System.out.println("Enter amount:");
                    amountInput = Double.parseDouble(scanner.nextLine());
                    System.out.println("Enter category:");
                    categoryInput = scanner.nextLine();
                    System.out.println("Enter date(DD-MM-YYYY):");
                    dateInput = scanner.nextLine();
                    System.out.println("Enter type(income/expense):");
                    typeInput = scanner.nextLine();
                    try {
                        financeManager.addTransaction(new Transaction(amountInput, categoryInput, dateInput, typeInput));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    System.out.println("Transaction added successfully!");
                    break;
                }
                case 2:{
                    System.out.println(financeManager);
                    break;
                }
                case 3:{
                    financeManager.calculateBalance();
                    break;
                }
                case 4:{
                    System.out.println("Set file name(Please include file type):");
                    fileNameInput = scanner.nextLine();
                    try {
                        financeManager.saveToFile(fileNameInput);
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                case 5:{
                    System.out.println("Enter file name(Please include file type):");
                    fileNameInput = scanner.nextLine();
                    try {
                        financeManager.loadFromFile(fileNameInput);
                    } catch (FileNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                case 6:{
                    break;
                }
                default: {
                    System.out.println("Invalid choice - Please try again!");
                    break;
                }
            }
            if (userInput == 6) {
                System.out.println("Quitting program...");
                break;
            }
        }

    }
}