package org.example;

public class Main {
    public static void main(String[] args) {
        Bus bus = new Bus(10, 1400);
        Taxi taxi = new Taxi(2023, 10, 50, "동성로", 2, 4, 3000, 200, "일반");

        System.out.println("bus number = " + bus.busNum);
        System.out.println("bus status = " + bus.status);
        System.out.println("taxi number = "+taxi.number);
        System.out.println("기본 거리 = "+taxi.defaultDistance);
        System.out.println("거리 = "+taxi.distance);
        System.out.println("거리 당 추가 요금 = " + taxi.farePerDistance);
        System.out.println("taxi status =  "+ taxi.status);
        System.out.println("택시 주유량 =  "+ taxi.amountOfGas);
        taxi.onBoardPassenger();
        System.out.println("택시 상태 = "+ taxi.status);
        taxi.onBoardPassenger();
        taxi.setAmountOfGas(9);
        taxi.setStatus("일반");
        taxi.onBoardPassenger();

        System.out.println("============= 요금 결제 =========");
        taxi.pay();
    }
}