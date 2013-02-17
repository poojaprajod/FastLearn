
package model;

public class course {
    private String course_id;
    private String name;
    private long fee;
    private String prerequisite;
    private int duration;
    public course(String course_id,String name,long fee,String prerequisite,int duration){
        this.course_id=course_id;
        this.duration=duration;
        this.fee=fee;
        this.name=name;
        this.prerequisite=prerequisite;
    }
    public String get_course_id(){
        return course_id;
    }
    public String get_name(){
        return name;
    }
    public String get_prerequisite(){
        return prerequisite;
    }
    public long get_fee(){
        return fee;
    }
    public int get_duration(){
        return duration;
    }
    
}
