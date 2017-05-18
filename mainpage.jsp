<%-- 
    Document   : mainpage
    Created on : 18.05.2017, 14:06:24
    Author     : DMyrzaka
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        KEMP IP ADDRESS 
        <% 
        String ipadress=request.getRemoteAddr();
        
       out.print(ipadress);
        
        %><br>
        REAL IP ADRESS X-FORWARD
        <% 
        String ipadressxforward=request.getHeader("X-FORWARDED-FOR");
        out.print(ipadressxforward);
        
        %>
    </body>
</html>
