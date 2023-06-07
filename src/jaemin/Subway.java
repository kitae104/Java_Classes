package jaemin;

public class Subway extends Ride {
    public Subway(int number) {
        super(number);
        setName("지하철");
        setCost(1500);
    }

    @Override
    public void take() {

    }

    @Override
    public void take(int cost) {

    }

    @Override
    public void showInfo() {
        System.out.println("지하철의 승객은 총" + getPassengerCount() + "명이고, 수입은 " + getIncome() + "원 입니다.");
    }


}
