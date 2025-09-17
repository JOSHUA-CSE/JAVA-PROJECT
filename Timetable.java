import java.util.*;
class Teacher{
    String name;
    int teacher_id;
    String deapartment;
    String phone_no;
    Teacher(String name, int id,String Deapartment, String phone_no){
        this.name = name;
        this.teacher_id = id;
        this.deapartment = Deapartment;
        this.phone_no = phone_no;
    }void displayTeacherDetails(){
        System.out.println("Name: "+name);
        System.out.println("ID: "+teacher_id);
        System.out.println("Deapartment: "+deapartment);
        System.out.println("Phone No: "+phone_no);
    }void getTimetable(){
        System.out.println("Timetable of "+name);
    }
}class schedule{
    String subject;
    String time;
    String day;
    Teacher teacher;
    schedule(String subject, String time,String day, Teacher teacher){
        this.subject = subject;
        this.time = time;
        this.day = day;
        this.teacher = teacher;
    }
}
class SectionA extends schedule{
    ArrayList<schedule> timetable = new ArrayList<>();
    SectionA()
    {
        super("","","",null);
    }
    void addToTimetable(schedule s){
        timetable.add(s);
    }
    void getSectionDetails(){
        System.out.println("Section A Details");
        for(schedule s : timetable){
            System.out.println("Subject: "+s.subject+", Time: "+s.time+", Day: "+s.day+", Teacher: "+s.teacher.name);
        }
    }
}class SectionB extends schedule{
    ArrayList<schedule> time_table = new ArrayList<>();
    SectionB()
    {
        super("","","",null);
    }void addToTimetable(schedule s){
        time_table.add(s);
    }void getSectionDetails(){
        System.out.println("Section B Details");
        for(schedule s : time_table){
            System.out.println("Subject: "+s.subject+", Time: "+s.time+", Day: "+s.day+", Teacher: "+s.teacher.name);
        }
    }
}

public class Timetable {   
    boolean isConflict(Teacher t, String time, String day, SectionA sectionA, SectionB sectionB)
    {
        for (schedule s : sectionA.timetable) {
            if (s.teacher.teacher_id == t.teacher_id && s.time.equals(time) && s.day.equals(day)) {
                return true;
            }
        }
        for (schedule s : sectionB.time_table) {
            if (s.teacher.teacher_id == t.teacher_id && s.time.equals(time) && s.day.equals(day)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice=0;
        ArrayList<Teacher> teachers = new ArrayList<>();
        while(choice!=6){
            System.out.println("1. Add Teacher\n2. Add Schedule\n3.View Teachers\n4. View section Timetable\n5. View Teachers Timetable\n6. Exit");
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
                    System.out.print("Enter Phone No: ");
                    String phone_no = sc.next();
                    teachers.add(new Teacher(name, id, deapartment,phone_no));
                    break;
                case 2:
                    System.out.print("Enter Subject: ");
                    String subject = sc.next();
                    System.out.print("Enter Time: ");
                    String time = sc.next();
                    System.out.print("Enter Day: ");
                    String day = sc.next();
                    System.out.print("Enter Teacher ID: ");
                    int tid = sc.nextInt();
                    Teacher t = null;
                    for(Teacher teacher : teachers){
                        if(teacher.teacher_id == tid){
                            t = teacher;
                            break;
                        }
                    }
                    if(t == null){
                        System.out.println("Teacher not found!");
                        break;
                    }
                    System.out.print("Enter Section (A/B): ");
                    String sectionType = sc.next();
                    if(sectionType.equalsIgnoreCase("A")){
                        SectionA section_A=new SectionA();
                        if(new Timetable().isConflict(t, time, day, section_A, new SectionB())){
                            System.out.println("Schedule conflict for the teacher at the given time and day.");
                        }else
                        {
                            section_A.addToTimetable(new schedule(subject, time, day, t));
                        }
                    }else if(sectionType.equalsIgnoreCase("B")){
                        SectionB section_B=new SectionB();
                        if(new Timetable().isConflict(t, time, day, new SectionA(), section_B)){
                            System.out.println("Schedule conflict for the teacher at the given time and day.");
                        }else
                        {
                            section_B.addToTimetable(new schedule(subject, time, day, t));
                        }
                    }else{
                        System.out.println("Invalid Section Type!");
                        break;
                    }
                    break;
                case 3:
                    for(Teacher teacher : teachers){
                        teacher.displayTeacherDetails();
                        System.out.println();
                    }
                    break;
                case 4:
                    System.out.print("Enter Section (A/B) to view Timetable: ");
                    String secType = sc.next();
                    if(secType.equalsIgnoreCase("A")){
                        SectionA section=new SectionA();
                        section.getSectionDetails();
                    }else if(secType.equalsIgnoreCase("B")){
                        SectionB section=new SectionB();
                        section.getSectionDetails();
                    }else{
                        System.out.println("Invalid Section Type!");
                    }
                case 5:
                    System.out.print("Enter Teacher ID to view Timetable: ");
                    int t_id = sc.nextInt();
                    boolean found = false;
                    for(Teacher teacher : teachers){
                        if(teacher.teacher_id == t_id){
                            teacher.getTimetable();
                            found = true;
                            break;
                        }
                    }break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}