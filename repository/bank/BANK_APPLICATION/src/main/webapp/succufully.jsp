<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% Class.forName("com.mysql.cj.jdbc.Driver");
   Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","root");
   Statement st = con.createStatement();
   ResultSet rs = st.executeQuery("select * from account");
%>
<h1 align="center"><u>ABC Bank Account_Holder</u></h1>
<table cellpading="40px" align="center" border="5">
    <th>Id</th>
    <th>Name</th>
    <th>Age</th>
    <th>Account_no</th>
     <th>Pin</th>
    <th>Balance</th>
    <% while(rs.next()) { %>
        <tr>
            <td><%= rs.getInt(1) %></td>
            <td><%= rs.getString(2) %></td>
             <td><%= rs.getInt(3) %></td>
              <td><%= rs.getLong(4) %></td>
              <td><%= rs.getInt(5) %></td>
            <td><%= rs.getDouble(6) %></td>
        </tr>
    <% } %>
</body>
</html>