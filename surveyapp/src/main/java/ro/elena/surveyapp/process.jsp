<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*,java.util.*"%>

<%
 String INTREBARE_A =request.getParameter("INTREBARE_A");
    String INTREBARE_B=request.getParameter("INTREBARE_B");
    String INTREBARE_C=request.getParameter("INTREBARE_C");
    String INTREBARE_D=request.getParameter("INTREBARE_D");
    String INTREBARE_E=request.getParameter("INTREBARE_E");
    String RASPUNS_FREE_TEXT=request.getParameter("RASPUNS_FREE_TEXT");


try
{
Class.forName("com.mysql.jdbc.Driver");
Connection conn = DriverManager.getConnection("jdbc:mysql://104.248.84.92:3306/survey2", "java", "");
Statement st=conn.createStatement();

int i=st.executeUpdate("insert into survey2.raspunsuri((null, NOW(), INTREBARE_A, INTREBARE_B,  INTREBARE_C, INTREBARE_D, INTREBARE_E, RASPUNS_FREE_TEXT)values('"+INTREBARE_A+"','"+INTREBARE_B+"','"+INTREBARE_C+"','"+INTREBARE_D+"', '"+INTREBARE_E+"', '"+RASPUNS_FREE_TEXT+"');
out.println("Data is successfully inserted!");
}
catch(Exception e)
{
System.out.print(e);
e.printStackTrace();
}
%>