public class Classroom {
    private String className;
    private String[] students;

    public Classroom (String className,String []students){
        this.className=className;
        this.students=students;

    }
    public void printClassroom(){
        System.out.println("Classname"+className);
        System.out.println("Students"+students);
        for (String stud :students)
        {
            System.out.println(stud+"");

        }
        System.out.println();
    }

}
