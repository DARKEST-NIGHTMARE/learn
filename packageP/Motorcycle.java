public class Motorcycle extends Vehicle0{
    private double engineDisplacement;

    public Motorcycle(String m1, String m2, int y, String ft, double fe,double engineDisplacement){
        super(m1, m2, y, ft, fe);
        this.engineDisplacement=engineDisplacement;
    }
public double getEngineDisplacement(){
        return engineDisplacement;
}
    @Override
    public double calcFuelEfficiency() {
        return getFuel_efficiency()*(1.0/(1.0+(getFuel_efficiency()/1000.0)));
    }

    @Override
    public double calcDistanceTravelled() {
        return calcFuelEfficiency()*getFuel_efficiency();
    }

    @Override
    public double getMaxSpeed() {
        return 80.0;
    }
}
