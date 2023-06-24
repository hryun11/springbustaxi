package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("======== 버스 =========");
        Bus bus = new Bus(10, 1400);
        System.out.println("버스 번호 = " + bus.busNum);
        System.out.println("운행 상태 = " + bus.status);
        System.out.println("===== 승객 탑승 ======");
        bus.onBoardPassenger();

        System.out.println("===== 승객 탑승 =====");
        bus.setStatus("차고지행");
        System.out.println("bus.status = " + bus.status);
        bus.onBoardPassenger();

        System.out.println("======== 승객 탑승 ========");
        bus.setStatus("운행");
        System.out.println("bus.status = " + bus.status);;
        bus.setPassengerNum(10);
        System.out.println("bus.passengerNum = " + bus.passengerNum);
        bus.onBoardPassenger();
        System.out.println("bus.passengerNum = " + bus.passengerNum);

        System.out.println("======== 속도 변경 =========");;
        bus.setAmountOfGas(11);
        System.out.println("bus.amountOfGas = " + bus.amountOfGas);
        bus.changeSpeed(5);
        System.out.println("======= 속도 변경 ========");
        bus.setAmountOfGas(5);
        System.out.println("bus.amountOfGas = " + bus.amountOfGas);
        bus.changeSpeed(5);

        System.out.println(" ");
        System.out.println("============ 택시 ===========");
        Taxi taxi = new Taxi(2023, 10, 50, "목적지", 2, 4, 3000, 200, "일반");

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