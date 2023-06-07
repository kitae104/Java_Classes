package jaemin;

public class Bus extends Ride {
    private int number;            // 버스 번호


    public Bus(int number) {
        super(number);
        setName("버스");
        setCost(1000);
    }

    @Override
    public void take() {

    }

    @Override
    public void take(int cost) {

    }

    @Override
    public void showInfo() {
        System.out.println("버스의 승객은 총" + getPassengerCount() + "명이고, 수입은 " + getIncome() + "원 입니다.");
    }


}

