package oopPrac;

public class Bus extends PublicTransportation {

    public Bus() {
        setMaxPassenger(30);
        setStatus("운행");
        setBaseFare(1000);
        setPassenger(0);

        System.out.println(getNumber() + "번 버스객체 만들어짐");
    }

    @Override
    void pickUp(int passenger) {
        if (!getStatus().equals("운행")) {
            System.out.println("현재 운행 중이 아닙니다.");
            return;
        }

        if (getPassenger() + passenger > getMaxPassenger()) {
            System.out.println("최대 승객 수를 초과했습니다.");
            return;
        }

        setPassenger(getPassenger() + passenger) ;

        System.out.println("탑승 승객 수 : " + passenger);
        System.out.println("잔여 승객 수 : " + (getMaxPassenger() - getPassenger()));
        System.out.println("요금 확인 : " + (getBaseFare() * passenger));
    }

    @Override
    void isDrive() {
        if (getStatus().equals("운행")) setStatus("차고지 행");
        else if (getStatus().equals("차고지 행")) setStatus("운행");
    }

    @Override
    public void power(boolean power) {
        setPower(!power);
    }

    @Override
    public void changeGas(int gas) {
        setGas(getGas() + gas);

        System.out.println("주유량 : " + getGas());

        if (getGas() < 10) {
            changeStatus("차고지 행");
            System.out.println("주유가 필요합니다.");
        }
    }

    @Override
    public void changeSpeed(int speed) {
        setSpeed(getSpeed() + speed);
    }

    @Override
    void changeStatus(String status) {
        setStatus(status);

        if (getStatus().equals("차고지 행")) {
            setPassenger(0);
        }

        StringBuilder sb = new StringBuilder();
        System.out.println("상태 : " + getStatus());
    }
}
