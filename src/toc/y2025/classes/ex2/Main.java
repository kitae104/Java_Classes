package toc.y2025.classes.ex2;

public class Main {
    public static void main(String[] args) {
        BankAccount acc = new BankAccount("김철수", 10000);
        acc.deposit(5000);
        acc.withdraw(3000);
        acc.printBalance();
    }
}
