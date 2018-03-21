/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Trang
 */
public class DBA {
    Connection conn;
    String url="jdbc:derby://localhost:1527/subjectDatabase";
    String username = "username";
    String password = "abc";
    
    void connect() {
        try {
            //Class.forName(org.apache.derby.jdbc.ClientDriver)
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            conn = DriverManager.getConnection(url,username,password);
        } catch(Exception e) {
            System.out.println("exception");
            e.printStackTrace();
        }
    }
    
    void modify(String username, String newPasswd) {
        connect();
        try {
            Statement st = conn.createStatement();
            String query = "update subject set password ='" + newPasswd + "' where username=" + username;
            st.execute(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void insertSubject(String newUserName, String newPasswd) {
        connect();
        System.out.println(conn);
        try {
            Statement stmt = conn.createStatement();
            Random r = new Random();
            int ID = r.nextInt()%10000 + 40000;
            String query = "insert into subject(subjectID, username, password) values "
                    + "('" + ID + "','"+newUserName + "','"+newPasswd+"'" + ")";
            System.out.println(query);
            stmt.execute(query);
        }   catch (Exception e) {
           e.printStackTrace();
        } 
    }
    
    public void insertResearcher(String newUserName, String newPasswd) {
        connect();
        System.out.println(conn);
        try {
            Statement stmt = conn.createStatement();
            Random r = new Random();
            int ID = r.nextInt()%10000 + 40000;
            String query = "insert into researcher(subjectID, username, password) values "
                    + "('" + ID + "','"+newUserName + "','"+newPasswd+"'" + ")";
            System.out.println(query);
            stmt.execute(query);
        }   catch (Exception e) {
           e.printStackTrace();
        } 
    }
    /**
     *
     * @param subjectID
     * @param height
     * @param weight
     * @param heartRate
     */
    public void enterData(String subjectID, int height, int weight, int heartRate, int hoursOfSleep, String date) {
        connect();
        System.out.println(conn);
        try {
            Statement stmt = conn.createStatement();
            String query = "insert into healthdata(subjectID, height, weight, heartRate, hoursOfSleep, date) values " + "("
                    + "'" + subjectID + "'," + height + "," + weight + "," + heartRate + ","
                    + hoursOfSleep + "," + "'"+ date + "')";
            System.out.println(query);
            stmt.execute(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void enterHeight(int height, String subjectID) {
        connect();
        System.out.println(conn);
        try {
            Statement stmt = conn.createStatement();
            String query = "insert into healthdata(height) values " + "("
                    + height + ") where subjectID = '" + subjectID + "'";
            System.out.println(query);
            stmt.execute(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    //public void enterWeight(int weight, String subjectID) {
      //  connect();
        //System.out.println(conn);
        //try {
          //  Statement stmt = conn.createStatement();
           // String query = "insert into healthdata(weight) values " + "("
            //        + weight + ") where subjectID = '" + subjectID + "'";
            //System.out.println(query);
            //stmt.execute(query);
        //} catch (Exception e) {
         //   e.printStackTrace();
       // }
   // }
   
    ArrayList<Subject> getListofSubjects() {
        connect();
        ArrayList<Subject> al = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            String query = "select * from username.subject";
            ResultSet rs = stmt.executeQuery(query);
            rs.next();
            while(rs.next()) {
                al.add(new Subject(rs.getString(1),rs.getString(2),rs.getString(3)));
            }
            return al;
        } catch(Exception e) {
            e.printStackTrace();
        } 
        return al;
    }
   
    void delete(String username, String password) {
        connect();
        try {
            Statement stmt = conn.createStatement();
            String query = "delete from subject where username= " + username;
            stmt.execute(query);
            System.out.println(query);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    boolean userCheck(String username, String password) {
        connect();
        try {
            Statement stmt = conn.createStatement();
            String query = "select * from subject where username ='" + username + "'";
            ResultSet rs = stmt.executeQuery(query);
            rs.next();
            System.out.println(rs.getString(3));
            return rs.getString(3).equals(password);
        } catch(Exception e) {
            return false;
        }
    }
    
    String getSubjectID(String username) {
        connect();
        try {
            Statement stmt = conn.createStatement();
            String query = "select * from subject where username ='" + username + "'";
            ResultSet rs = stmt.executeQuery(query);
            rs.next();
            return rs.getString(1);
        } catch(Exception e) {
            return null;
        }
    }
    
    HealthData searchForSubject(String subjectID) {
        connect();
        try {
            Statement stmt = conn.createStatement();
            String query = "select * from healthdata where subjectID ='" + subjectID + "'";
            System.out.println(query);
            ResultSet rs = stmt.executeQuery(query);
           
            rs.next();
            
            //System.out.println(rs.getString(1));
            //System.out.println(rs.getString(2));
            //System.out.println(rs.getString(3));
            //System.out.println(rs.getString(4));
            HealthData hd = new HealthData(rs.getString(1),rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getString(6));
            //System.out.println(hd);
            //System.out.println("meo!");
            return hd;
            
            
        } catch(Exception e) {
             e.printStackTrace();
             return null;
        }
    } 
    
    /**
     *
     * @param args debug 
     */
    public static void main(String args[]) {
        DBA dba= new DBA();
        dba.insertSubject("Nick", "abc");
        System.out.println(dba.searchForSubject("47120"));
        ArrayList<Subject> al = dba.getListofSubjects();
        System.out.println(al.get(0));
        System.out.println(dba.userCheck("Alex","1234"));
    }
}
