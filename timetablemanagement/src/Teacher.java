package timetablemanagement.src;

import java.sql.*;

class teacher{
    String name;
    int teacher_id;
    String deapartment;
    String phone_no;
    teacher(String name, int id,String Deapartment, String phone_no){
        this.name = name;
        this.teacher_id = id;
        this.deapartment = Deapartment;
        this.phone_no = phone_no;
        
    }void displayTeacherDetails(){
        System.out.println("Name:"+name);
        System.out.println("ID:"+teacher_id);
        System.out.println("Deapartment:"+deapartment);
        System.out.println("Phone No:"+phone_no);
    }
    void getTimetable(){
        System.out.println("Timetable of "+name);
    }void addtodatabase(Connection con)
    {   
        try
        {
             if(con==null){
                System.err.println("Add Teacher Failed");
                return;
            }
            Statement stm=con.createStatement();
            String query=String.format(
                "INSERT INTO Teacher(teacher_id, name, department, phone_no) VALUES (%d, '%s', '%s', '%s')",
                teacher_id, name, deapartment, phone_no);
            stm.executeUpdate(query);
        }
        catch(SQLException e)
        {
            System.err.println("Insertion Failed");
            e.printStackTrace();
        }

    }
}
