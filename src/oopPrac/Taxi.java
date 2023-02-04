package oopPrac;

public class Taxi extends PublicTransportation {
    private String distance;

    private int distanceToDestination;
    private int farePerDistance;
    private int baseDistance;
    private int totalPay;

    public Taxi() {
        setMaxPassenger(4);
        setStatus("일반");
        setBaseFare(3000);
        setPassenger(0);
        baseDistance = 5;
        this.farePerDistance = 1000;

        System.out.println(getNumber() + "번 택시객체 만들어짐");
    }

    void payBill() {
        if (getPassenger() == 0 || !getStatus().equals("운행 중")) {
            System.out.println("탑승객이 없습니다.");
        }

        System.out.println("기본 요금 : " + getBaseFare());

        int surcharge = Math.max(distanceToDestination - baseDistance, 0) * farePerDistance;

        System.out.println("거리 추가 요금 : " + surcharge);
        System.out.println("총 요금 : " + (getBaseFare() + surcharge));
        totalPay += getBaseFare() + surcharge;
        System.out.println("누적 요금 : " + totalPay);

        // 탑승객 내림
        setPassenger(0);
        setStatus("일반");
    }

    void contactDistance(String distance, int distanceToDestination, int passenger) {
        if (distance.equals("") || distanceToDestination == 0) {
            System.out.println("목적지가 제대로 설정되지 않았습니다.");
            return;
        }

        this.distance = distance;
        this.distanceToDestination = distanceToDestination;

        pickUp(passenger);
    }

    @Override
    void pickUp(int passenger) {
        if (!getStatus().equals("일반")) return;

        if (passenger > getMaxPassenger()) {
            System.out.println("탑승 가능 인원을 초과했습니다.");
            return;
        }

        isDrive();

        if (!getStatus().equals("운행 중")) {
            System.out.println("지금은 탑승할 수 없습니다.");
            return;
        }

        setPassenger(passenger);
        System.out.println("탑승 승객 수 : " + getPassenger());
    }

    @Override
    void isDrive() {
        if (getGas() >= 10) {
            setStatus("운행 중");
        }
    }

    @Override
    public void power(boolean power) {
        setPower(!power);
    }

    @Override
    public void changeGas(int gas) {
        if (getGas() + gas < 0) {
            setGas(0);
            changeStatus("운행불가");
            System.out.println("누적 요금 : " + totalPay);
            return;
        }

        setGas(getGas() + gas);
        System.out.println("주유량 : " + getGas());

        if (getGas() < 10) {
            changeStatus("운행불가");
            System.out.println("누적 요금 : " + totalPay);
        }
    }

    @Override
    public void changeSpeed(int speed) {
        setSpeed(getSpeed() + speed);
    }

    @Override
    void changeStatus(String status) {
        if (getGas() < 10) {
            setStatus("운행불가");
            System.out.println("상태 : " + getStatus());
            return;
        }

        setStatus(status);

        System.out.println("상태 : " + getStatus());
    }


    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public int getDistanceToDestination() {
        return distanceToDestination;
    }

    public void setDistanceToDestination(int distanceToDestination) {
        this.distanceToDestination = distanceToDestination;
    }

    public int getFarePerDistance() {
        return farePerDistance;
    }

    public void setFarePerDistance(int farePerDistance) {
        this.farePerDistance = farePerDistance;
    }

    public int getBaseDistance() {
        return baseDistance;
    }

    public void setBaseDistance(int baseDistance) {
        this.baseDistance = baseDistance;
    }
}
