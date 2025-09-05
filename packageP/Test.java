//import java.awt.geom.Area;

import java.util.ArrayList;
import java.util.List;

////
////@FunctionalInterface
////interface Sum{
////    int sum(int a,int b);
////}
////public class Test {
////    public static void main(String[] args) {
////
////
////    Sum S = (x,y)-> x + y;
////    int result = S.sum(13,12);
////        System.out.println(result);
////}}
////
////
////
////
//import java.util.Arrays;
//import java.util.List;
//import java.util.stream.Collectors;
//public class Test{
//    public static void main(String[] args) {
//        List<Integer> num = Arrays.asList(12,3,5,13,10,11,8,4,9,4);
//        List<Integer> odd_n = num.stream().filter(number->number%2 != 0).collect(Collectors.toList());
//        System.out.println(odd_n);
//    }
//}

class Area1{
    Object a;
    Area1 (Object a){
        this.a = a;
    }
    public void  calcArea(Object b){

if (b instanceof Integer){
    System.out.println("Area is "+((int) b * (int) b));

    }
    if(b instanceof Double){
        System.out.println("Area is "+(double)b*(double)b );
    }

    }
}
public class Test{
    public static void main(String[] args) {
        Area1  iobj = new Area1(11);
        //String N = iobj.getGenericType();
        iobj.calcArea(11);
        Area1 iubj = new Area1(12.24);
        iubj.calcArea(12.24);
        List<Integer> list = new ArrayList<>();
        list.add(12);
//        list.add("ghsd");
//

    }


}