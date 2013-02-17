
package model;

public class centre {
    private String centre_id;
    private String name;
    private String location;
    public centre(String centre_id,String name,String location){
        this.centre_id=centre_id;
        this.location=location;
        this.name=name;
    }
    public String get_centre_id(){
        return centre_id;
    }
    public String get_name(){
        return name;
    }
    public String get_location(){
        return location;
    } 
    
}
