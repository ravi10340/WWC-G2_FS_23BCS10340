import java.util.*;

class Student{
    private String id,name;
    private int marks;

    public Student(String id, String name ,int marks){
        this.id = id;
        this.name = name;
        this.marks =marks;
    }
    public String getId(){
        return id;
    }
    public int getMarks(){
        return marks;
    }
    public String getName(){
        return name;
    }


    public String getRole(){
        return " undergrad";
    }
    @Override
    public String toString(){
        return id+ "" + name +" (" + marks +")" + getRole();
    }
    public void generateReport(){
        System.out.println("Report");
        System.out.println("Student ID   : " + getId());
        System.out.println("Student Name :" + getName());
        System.out.println("Marks        : " + getMarks());
        String grade;

        int m = getMarks();
        if(m >= 90) grade = "Excellent";
        else if(m >= 75) grade = "Good";
        else if(m >= 50) grade = "Average";
        else grade = "Poor";
        System.out.println("Performance  : " + grade);
    }
}
class GraduateStudent extends  Student{
    private  String area;

    public GraduateStudent(String id, String name, int marks, String area){
        super(id,name,marks);
        this.area = area;
    }

    @Override
    public String getRole(){
        return " Grad ( "+area+" )";
    }
}
class Teacher {
    private String name;
    private String dept;

    public Teacher(String name, String dept){
        this.name = name;
        this.dept = dept;
    }
    public void teach(){
        System.out.println("Name : " + name + " , Department : " + dept);
    }
}


class Repository<T> {
    private Map<String,T> data = new HashMap<>();
    
    public void save(String id,T obj){
        data.put(id,obj);
    }
    public T find(String id){
        return data.get(id);
    }
    public void delete(String id){
        data.remove(id);
    }
}
public class Main {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student("S1"," Ravi    ",82));
        list.add(new Student("S2"," Ritik   ",94));
        list.add(new Student("S3"," Pratyush",90));
        list.add(new Student("S4"," Piyush  ",79));
        list.add(new GraduateStudent("G1 ","Rohit   ",89,"CSE"));

        Repository<Student> repo = new Repository<>();
        for (Student s:list) {
            repo.save(s.getId(),s);
        }

        System.out.println("ALL : ");
        list.forEach(System.out::println);

        System.out.println("\nLOOKUP S2 : ");
        Student s = repo.find("S2");
        System.out.println(s != null ? s:"Not Found");

        Iterator<Student> it = list.iterator();
        while(it.hasNext()){
            Student st = it.next();

            if(st.getMarks() <85){
                it.remove();
                repo.delete(st.getId());
            }
        }
        System.out.println("\nAFTER REMOVAL : ");
        list.forEach(System.out::println);
        System.out.println();

        Teacher t = new Teacher("RAVI", "CSE");
        t.teach();
        System.out.println();

        Student str = repo.find("S2");
        str.generateReport();
    }
}
