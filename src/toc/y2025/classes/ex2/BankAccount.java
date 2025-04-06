package toc.y2025.classes.ex2;

public class BankAccount {
    String owner;
    int balance;

    public BankAccount(String owner, int balance) {
        this.owner = owner;
        this.balance = balance;
    }

    public void deposit(int amount) {
        balance += amount;
        System.out.println(amount + "원 입금됨");
    }

    public void withdraw(int amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println(amount + "원 출금됨");
        } else {
            System.out.println("잔액 부족");
        }
    }

    public void printBalance() {
        System.out.println(owner + "님의 잔액: " + balance + "원");
    }
}
