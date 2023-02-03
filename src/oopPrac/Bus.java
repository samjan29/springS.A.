package oopPrac;

public class Bus extends PublicTransportation {

    public Bus(int number) {
        super(number);
        super.setMaxPassenger(30);
        super.setStatus("운행");
        super.setBaseFare(1000);
        super.setPassenger(0);

        System.out.println(number + "번 버스객체 만들어짐");
    }

    @Override
    void pickUp(int passenger) {
        if (!super.getStatus().equals("운행")) {
            System.out.println("현재 운행 중이 아닙니다.");
            return;
        }

        if (super.getPassenger() + passenger > super.getMaxPassenger()) {
            System.out.println("최대 승객 수를 초과했습니다.");
            return;
        }

        super.setPassenger(super.getPassenger() + passenger) ;

        System.out.println("탑승 승객 수 = " + passenger);
        System.out.println("잔여 승객 수 = " + (super.getMaxPassenger() - super.getPassenger()));
        System.out.println("요금 확인 = " + (super.getBaseFare() * passenger));
    }

    @Override
    void changeGas(int gas) {
        super.setGas(super.getGas() + gas);

        System.out.println("주유량 : " + super.getGas());

        if (super.getGas() < 10) {
            changeStatus("차고지행");
            System.out.println("주유가 필요합니다.");
        }
    }

    @Override
    void changeSpeed(int speed) {
        super.setSpeed(super.getSpeed() + speed);
    }

    @Override
    void changeStatus(String status) {
        super.setStatus(status);

        StringBuilder sb = new StringBuilder();
        System.out.println("상태 : " + super.getStatus());
    }
}
