public class Overlord {




        public int add(int a, int b) {
            System.out.println("Adding two integers...");
            return a + b;
        }


        public int add(int a, int b, int c) {
            System.out.println("Adding three integers...");
            return a + b + c;
        }


        public double add(double a, double b) {
            System.out.println("Adding two double numbers...");
            return a + b;
        }


        public String add(String s1, String s2) {
            System.out.println("Concatenating two strings...");
            return s1 + s2;
        }

        public static void main(String[] args) {
            Overlord ol = new Overlord();


            int sum1 = ol.add(10, 20);
            System.out.println("Sum of two integers: " + sum1);


            int sum2 = ol.add(10, 20, 30);
            System.out.println("Sum of three integers: " + sum2);


            double sum3 = ol.add(10.5, 20.5);
            System.out.println("Sum of two doubles: " + sum3);


            String combinedString = ol.add("Hello, ", "World!");
            System.out.println("Combined string: " + combinedString);
        }
    }

