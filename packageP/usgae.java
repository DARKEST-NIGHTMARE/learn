public class usgae {
    public static void main(String[] args) {
        user user1 = new user("hianem");
        System.out.println(user1.username);
        System.out.println(user1.email);
        System.out.println(user1.age);

        user user2 = new user("johan","faonf@hotnaik.com");
        System.out.println(user2.username);
        System.out.println(user2.email);
        System.out.println(user2.age);

 user user4 = new user();
        System.out.println(user4.age);

    }
}




// entity = guest having name, age, membership (BASIC, PRO)
// list - vips having pro membership
// welcome message
// enter guests:
// -- name input
// -- age input
// -- membership type basic or pro
// show output guest registered --show their details --, enter next guest or "exit" to stop entering
// enter name of vips
// -- name: XYZ
//if the name is a vip show vip found
// list to guest that can access vip room:
// list of PRO members or mentioned in VIP list [ {name, age, membership, vipx} ]