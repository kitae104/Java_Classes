package jaemin;

public class Person {
    private String name;        // 이름
    private int money;          // 돈
    public Person(String name, int money) {
        this.name = name;
        this.money = money;
    }

    public void takeRide(Ride ride) {
        money = money - ride.getCost();
        System.out.println(name + "이 " + ride.getName() + "를 타고 " + ride.getCost() + "원을 지불해 " + money + "원이 남았습니다.");
        ride.setPassengerCount(ride.getPassengerCount() + 1);
        ride.setIncome(ride.getIncome() + ride.getCost());
    }


    public void takeRide(Taxi taxi, int i) {
        int cost = taxi.getCost() + (i * 200);
        money = money - cost;
        System.out.println(name + "이 택시를 타고 " + cost +"원을 지불해 " + money + "원이 남았습니다.");
        taxi.setPassengerCount(taxi.getPassengerCount() + 1);
        taxi.setIncome(taxi.getIncome() + cost);
    }
}
