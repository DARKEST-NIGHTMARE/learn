public class Theding2Main {
    public static void main(String[] args) {
        int n = 8;
        for(int i = 0;i <n;i++){
            Thread obj = new Thread(new Theding2());
            obj.start();
        }
    }
}
