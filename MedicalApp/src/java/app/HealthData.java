/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.util.Date;

/**
 *
 * @author Trang
 */
public class HealthData {
    
    String subjectID;
    int weight;
    int height;
    String op;
    int heartRate;
    int hoursOfSleep;
    String date;
    
    public String getOp() {
        return op;
    }

    public void setOp(String op) {
        this.op = op;
    }

    public void setHeartRate(int heartRate) {
        this.heartRate = heartRate;
    }

    public void setHoursOfSleep(int hoursOfSleep) {
        this.hoursOfSleep = hoursOfSleep;
    }

    //time to fall back to sleep, to stay asleep
    //int fallAsleep;
    //int stayAsleep;
    //int fallBacktoSleep;
    public void setDate(String date) {
        this.date = date;
    }
   
    
    public void setSubjectID(String subjectID) {
        this.subjectID = subjectID;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public HealthData(){}    
    public HealthData(String subjectID, int weight, int height,
            int heartRate, int hoursOfSleep,String date) {
        this.subjectID = subjectID;
        this.weight = weight;
        this.height = height;
        this.heartRate = heartRate;
        this.hoursOfSleep = hoursOfSleep;
        this.date = date;
    }
    
    public void enterData() {
        DBA dba = new DBA();
        dba.enterData(subjectID, height, weight, heartRate, hoursOfSleep, date);
    }
    
    public String toString() {
        return "<table><tr><td>SubjectID </td><td>" + subjectID + 
                "</td></tr>"
                + "<tr><td>Height</td><td>" + height + "</td></tr>"
                + "<tr><td>Weight</td><td>" + weight + "</td></tr>"
                + "<tr><td>Heart Rate</td><td>" + heartRate + "</td></tr>"
                + "<tr><td>Hours of Sleep</td><td>" + hoursOfSleep + "</td></tr>"
                + "<tr><td>Date</td><td>" + date.toString() + "</td></tr></table>";
    }
     
    public static void main(String args[]) {
        HealthData hd = new HealthData("47120", 180, 80, 110, 8, "2016-07-09");
        hd.enterData();
        System.out.println(hd);
    }
}
