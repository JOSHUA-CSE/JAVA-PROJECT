package timetablemanagement.src;

import java.sql.*;

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
            String query="Insert into Teacher values(name,teacher_id,deapartment,phone_no)";
            stm.executeUpdate(query);
        }
        catch(SQLException e)
        {
            System.err.println("Insertion Failed");
        } 
    }
}
