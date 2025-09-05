//import java.util.Scanner;
//
//public class GuestManagement {
//
//
//    public enum Membership {
//        BASIC, PRO
//    }
//
//    public static class Guest {
//        private String name;
//        private int age;
//        private Membership subscription;
//
//        public Guest(String name, int age, Membership membership) {
//            this.name = name;
//            this.age = age;
//            this.subscription = membership;
//        }
////
////        public String getName() {
////            return name;
////        }
////
////        public int getAge() {
////            return age;
////        }
////
////        public Membership getMembership() {
////            return subscription;
////        }
////
////        public String getDetails() {
////            return "Name: " + name + ", Age: " + age + ", Membership: " + subscription;
////        }
//    }
//
//    public static void main(String[] args) {
//        Scanner ns = new Scanner(System.in);
//        String [] guests = new String[];
//        String [] viplist = new String[];
//
//        System.out.println("Welcome \uD83D\uDE34");
//
//
//        System.out.println("Enter VIP names (type 'done' to finish):");
//        for (int i =0; ;i++){
//            System.out.print("VIP Name: ");
//            String vipName = ns.nextLine();
//            if (vipName.equalsIgnoreCase("done")) {
//                break;
//            }
//            viplist[i] = vipName;
//        }
//
//
//        for (int i = 0;;i++){
//            System.out.println("\nEnter guest details (type 'exit' for name to stop):");
//            System.out.print("Name: ");
//            String name = ns.nextLine();
//
//            if (name.equalsIgnoreCase("exit")) {
//                break;
//            }
//
//            System.out.print("Age: ");
//            int age = ns.nextInt();
//            ns.nextLine();
//
//            System.out.print("Membership type (BASIC/PRO): ");
//            String membershipType = ns.nextLine().toUpperCase();
//            Membership membership = Membership.valueOf(membershipType);
//
//            Guest guest = new Guest(name, age, membership);
//            registeredGuests.add(guest);
//
//            System.out.println("Guest registered: " + );
//        }
//
//
//        System.out.println("\nPeople that can access the VIP room (PRO members or on VIP list):");
//        for (Guest guest : registeredGuests) {
//            boolean isVIP = vipList.contains(guest.getName());
//            if (guest.getMembership() == Membership.PRO || isVIP) {
//                System.out.print("{ " + guest.getDetails());
//                if (isVIP) {
//                    System.out.print(", VIP: Yes");
//                }
//                System.out.println(" }");
//            }
//        }
//          for (String vip : vipList)
//          {
//              System.out.println(vip);;          }
//        ns.close();
//    }
//}
