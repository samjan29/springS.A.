package oopPrac;

public class BusTest {
    public static void main(String[] args) {
        Bus bus1 = new Bus(1);
        Bus bus2 = new Bus(2);

        bus1.pickUp(2);
        bus1.changeGas(-50);
        bus1.changeStatus("차고지행");
        bus1.changeGas(10);
        bus1.changeStatus("운행");
        bus1.pickUp(45);
        bus1.pickUp(5);
        bus1.changeGas(-55);
    }
}
