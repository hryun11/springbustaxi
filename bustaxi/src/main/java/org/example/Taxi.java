package org.example;

public class Taxi implements Transportation {
    int number;
    long amountOfGas;
    long speed;
    String destination;
    long defaultDistance;

    long distance;
    int defaultFare;
    int farePerDistance;
    String status;

    public Taxi(int number, long amountOfGas, long speed, String destination, long defaultDistance, long distance, int defaultFare, int farePerDistance, String status) {
        this.number = number;
        this.amountOfGas = amountOfGas;
        this.speed = speed;
        this.destination = destination;
        this.defaultDistance = defaultDistance;
        this.distance = distance;
        this.defaultFare = defaultFare;
        this.farePerDistance = farePerDistance;
        this.status = status;
    }


    //기본 거리 설정
    public void setDefaultDistance(long defaultDistance) {
        this.defaultDistance = defaultDistance;
    }

    //추가 요금 설정
    public void setFarePerDistance(int farePerDistance) {
        this.farePerDistance = farePerDistance;
    }

    public void setDistance(long distance) {
        this.distance = distance;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setAmountOfGas(long amountOfGas) {
        this.amountOfGas = amountOfGas;
    }

    //운행 시작
    public boolean checkAmountOfGas() {
        return amountOfGas >= 10;
    }

    //승객 탑승
    @Override
    public void onBoardPassenger() {
        if (!status.equals("일반")) {
            System.out.println("탑승 불가");
            return;
        }
        if (!checkAmountOfGas()) {
            System.out.println("주유량이 10 미만 입니다.");
            return;
        }
        this.status = "운행 중";
    }

    //속도 변경
    @Override
    public void changeSpeed(int value) {
        this.speed = speed+value;
    }


    //거리당 요금 추가
    public long addFarePerDistance() {
        return defaultFare+(distance-defaultDistance)*farePerDistance;
    }

    //요금 결제
    public void pay() {
        if (distance > defaultDistance) {
            System.out.println(addFarePerDistance());
            return;
        }
        System.out.println(defaultFare);
    }

    @Override
    public void changeStatus() {

    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setSpeed(long speed) {
        this.speed = speed;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setDefaultFare(int defaultFare) {
        this.defaultFare = defaultFare;
    }
}
