import java.util.concurrent.LinkedTransferQueue;

public class car {
    public static void main(String[] args) {
        Aoobj car1 = new Aoobj("mustang","red");
        Aoobj car2 = new Aoobj("Corvette","blue");
        Aoobj [] cars = {car1,car2};
for (int i = 0; i < cars.length;i++)
cars[i].drive();


    }


}
