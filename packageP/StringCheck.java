public class StringCheck {
    static boolean check(String search,String...strings)
    {
for(String s1 :strings){
    if(s1.equalsIgnoreCase(search)){
        return true;
    }
}return false;
    }

    public static void main(String[] args)
        {
            boolean exists= check("red","Red","Yellow","Orange");
            System.out.println("String searched "+exists);
        }

}
