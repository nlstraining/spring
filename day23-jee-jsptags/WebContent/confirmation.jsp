<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Confirmation Page</title>
</head>
<body>

 
<jsp:useBean id="actBean"  class="com.nsl.mvc.AccountBean" scope="request" >
 
 </jsp:useBean>

          <jsp:getProperty   name="actBean" property="actno"  /> <br/>
          <jsp:getProperty name="actBean" property="name" /> <br/>
          <jsp:getProperty name="actBean" property="balance"/>  <br/>
          
          

</body>
</html>