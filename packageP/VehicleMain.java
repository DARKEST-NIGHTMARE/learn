public class VehicleMain {
    public static void main(String[] args) {
        Truck T = new Truck("ashok","leyland",2010,"Diesel",11.26,5.7);
        Car C = new Car("kia","carens",2018,"petrol",25.45,7);
        Motorcycle M= new Motorcycle("bajaj","pulsar",2101,"petrol",50.34,250.43);
        System.out.println(T.getModel());
        System.out.println(T.calcFuelEfficiency()+"milleage");
        System.out.println(T.calcDistanceTravelled()+"distance");
        System.out.println(T.getMaxSpeed()+"kph");
        System.out.println(T.getCargoCapacity()+"cargo");


        System.out.println();
        System.out.println(C.getModel());
        System.out.println(C.calcFuelEfficiency()+"mileage");
        System.out.println(C.calcDistanceTravelled()+"distance");
        System.out.println(C.getMaxSpeed()+"kph");
        System.out.println(C.getnumseats()+"seats");
        System.out.println();

        System.out.println(M.getModel());
        System.out.println(M.calcFuelEfficiency()+"mileage");
        System.out.println(M.calcDistanceTravelled()+"distance");
        System.out.println(M.getMaxSpeed()+"kph");
        System.out.println(M.getEngineDisplacement()+"cc");
    }
}
