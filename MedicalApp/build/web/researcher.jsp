<%-- 
    Document   : researcher.jsp
    Created on : Dec 13, 2016, 9:34:59 AM
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
        <h1>Look up subject's data</h1>

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
        
        <%
             if(researcherTrack.getOp().equals("createNewAccount")) {
              researcherTrack.createNewAccount();
            }
              java.util.ArrayList<app.Subject> al= researcherTrack.getAllSubjects();
               out.print("<table border=1><tr><th>SUBJECT ID</th></tr>");
               for(int i=0;i<al.size();i++){
                    out.print(al.get(i)+"");
               }
               out.print("</table>");
            if(researcherTrack.getOp().equals("ViewData")) {
                String output = subjectTrack.view();
                if(output==null)
                    out.print("no health data found");
                else
                    out.print(output);
            }
            %>
            <form action="researcher.jsp">
                <input type="hidden" name="op" value="ViewData" />
                <input type="submit" value="View" />
            </form>
                
    </body>
</html>
