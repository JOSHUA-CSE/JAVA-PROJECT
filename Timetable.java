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
    }void getTimetable(){
        System.out.println("Timetable of "+name);
    }
}public class SectionA{
    String name;
    String id;
    SectionA(String name, String id){
        this.name = name;
        this.id = id;
    }
}public class SectionB{
    String name;
    String id;
    SectionB(String name, String id){
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
        int choice=0;
        ArrayList<Teacher> teachers = new ArrayList<>();
        ArrayList<schedule> schedules = new ArrayList<>();
        while(choice!=4){
            System.out.println("1. Add Teacher\n2. View Teachers\n3. View Timetable\n4. View Teachers Timetable\n5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            switch(choice){
                case 1:
                    System.out.print("Enter Teacher Name: ");
                    String name = sc.next();
                    System.out.print("Enter Teacher ID: ");
                    int id = sc.nextInt();
                    System.out.print("Enter Deapartment: ");
                    String deapartment = sc.next();
                    teachers.add(new Teacher(name, id, deapartment));
                    break;
                case 2:
                    for(Teacher t : teachers){
                        t.displayTeacherDetails();
                        System.out.println();
                    }
                    break;
                case 3:
                    for(Teacher t : teachers){
                        t.getTimetable();
                        System.out.println();
                    }
                    break;
                case 4:
                    System.out.print("Enter Teacher ID to view Timetable: ");
                    int tid = sc.nextInt();
                    boolean found = false;
                    for(Teacher t : teachers){
                        if(t.teacher_id == tid){
                            t.getTimetable();
                            found = true;
                            break;
                        }
                    }
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}