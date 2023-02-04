package oopPrac;

public abstract class PublicTransportation implements Car {
    private final int number;     // 번호 :: 고유값
    private static int count = 1;
    private int gas;    // 주유량
    private int speed;  // 속도
    private int passenger;
    private int maxPassenger;   // 최대 승객 수
    private int baseFare;   // 기본 요금

    private boolean power;

    private String status;  // 상태


    public PublicTransportation() {     // 기본값 세팅하는 기본 생성자
        number = count++;
        gas = 100;
        speed = 0;
    }


    public int getNumber() {
        return number;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getPassenger() {
        return passenger;
    }

    public void setPassenger(int passenger) {
        this.passenger = passenger;
    }

    public int getMaxPassenger() {
        return maxPassenger;
    }

    public int getBaseFare() {
        return baseFare;
    }

    public String getStatus() {
        return status;
    }

    public void setMaxPassenger(int maxPassenger) {
        this.maxPassenger = maxPassenger;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setBaseFare(int baseFare) {
        this.baseFare = baseFare;
    }

    public int getGas() {
        return gas;
    }

    public void setGas(int gas) {
        this.gas = gas;
    };

    public boolean isPower() {
        return power;
    }

    public void setPower(boolean power) {
        this.power = power;
    }

    abstract void pickUp(int passenger);

    abstract void isDrive();

    abstract void changeStatus(String status);
}
