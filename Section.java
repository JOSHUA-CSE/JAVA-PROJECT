package second;
import java.util.*;

class Section
{
    String s_name;
    Map<String,Section> sections=new HashMap<>();
    List<schedule> schedules=new ArrayList<>();
    String Section(String name)
    {
        s_name=name;
    }void addnewSection(String name)
    {
        sections.put(name,this);
    }
    void addtimetable(schedule s)
    {
        schedules.add(s);
    }boolean isConflict(int id, String time, String day)
    {
        for (schedule s : schedules) {
            if (s.teacher.teacher_id == id && s.time.equals(time) && s.day.equals(day)) {
                return true;
            }
        }
        return false;
    }
    
}