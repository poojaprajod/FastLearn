
package model;

public class student {
    private String student_id;
    private String first_name;
    private String last_name;
    private String course_id;
    private String faculty_id;
    private String centre_id;
    private long phone;
    private String address;
    
    public student(String student_id,String first_name,String last_name,String course_id,String faculty_id,String centre_id,long phone,String address){
        this.student_id=student_id;
        this.first_name=first_name;
        this.last_name=last_name;
        this.course_id=course_id;
        this.faculty_id=faculty_id;
        this.centre_id=centre_id;
        this.phone=phone;
        this.address=address;
    }
    public String get_student_id(){
        return student_id;
    }
    public String get_first_name(){
        return first_name;
    }
    public String get_last_name(){
        return last_name;
    }
    public String get_course_id(){
        return course_id;
    }
    public String get_faculty_id(){
        return faculty_id;
    }
    public String get_centre_id(){
        return centre_id;
    }
    public String get_address(){
        return address;
    }
    public long get_phone(){
        return phone;
    }
}
