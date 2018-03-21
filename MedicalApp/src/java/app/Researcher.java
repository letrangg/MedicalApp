/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import static java.lang.System.out;
import java.util.ArrayList;

/**
 *
 * @author Trang
 */
public class Researcher {
    String username;
    String password;
    String researcherID;
    String subjectID;
    String op;

    public void setResearcherID(String researcherID) {
        this.researcherID = researcherID;
    }

    public void setOp(String op) {
        this.op = op;
    }
   
    //ArrayList<SurveyQuestion> sq;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getResearcherID() {
        return researcherID;
    }

    public String getOp() {
        return op;
    }
    
    public Researcher() {}
    
    public Researcher(String researcherID, String uname, String pw) {
        this.researcherID = researcherID;
        this.username = uname;
        this.password = pw;
    }
    
    public boolean userCheck() {
        DBA dba = new DBA();
        return dba.userCheck(username,password);
    }
    
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

   // public void setSq(ArrayList<SurveyQuestion> sq) {
     //   this.sq = sq;
    //}
    String viewData(String subjectID) {
        //Subject;
        return "a";
    }

    
  //    oid addQuestion(SurveyQuestion question) {
    //    sq.add(question);
    //}
    public void createNewAccount() {
        DBA dba = new DBA();
        //System.out.println("new account!");
        dba.insertResearcher(username,password);
    }
    
    public String view() {
        DBA dba = new DBA();
        return dba.searchForSubject(subjectID).toString();
    }
    
    public ArrayList<Subject> getAllSubjects() {
        DBA dba = new DBA();
        return dba.getListofSubjects();
    }
    
    HealthData searchForSubject(String subjectID) {
        DBA dba = new DBA();
        return dba.searchForSubject(subjectID);
    }

    public static void main(String args[]) {
        Researcher rs = new Researcher();
        
          java.util.ArrayList<app.Subject> al= rs.getAllSubjects();
               out.print("<table border=1><tr><th>SUBJECT ID</th></tr>");
               for(int i=0;i<al.size();i++){
                    out.print(al.get(i)+"");
               }
               out.print("</table>");
    }
    
    
}   
