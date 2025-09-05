public class user {
    String username;
    String email;
    int age;

    user(String username){
        this.username = username;
        this.email = "not provided";
        this.age = 0;


    }
    user(){
        this.username = "guest";
        this.email = "not provided";
    }
    user(String username,String email){
        this.username = username;
        this.email = email;
        this.age = 0;


    }
}
