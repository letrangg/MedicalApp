<%-- 
    Document   : subject.jsp
    Created on : Nov 3, 2016, 9:04:03 PM
    Author     : Trang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1> Hi, let us know how you are doing today? </h1>
        <jsp:useBean id="subjectTrack" scope="session" class="app.Subject" />
        <jsp:setProperty name="subjectTrack" property="username" />
        <jsp:setProperty name="subjectTrack" property="password"  />
        <jsp:setProperty name="subjectTrack" property="subjectID" />
        <jsp:setProperty name="subjectTrack" property="op" /> 
        
        <jsp:useBean id="healthRecord" scope="session" class="app.HealthData" />
        <jsp:setProperty name="healthRecord" property="height" />
        <jsp:setProperty name="healthRecord" property="weight"  />
        <jsp:setProperty name="healthRecord" property="heartRate" />
        <jsp:setProperty name="healthRecord" property="hoursOfSleep" />
        <jsp:setProperty name="healthRecord" property="subjectID" />
        <jsp:setProperty name="healthRecord" property="date" />
        <jsp:setProperty name="healthRecord" property="op" /> 
            
        <%
        if(subjectTrack.getOp().equals("createNewAccount")) {
              subjectTrack.createNewAccount();
            }
     
        if(healthRecord.getOp().equals("enterData")) {
             healthRecord.enterData();
            }
        
            %>
                    
        <form action="subject.jsp">
            <table>
            <tr>
                <input type="text" name="subjectID" width="8" value="<% out.print(subjectTrack.getSubjectID());%>">
            </tr>
            <tr>
                <td> Height: </td>
                <td><input type="text" name="height" width="8"></td>
            </tr>
            <tr>
                <td> Weight: </td>
                <td><input type="text" name="weight" width=""></td>
            </tr>
            <tr>
                <td> Heart Rate: </td>
                <td><input type="text" name="heartRate" width="8"></td>
            </tr>
            <tr>
                <td> Hours of Sleep: </td>
                <td><input type="text" name="hoursOfSleep" width="8"></td>
            </tr>
            <tr>
                <td> Date Recorded: </td>
                <td><input type="text" name="date" width="8"></td>
            </tr>
            <tr>
                <td><input type="hidden" name="op" value="enterData">
                    <input type="submit" value="Save">
                </td>
            </tr>
            </table>                
        </form>
            
            <form action="response2.jsp">
                <input type="submit" name="next" value="next">
                
            </form>
            
        <%@page import="java.io.FileInputStream"%>
        <%@page import="java.io.File"%>
        <%@page import="java.io.InputStreamReader"%>
        <%@page import="java.net.URL"%>
        <%@page import="java.io.FileReader"%>
        <%@page import="java.io.BufferedReader"%>
        
    </body>
</html>
