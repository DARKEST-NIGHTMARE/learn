public class Car extends Vehicle0{
    private int numseats;
    public Car(String m1, String m2, int y, String ft, double fe,int numseat) {
        super(m1, m2, y, ft, fe);
        this.numseats= numseat;
    }
    public int getnumseats()
    {
        return numseats;
    }


    @Override
    public double calcFuelEfficiency() {
        return getFuel_efficiency()*(1.0/(1.0+(getnumseats()/5.0)));
    }

    @Override
    public double calcDistanceTravelled() {
        return calcFuelEfficiency()*getFuel_efficiency();
    }

    @Override
    public double getMaxSpeed() {
        return 120.0;
    }


}
