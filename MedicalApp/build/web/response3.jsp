<%-- 
    Document   : response3
    Created on : Dec 15, 2016, 9:12:26 AM
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
        <jsp:useBean id="researcherTrack" scope="session" class="app.Researcher" />
        <jsp:setProperty name="researcherTrack" property="username" />
        <jsp:setProperty name="researcherTrack" property="password"  />
        <jsp:setProperty name="researcherTrack" property="researcherID" />
        <jsp:setProperty name="researcherTrack" property="op" /> 
        
        <jsp:useBean id="subjectTrack" scope="session" class="app.Subject" />
        <jsp:setProperty name="subjectTrack" property="username" />
        <jsp:setProperty name="subjectTrack" property="password"  />
        <jsp:setProperty name="subjectTrack" property="subjectID" />
        <jsp:setProperty name="subjectTrack" property="op" /> 
        
        <h1>View subject number <%System.out.println(subjectTrack.getSubjectID());%> 's data </h1>
        
        <%
        System.out.println(subjectTrack.getSubjectID());
          if(researcherTrack.getOp()=="ViewData") {
                subjectTrack.view();
            }
            %>
            
        <form action="response3.jsp">
            <input type="hidden" name="op" value="ViewData" />
            <input type="submit" value="View" />
        </form>
    </body>
</html>
