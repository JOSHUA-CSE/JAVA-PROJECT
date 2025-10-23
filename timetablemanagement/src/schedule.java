package timetablemanagement.src;

class schedule{
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