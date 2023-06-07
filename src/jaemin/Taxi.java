package jaemin;

public class Taxi extends Ride implements TaxiMeter {
    private int number;            // 택시 번호

    public Taxi(int number) {
        super(number);
        setName("택시");
        setCost(3000);
    }

    @Override
    public void take() {

    }

    @Override
    public void take(int cost) {

    }

    @Override
    public void showInfo() {
        System.out.println("택시의 승객은 총" + getPassengerCount() + "명이고, 수입은 " + getIncome() + "원 입니다.");
    }

    @Override
    public int meter(int distance) {
        return 0;
    }
}
