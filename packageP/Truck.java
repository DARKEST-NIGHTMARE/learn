public class Truck extends Vehicle0{
    private double cargoCapacity;
    public Truck(String mm0,String mm1,int yy,String fftt,double ffee,double cc)
    {
        super(mm0,mm1,yy,fftt,ffee);
        this.cargoCapacity= cc;

    }
    public double getCargoCapacity(){
        return cargoCapacity;
    }
    @Override
    public double calcFuelEfficiency()
    {
        return getFuel_efficiency()* (1.0/(1.0+(getCargoCapacity()/1000.0)));
    }
    @Override
    public double calcDistanceTravelled(){
        return calcFuelEfficiency()*getFuel_efficiency();
    }
    @Override
    public double getMaxSpeed()
    {
        return 80.0;
    }
}
