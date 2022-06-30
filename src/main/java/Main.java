/*

- 포함해야 할 정보
1. 최대 승객수
2. 현재 승객수
3. 요금
4. 버스 번호
5. 주유량
6. 현재 속도
7. 상태
    1.  운행, 차고지 행

- 기능
1. 운행
2. 버스 상태 변경
3. 승객 탑승
4. 속도 변경

요구사항

- 버스 번호
    - 버스 객체 생성시 번호는 고유값으로 생성되어야 합니다.
- 버스 상태 변경
    - 버스 객체 생성시 최초 상태는 **‘운행’** 상태가 되며
    - 주유량이 떨어지거나, 운행을 종료할 때 **‘차고지행’** 상태로 변경 합니다.
    - 10미만일 경우 ‘주유가 필요하다’는 메시지를 출력해 주세요
- 승객 탑승
    - 승객 탑승은 **‘최대 승객수’** 이하까지 가능하며 **‘운행 중’**인 상태의 버스만 가능합니다.
    - 탑승시 현재 승객수가 증가되어야 합니다.
- 속도 변경
    - 주유 상태를 체크하고 주유량이 10 이상이어야 운행할 수 있습니다.
        - 경고메시지
            - 주유량을 확인해 주세요.
            - print문으로 출력
    - 변경할 속도를 입력 받아 현재 속도에 추가 하거나 뺄 수 있어야 합니다.

*/

class Transit {
    // 필드 공통
    int maxPassenger = 15;  // 최대 승객수
    int currentPassenger;  // 현재 승객수

    int price;  // 요금

    int amountFuel = 15;  //  주유량
    int currentSpeed;  // 현재 속도

    int acceleration; // 가속
    String busStatus = "운행";  // 상태

    // 버스 필드

    int busNumber;  // 버스 번호

    // 택시 필드

    String taxiStatus = "일반";  // 상태

    String destination; // 목적지

    int distance; // 목적지까지 거리

    int extraPrice // 추가 요금금





    // 생성자
    Transit() {
        this.busNumber = (int) (Math.random() * 10000 + 1);
        System.out.println("버스번호:" + busNumber);
    }


    // 메소드

    boolean isLeftGas() {

        return amountFuel >= 10;
    }

    boolean isOnBoardable() {
        return maxPassenger >= currentPassenger;
    }

    boolean drive() {
        if (isLeftGas()) {
            System.out.println("기름이 " + amountFuel + "남았습니다. 운행 중입니다.");
            amountFuel -= 1;
            return true;
        }

        if (!isLeftGas()) {
            System.out.println("주유가 필요합니다.");
            busStatus = "차고지행";
            taxiStatus = "탑승 불가";
        }
        return true;
    }





    // 승객 탑승

    int onBoard(int passenger) {
        currentPassenger += passenger;
        while (isOnBoardable()) {
            if (busStatus.equals("운행")) {
                System.out.println("승객 " + passenger + "명이 탑승했습니다. " + "현재 승객의 수는 " + currentPassenger + "명입니다.");
            }
            break;
        }
        if (!isOnBoardable()) {
            System.out.println(currentPassenger - maxPassenger + "명이 초과. 탑승 불가!");
        }
        return currentPassenger;
        /* 변수: 운행중이냐, 승객 수가 적냐
        1. 운행중이고 승객 수가 45명 이하일 때 -> 운행
        2. 운행중이고 승객 수가 46명 초과일 때 -> 불가
        3. 운행중이 아니고 승객 수가 45명 이하일 때 -> 불가
        4. 운행중이 아니고 승객 수가 46명 이상일 때 -> 불가 */
    }

    /*

     - 속도 변경
         - 주유 상태를 체크하고 주유량이 10 이상이어야 운행할 수 있습니다.
         - 경고메시지
             - 주유량을 확인해 주세요.
             - print문으로 출력
         - 변경할 속도를 입력 받아 현재 속도에 추가 하거나 뺄 수 있어야 합니다.

    */

    int changeSpeed(int acceleration) {
        this.acceleration = acceleration;

        if (isLeftGas()) {
            currentSpeed += acceleration;
        }
        System.out.println("현재 속도는 " + currentSpeed + "입니다.");
        return currentSpeed;
    }

}


public class Main {
    public static void main(String[] args) {
        Transit bus = new Transit();

        System.out.println("");

        bus.onBoard(7);
        bus.drive();
        bus.changeSpeed(10);
        System.out.println("-----" + bus.busStatus + "-----");
        bus.changeSpeed(-10);

        bus.onBoard(3);
        bus.drive();
        bus.changeSpeed(20);
        bus.changeSpeed(-20);
        System.out.println("-----" + bus.busStatus + "-----");

        bus.onBoard(1);
        bus.drive();
        bus.changeSpeed(30);
        bus.changeSpeed(-30);
        System.out.println("-----" + bus.busStatus + "-----");

        bus.onBoard(1);
        bus.drive();
        bus.changeSpeed(40);
        bus.changeSpeed(-40);
        System.out.println("-----" + bus.busStatus + "-----");


        Transit taxi = new Transit();

        taxi.onBoard(7);
        taxi.drive();
        taxi.changeSpeed(10);
        System.out.println("-----" + taxi.taxiStatus + "-----");
        taxi.changeSpeed(-10);

        taxi.onBoard(3);
        taxi.drive();
        taxi.changeSpeed(20);
        taxi.changeSpeed(-20);
        System.out.println("-----" + taxi.taxiStatus + "-----");

        taxi.onBoard(1);
        taxi.drive();
        taxi.changeSpeed(30);
        taxi.changeSpeed(-30);
        System.out.println("-----" + taxi.taxiStatus + "-----");

        taxi.onBoard(1);
        taxi.drive();
        taxi.changeSpeed(40);
        taxi.changeSpeed(-40);
        System.out.println("-----" + taxi.taxiStatus + "-----");
    }
}