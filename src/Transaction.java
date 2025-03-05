public class Transaction {
    private double amount;
    private String category;
    private String date;
    private String type;

    public Transaction(double amount, String category, String date, String type) throws Exception {
        if (amount <= 0){
            throw new Exception("ERROR: Amount must be grater than 0!");
        }else if(category.isEmpty()){
            throw new Exception("ERROR: Must mention category!");
        }else if (!date.matches(".*\\d.*")){
            throw new Exception("ERROR: Invalid date!");
        }else if (!type.toLowerCase().equals("income") && !type.toLowerCase().equals("expense")){
            throw new Exception("ERROR: type must be \"income\" or \"expense\"");
        }else{
            this.amount = amount;
            this.category = category;
            this.date = date;
            this.type = type;
        }
    }

    public double getAmount() {
        return this.amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString(){
        return this.date + " - " + this.type + ": " + this.amount + " (" + this.category + ")";
    }

}