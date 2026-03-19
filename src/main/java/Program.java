public class Program{
    public static void main(String[] args){
        System.out.println("\n=== Тестирование банка ===");

        BankAccount person = new BankAccount(1000.0);
        System.out.println("Начальный баланс: " + person.getBalance());

        try{
            person.deposit(500.0);
        }
        catch(IllegalArgumentException er){
            System.out.println(er.getMessage());
        }

        System.out.println("После депозита: " + person.getBalance());

        try{
            person.withdraw(300.0);
        }
        catch(IllegalArgumentException er){
            System.out.println("Ошибка: " + er.getMessage());
        }

        System.out.println("После снятия: " + person.getBalance());

        try{
            person.withdraw(2000.0);
        }
        catch(IllegalArgumentException er){
            System.out.println("Ошибка: " + er.getMessage());
        }

        try{
            person.deposit(-100.0);
        }
        catch(IllegalArgumentException er){
            System.out.println("Ошибка: " + er.getMessage());
        }

        System.out.println("\n=== История операций ===");
        String[] transaction = person.getTransactionHistory();
        for(String i : transaction){
            System.out.println(i);
        }

    }
}