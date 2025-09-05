public class ThreadMain {
    public static void main(String[] args) {
        int n=8;
        for(int i= 0; i<n;i++)
        {
            Theding obj = new Theding();
            obj.start();
        }
    }
}
