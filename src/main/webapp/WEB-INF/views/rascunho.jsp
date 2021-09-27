<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="pt-br">
   <head>
      <meta charset="UTF-8">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <link rel="stylesheet" href="resources/css/login.css">
      
      <title>Tarefas</title>
   </head>
   
   <body>
      
      <c:forEach var="i" begin="0" end="7">
         <p>${i}</p>
      </c:forEach>
      
      
   </body>
</html>