
package model;

public class faq {
    private String query;
    private String solution;
    public faq(String query,String solution){
        this.query=query;
        this.solution=solution;
    }
    public String get_query(){
        return query;
    }
    public String get_solution(){
        return solution;
    }
}
