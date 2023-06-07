package jaemin;

public abstract class Ride {
    private String name;
    private int number;
    private int cost;
    private int income;
    private int passengerCount;


    public Ride(int number) {
        this.name = null;
        this.number = number;
        this.cost = 0;
        this.income = 0;
        this.passengerCount = 0;
    }

    public abstract void take();
    public abstract void take(int cost);
    public abstract void showInfo();

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public int getCost() {
        return cost;
    }

    public int getIncome() {
        return income;
    }

    public int getPassengerCount() {
        return passengerCount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setIncome(int income) {
        this.income = income;
    }

    public void setPassengerCount(int passengerCount) {
        this.passengerCount = passengerCount;
    }
}
