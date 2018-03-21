/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package app;

import java.util.ArrayList;

/**
 *
 * @author Trang
 */
public class Subject {
    String username;
    String password;
    String subjectID;
    String op;

    public String getUsername() {
        return username;
    }

    public String getSubjectID() {
        DBA dba = new DBA();
        return dba.getSubjectID(username);
    }

    public String getOp() {
        return op;
    }

    public void setOp(String op) {
        this.op = op;
    }
    
    //ArrayList<HealthData>hd;
    //let subject create new account
    //also log in doesn't work
    public Subject(){}
    
    public Subject(String subjectID, String username, String password) {
        this.username = username;
        this.password = password;
        this.subjectID = subjectID;
    }
    
    public boolean userCheck() {
       DBA dba = new DBA();
       return dba.userCheck(username, password);
    }
    
    public void createNewAccount() {
        DBA dba = new DBA();
        //System.out.println("new account!");
        dba.insertSubject(username,password);
    }
    
    public void setUsername(String username) {
        this.username = username;
    }

    public void setSubjectID(String subjectID) {
        this.subjectID = subjectID;
    }
    
    //todo: include reaction and questionnaire example, email dr Cagle
    public Subject(String username, String password) {
        this.password = password;
        this.username = username;
        //hd = new ArrayList<>();
    }
    
    public void addHealthData(HealthData d) {
        //hd.add(d);
    }
    /**
     * @return the userName
     */
    public String getUserName() {
        return username;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String username) {
        this.username = username;
    }

   
    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String view() {
        DBA dba = new DBA();
        
       return dba.searchForSubject(subjectID).toString();
    }

    public String toString() {
        return "<tr><td>" + subjectID + "</td><td><a href='researcher.jsp?op=ViewData&subjectID="+subjectID+"'>ViewData</a>";
    }
    
    public static void main(String args[]) {
        Subject s1 = new Subject("Alex","1234");
        //s.createNewAccount();
        //System.out.println(s1.userCheck());
        Subject s2 = new Subject("Jim","etc");
        //s2.createNewAccount();
        Subject s3 = new Subject("Missy","pwd");
        System.out.println(s1.getSubjectID());
        s1.view();
        System.out.println(s1.view());
    }
}
