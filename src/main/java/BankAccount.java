public class BankAccount {

    private double balance;
    private String[] transactionHistory;
    private int transactionCount;
    private static final int MAX_HISTORY = 5;

    public BankAccount(double initialBalance){
        if(initialBalance < 0){
            throw new IllegalArgumentException("Начальный баланс не может быть отрицательным: " + initialBalance);
        }
        this.balance = initialBalance;
        this.transactionHistory = new String[MAX_HISTORY];
        addTransaction("Пополнение баланса на: " + initialBalance);
    }

    public boolean deposit(double amount){
        if(amount <= 0){
            throw new IllegalArgumentException("Сумма депозита должна быть положительной: " + amount);
        }
        this.balance += amount;
        addTransaction("Внесен депозит в размере: " + amount);
        return true;
    }

    public boolean withdraw(double amount){
        if(amount <= 0) {
            throw new IllegalArgumentException("Сумма должна быть положительной.");
        }
        if(amount > balance) {
            throw new IllegalArgumentException("Недостаточно средств. Баланс: " + balance);
        }
        this.balance -= amount;
        addTransaction("Вывод на: " + amount);
        return true;
    }

    public double getBalance(){
        return this.balance;
    }

    public String[] getTransactionHistory(){
        String[] copy = new String[transactionCount];
        for(int i = 0; i < transactionCount; i++){
            copy[i] = transactionHistory[i];
        }
        return copy;
    }

    private void addTransaction(String transaction){
        if(this.transactionCount < MAX_HISTORY){
            this.transactionHistory[transactionCount] = transaction;
            this.transactionCount++;
        }
        else{
            for(int i = 1; i < MAX_HISTORY ;i++){
                this.transactionHistory[i - 1] = this.transactionHistory[i];
            }
            this.transactionHistory[MAX_HISTORY - 1] = transaction;
        }
    }

    @Override
    public String toString(){
        return "BankAccount" + "{balance=" + this.balance + ", transactions=" + this.transactionCount + "}";
    }
}
