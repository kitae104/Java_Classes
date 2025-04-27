package toc.y2025.mid.b.test1;

public class Loan {
    private String borrower;      // 대출자 이름
    private double principal;     // 원금
    private int months;           // 기간 (개월 수)
    private double annualRate;    // 연이율

    public Loan(String borrower, double principal, int months, double annualRate) {
        this.borrower = borrower;
        this.principal = principal;
        this.months = months;
        this.annualRate = annualRate;
    }

    public double getMonthlyPayment() {
        double monthlyRate = (annualRate / 100) / 12;
        double totalInterest = monthlyRate * principal * months;
        double totalPayment = principal + totalInterest;
        return totalPayment / months;
    }

    public void printLoanInfo() {
        System.out.printf("%s님 %.0f원에 대한 월 상환액: %.1f원\n",
                          borrower, principal, getMonthlyPayment());
    }

    
}
