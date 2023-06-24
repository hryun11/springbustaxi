package org.example;

public class Bus implements Transportation {
    int maxCapacity;    // 최대 승객 수
    int passengerNum;
    int fare;   // 요금
    int busNum;
    int amountOfGas; // 주유량
    long speed;
    String status; // 상태(운행/차고지행)

    public Bus(int maxCapacity, int fare) {
        this.maxCapacity = maxCapacity;
        this.fare = fare;
        this.busNum = setBusNum();
        this.status = "운행";
    }

    public int setBusNum() {
        return 0;
    }

    //승객 탑승
    @Override
    public void onBoardPassenger() {
        if (!status.equals("운행")) {
            System.out.println("운행 상태가 아닙니다.");
            return;
        }
        if (passengerNum + 1 >= maxCapacity) {
            System.out.println("최대 승객 수 초과");
            return;
        }
        this.passengerNum = passengerNum+1;
        System.out.println("passengerNum = " + passengerNum);
    }

    //속도 변경
    @Override
    public void changeSpeed(int value) {
        if (amountOfGas < 10) {
            System.out.println("주유량을 확인해 주세요.");
            return;
        }
        this.speed = speed + value;
        System.out.println("speed = " + speed);;
    }

    //버스 상태 변경
    @Override
    public void changeStatus() {
        if (amountOfGas < 10) {
            System.out.println("주유가 필요합니다.");
            this.status = "차고지행";
            return;
        }
        this.status = "차고지행";
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public void setPassengerNum(int passengerNum) {
        this.passengerNum = passengerNum;
    }

    public void setFare(int fare) {
        this.fare = fare;
    }

    public void setBusNum(int busNum) {
        this.busNum = busNum;
    }

    public void setAmountOfGas(int amountOfGas) {
        this.amountOfGas = amountOfGas;
    }

    public void setSpeed(long speed) {
        this.speed = speed;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
