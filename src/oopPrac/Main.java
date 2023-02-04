package oopPrac;

public class Main {
    public static void main(String[] args) {
        // 버스
        PublicTransportation bus1 = new Bus();
        PublicTransportation bus2 = new Bus();

        System.out.println();

        bus1.pickUp(2);
        bus1.changeGas(-50);
        bus1.changeStatus("차고지행");
        bus1.changeGas(10);
        bus1.changeStatus("운행");
        bus1.pickUp(45);
        bus1.pickUp(5);
        bus1.changeGas(-55);

        System.out.println();

        // 택시
        Taxi taxi1 = new Taxi();
        PublicTransportation taxi2 = new Taxi();

        taxi1.contactDistance("서울역", 2, 2);
        taxi1.changeGas(-80);
        taxi1.payBill();

        System.out.println();

        // 탑승 인원 초과
        taxi1.contactDistance("구로디지털단지역", 12, 5);

        System.out.println();

        taxi1.contactDistance("구로디지털단지역", 12, 3);
        taxi1.payBill();

        System.out.println();

        taxi1.changeGas(-20);
    }
}
