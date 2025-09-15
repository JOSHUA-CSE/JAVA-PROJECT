import java.util.*;
class Teacher{
    String name;
    int teacher_id;
    String deapartment;
    Teacher(String name, int id,String Deapartment){
        this.name = name;
        this.teacher_id = id;
        this.deapartment = Deapartment;
    }void displayTeacherDetails(){
        System.out.println("Name: "+name);
        System.out.println("ID: "+teacher_id);
        System.out.println("Deapartment: "+deapartment);
    }
}public class section{
    String name;
    String id;
    section(String name, String id){
        this.name = name;
        this.id = id;
    }
}
class schedule{
    String subject;
    String time;
    String day;
    Teacher teacher;
    Section section;
    schedule(String subject, String time){
        this.subject = subject;
        this.time = time;
    }
}
public class Timetable {   
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    }
}