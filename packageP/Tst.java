import java.lang.Cloneable;
import java .io.*;
//interface Serializable {
//
//}


class Tst1 implements Serializable {
    public Tst1() {
        System.out.println("Test object created");
    }
}

class Tst2 implements Cloneable{
    double i;
    public Tst2(double i) {
        this.i=i;
        System.out.println("second test object created");
    }
    @Override
    protected Object clone() throws CloneNotSupportedException{
        return super.clone();

    }
}

public class Tst
{
    public static void main(String[] args) throws CloneNotSupportedException,IOException,ClassNotFoundException
    {
        Tst1 t = new Tst1();
        Tst2 t1= new Tst2(20.475);
        Tst2 t2 = (Tst2)t1.clone();
        System.out.println(t2.i);

        if (t instanceof Serializable)
            System.out.println("test is serializable");
        else
            System.out.println("test is not serializable");


        if (t1 instanceof Cloneable)
            System.out.println("test 2 is clonable");
        else
            System.out.println("test 2 is not serializable");
    }
}