public abstract class Vehicle0 {

    private String make;
private String model;
private int year;
private String fuel_type;
private double fuel_efficiency;
public Vehicle0(String m1,String m2,int y,String ft,double fe)
{
    this.make=m1;
    this.model=m2;
    this.year=y;
    this.fuel_type=ft;
    this.fuel_efficiency=fe;

}
public String getMake()
{
    return make;
}
public String getModel()
{
    return model;
}
public int getYear()
{
    return year;
}
public String getFuel_type()
{
    return fuel_type;
}
public double getFuel_efficiency()
{
    return fuel_efficiency;
}
public abstract double calcFuelEfficiency();
public abstract double calcDistanceTravelled();
public abstract double  getMaxSpeed();
}