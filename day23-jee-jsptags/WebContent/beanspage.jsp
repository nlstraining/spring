<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>beans page</title>
</head>

 
 
 
</ol></h2>
 <!-- standard action tags AccountBean bean = new AccountBean();   -->
 <jsp:useBean id="actBean"  class="com.nsl.mvc.AccountBean" scope="request" >
 
 </jsp:useBean>


   <jsp:setProperty property="actno" name="actBean" param="actid" />
   <jsp:setProperty property="name"  name="actBean" param="uname" />
   <jsp:setProperty property="balance" name="actBean" param="balance" />
   
   <jsp:forward page="/account"></jsp:forward>
   
<body> 

</body>
</html>